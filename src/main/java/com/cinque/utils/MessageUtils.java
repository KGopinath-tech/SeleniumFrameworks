package com.cinque.utils;

import com.cinque.config.Configfactory;
import com.cinque.driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

import static com.cinque.utils.DataUtils.getExpectedMessagesFromExcel;

public class MessageUtils {

    private static final By TOAST_MESSAGE           = By.xpath("//div[contains(@class,'toast')]");
    private static final int WAIT_TIME              = Math.toIntExact(Configfactory.getConfig().timeout());
    private static final int STALE_RETRY_SLEEP_MS   = 300;
    private static final int TOAST_POLL_INTERVAL_MS = 200;
    private static final int TOAST_MAX_WAIT_MS      = 35_000; // covers your 20-30s toast lifetime

    private static final By       NGX_SPINNER_TAG           = By.tagName("ngx-spinner");
    private static final Duration SPINNER_APPEAR_TIMEOUT    = Duration.ofSeconds(5);
    private static final Duration SPINNER_DISAPPEAR_TIMEOUT = Duration.ofSeconds(30);

    // JS scripts — immune to StaleElementReferenceException
    private static final String JS_GET_TOAST_HEADER = """
        var toasts = document.querySelectorAll("div[class*='toast']");
        if (!toasts || toasts.length === 0) return null;
        var toast = toasts[toasts.length - 1];
        var hdr = toast.querySelector("div[class*='title']");
        if (hdr && hdr.innerText.trim() !== '') return hdr.innerText.trim();
        var lines = toast.innerText.trim().split('\\n');
        return lines.length > 0 ? lines[0].trim() : null;
        """;

    private static final String JS_GET_TOAST_FULL_TEXT = """
        var toasts = document.querySelectorAll("div[class*='toast']");
        if (!toasts || toasts.length === 0) return null;
        var text = toasts[toasts.length - 1].innerText.trim();
        return text !== '' ? text : null;
        """;

    // ─── Driver helpers ────────────────────────────────────────────────────────────
    private static WebDriverWait getWait() {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_TIME));
    }

    private static JavascriptExecutor getJs() {
        return (JavascriptExecutor) DriverManager.getDriver();
    }

    // ─── Spinner Guard (called ONCE per public entry-point, never inside workers) ──
    public static void waitForNgxSpinner() {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait appearWait    = new WebDriverWait(driver, SPINNER_APPEAR_TIMEOUT);
        WebDriverWait disappearWait = new WebDriverWait(driver, SPINNER_DISAPPEAR_TIMEOUT);

        boolean spinnerAppeared = false;
        try {
            appearWait.until(ExpectedConditions.visibilityOfElementLocated(NGX_SPINNER_TAG));
            spinnerAppeared = true;
            System.out.println("Spinner detected — waiting for it to disappear...");
        } catch (TimeoutException ignored) {
            System.out.println("Spinner did not appear — skipping wait.");
        }

        if (spinnerAppeared) {
            try {
                disappearWait.until(
                        ExpectedConditions.invisibilityOfElementLocated(NGX_SPINNER_TAG));
                System.out.println("Spinner disappeared — proceeding.");
            } catch (TimeoutException e) {
                System.out.println("WARNING: Spinner still visible after "
                        + SPINNER_DISAPPEAR_TIMEOUT.getSeconds() + "s — proceeding anyway.");
            }
        }
    }

// ─── Internal JS poller — NO spinner call, called only after guard ─────────────
    /**
     * Polls JavaScript every TOAST_POLL_INTERVAL_MS until the script returns
     * non-blank text OR TOAST_MAX_WAIT_MS elapses.
     *
     * Never holds a WebElement → zero risk of StaleElementReferenceException.
     * Reads innerText directly → works during CSS fade-in and fade-out animations.
     */
    private static String pollToastViaJs(String jsScript, String label) {
        long deadline = System.currentTimeMillis() + TOAST_MAX_WAIT_MS;
        int  attempt  = 0;

        while (System.currentTimeMillis() < deadline) {
            attempt++;
            try {
                Object result = getJs().executeScript(jsScript);
                if (result instanceof String text && !text.isBlank()) {
                    System.out.println("[Toast:" + label + "] found on attempt "
                            + attempt + ": " + text);
                    return text.trim();
                }
            } catch (Exception e) {
                System.out.println("[Toast:" + label + "] JS error on attempt "
                        + attempt + ": " + e.getMessage());
            }
            sleep(TOAST_POLL_INTERVAL_MS);
        }

        throw new RuntimeException(
                "Toast [" + label + "] not found in DOM after "
                        + TOAST_MAX_WAIT_MS + "ms (" + attempt + " attempts). "
                        + "Verify the toast CSS class contains 'toast'.");
    }

    // ─── Internal workers — NO spinner guard, used within a single validated flow ──
    private static String fetchToastHeader() {
        return pollToastViaJs(JS_GET_TOAST_HEADER, "header");
    }

    private static List<String> fetchToastMessages() {
        String fullText = pollToastViaJs(JS_GET_TOAST_FULL_TEXT, "messages");

        System.out.println("Full Toast Text:\n" + fullText);

        List<String> lines = Arrays.stream(fullText.split("\n"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        return lines.isEmpty() ? List.of(fullText) : lines;
    }

    // ─── Public API — spinner guard called HERE and ONLY here ─────────────────────
    public static String getToastHeader() {
        waitForNgxSpinner();        // ← guard lives here
        return fetchToastHeader();  // ← internal worker, no re-guard
    }

    public static List<String> getMessages() {
        waitForNgxSpinner();         // ← guard lives here
        return fetchToastMessages(); // ← internal worker, no re-guard
    }

    /**
     * Single spinner wait → fetch header → fetch messages → validate.
     * No redundant spinner calls inside the chain.
     */
    public static void validateMessages(String expectedType, String expectedMessagesRaw) {
        waitForNgxSpinner();                          // ← ONE guard for the entire flow

        String       actualHeader   = fetchToastHeader();   // no re-guard
        List<String> actualMessages = fetchToastMessages(); // no re-guard

        System.out.println("=== Toast Validation ===");
        System.out.println("  Expected type : " + expectedType);
        System.out.println("  Actual header : " + actualHeader);
        System.out.println("  Messages      : " + actualMessages);
        System.out.println("========================");

        // 1. Type check (Success / Error / Warning / Info)
        if (!normalize(actualHeader).contains(normalize(expectedType))) {
            throw new AssertionError(
                    "Toast type mismatch.\n  Expected : " + expectedType +
                            "\n  Actual   : " + actualHeader);
        }

        // 2. Message presence check
        List<String> expectedMessages = getExpectedMessagesFromExcel(expectedMessagesRaw);
        List<String> missing          = new ArrayList<>();

        for (String expected : expectedMessages) {
            boolean found = actualMessages.stream()
                    .anyMatch(actual -> normalize(actual).contains(normalize(expected)));
            if (!found) {
                missing.add(expected);
            }
        }

        if (!missing.isEmpty()) {
            throw new AssertionError(
                    "\nMissing messages : " + missing +
                            "\nActual messages  : " + actualMessages);
        }

        System.out.println("Toast validation passed.");
    }

    public static void validateMultipleSmart(List<String> expectedList) {
        waitForNgxSpinner();                          // ← ONE guard for the entire flow

        List<String> actualMessages   = fetchToastMessages(); // no re-guard
        List<String> normalizedActual = actualMessages.stream()
                .map(MessageUtils::normalize)
                .collect(Collectors.toList());

        List<String> missing = new ArrayList<>();
        for (String expected : expectedList) {
            String norm  = normalize(expected);
            boolean found = normalizedActual.stream()
                    .anyMatch(a -> a.contains(norm) || similarity(a, norm) > 0.7);
            if (!found) {
                missing.add(expected);
            }
        }

        if (!missing.isEmpty()) {
            throw new AssertionError(
                    "\nMissing Messages : " + missing +
                            "\nActual Messages  : " + actualMessages);
        }
        System.out.println("Toast validation passed: " + actualMessages);
    }

    public void waitForDisappear() {
        try {
            getWait().until(ExpectedConditions.invisibilityOfElementLocated(TOAST_MESSAGE));
        } catch (Exception ignored) {}
    }

    // ─── Helpers ───────────────────────────────────────────────────────────────────
    private static String normalize(String text) {
        return text.toLowerCase()
                .replaceAll("[^a-z0-9 ]", "")
                .replaceAll("\\s+", " ")
                .trim();
    }

    private static double similarity(String actual, String expectedNorm) {
        Set<String> setA = new HashSet<>(Arrays.asList(actual.split(" ")));
        Set<String> setB = new HashSet<>(Arrays.asList(expectedNorm.split(" ")));
        Set<String> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        Set<String> union = new HashSet<>(setA);
        union.addAll(setB);
        return union.isEmpty() ? 0.0 : (double) intersection.size() / union.size();
    }

    private static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }

}
