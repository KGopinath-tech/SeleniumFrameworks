package com.cinque.utils;

import com.cinque.config.Configfactory;
import com.cinque.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

import static com.cinque.utils.DataUtils.getExpectedMessagesFromExcel;

public class MessageUtils {

    private static final By TOAST_MESSAGE = By.xpath(
            "//div[contains(@class,'toast')]");
    private static final int WAIT_TIME = Math.toIntExact(Configfactory.getConfig().timeout());
    private static final By NGX_SPINNER_TAG     = By.tagName("ngx-spinner");
    private static final Duration SPINNER_APPEAR_TIMEOUT    = Duration.ofSeconds(5);
    private static final Duration SPINNER_DISAPPEAR_TIMEOUT = Duration.ofSeconds(30);

    private static WebDriverWait getWait() {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_TIME));
    }

    public static void waitForNgxSpinner() {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait appearWait    = new WebDriverWait(driver, SPINNER_APPEAR_TIMEOUT);
        WebDriverWait disappearWait = new WebDriverWait(driver, SPINNER_DISAPPEAR_TIMEOUT);

        boolean spinnerAppeared = false;
        try {
            appearWait.until(ExpectedConditions.visibilityOfElementLocated(NGX_SPINNER_TAG));
            spinnerAppeared = true;
            System.out.println("Spinner Loader Detected — waiting for it to disappear...");
        } catch (TimeoutException ignored) {
            // Spinner never became visible → nothing to wait for
            System.out.println("Spinner Loader Did not appear — skipping wait.");
        }
        if (spinnerAppeared) {
            try {
                // invisibilityOfElementLocated works even if element leaves DOM entirely
                disappearWait.until(
                        ExpectedConditions.invisibilityOfElementLocated(NGX_SPINNER_TAG)
                );
                System.out.println("Spinner disappeared — proceeding.");
            } catch (TimeoutException e) {
                System.out.println("WARNING: Spinner Loader Still visible after "
                        + SPINNER_DISAPPEAR_TIMEOUT.getSeconds() + "s — proceeding anyway.");
            }
        }
    }

    public static String getToastHeader() {
        waitForNgxSpinner();
        WebElement toast = retryGetToast(5);

        // Header usually bold / title section
        try {
            return toast.findElement(By.xpath(".//div[contains(@class,'title') or contains(text(),'Error') or contains(text(),'Success')]"))
                    .getText().trim();
        } catch (Exception e) {
            return toast.getText().split("\n")[0]; // fallback
        }

    }

    private static WebElement getActiveToast() {
        waitForNgxSpinner();
            try {
                List<WebElement> elements = getWait().until(
                        ExpectedConditions.visibilityOfAllElementsLocatedBy(TOAST_MESSAGE));

                if (!elements.isEmpty()) {
                    return elements.get(elements.size() - 1); // latest toast
                }
            } catch (Exception ignored) {}

        throw new RuntimeException("No active toast found");
    }

    // 🧹 Normalize text (AI-like matching)
    private static String normalize(String text) {
        return text.toLowerCase()
                .replaceAll("[^a-z0-9 ]", "")   // remove special chars
                .replaceAll("\\s+", " ")        // remove extra spaces
                .trim();
    }

    //  Extract messages intelligently
    public static List<String> extractMessages() {
        waitForNgxSpinner();

        WebElement toast;

        try {
            toast = getWait().until(
                    ExpectedConditions.visibilityOfElementLocated(TOAST_MESSAGE)
            );
        } catch (Exception e) {
            throw new RuntimeException("Toast not found in DOM");
        }

        System.out.println("Full Toast Text: " + toast.getText());

        List<WebElement> elements = toast.findElements(
                By.xpath(".//li | .//div | .//span")
        );

        List<String> messages = new ArrayList<>();

        for (WebElement el : elements) {
            String text = el.getText().trim();
            if (!text.isEmpty()) {
                messages.add(text);
            }
        }

        // Fallback (important for success toast)
        if (messages.isEmpty()) {
            String fullText = toast.getText().trim();
            if (!fullText.isEmpty()) {
                messages.add(fullText);
            }
        }

        return messages;
    }
    public static List<String> getMessages() {

        for (int i = 0; i < 3; i++) {
            try {
                return extractMessages();
            } catch (Exception e) {
                sleep(500);
            }
        }

        return Collections.emptyList();
    }

    //  Retry logic (handles flicker)
    private static WebElement retryGetToast(int attempts) {
        for (int i = 0; i < attempts; i++) {
            try {
                return getActiveToast();
            } catch (Exception e) {
                sleep(500);
            }
        }
        throw new RuntimeException("Toast not found after retry");
    }

    public static void validateMessages(String expectedType, String expectedMessagesRaw) {

        String actualHeader = getToastHeader();

        if (!normalize(actualHeader).contains(normalize(expectedType))) {
            throw new AssertionError("Toast type mismatch. Expected: "
                    + expectedType + " but found: " + actualHeader);
        }

        List<String> expectedMessages = getExpectedMessagesFromExcel(expectedMessagesRaw);
        List<String> actualMessages = getMessages();

        for (String expected : expectedMessages) {
            boolean found = actualMessages.stream()
                    .anyMatch(actual -> normalize(actual).contains(normalize(expected)));

            if (!found) {
                throw new AssertionError(
                        "\n Missing message: " + expected +
                                "\n Actual: " + actualMessages
                );
            }
        }
    }

    // Simple similarity (Jaccard-like)
    private static double similarity(String actual, String expectedNorm) {
        Set<String> setA = new HashSet<>(Arrays.asList(actual.split(" ")));
        Set<String> setB = new HashSet<>(Arrays.asList(expectedNorm.split(" ")));

        Set<String> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);

        Set<String> union = new HashSet<>(setA);
        union.addAll(setB);

        return (double) intersection.size() / union.size();
    }

    // Validate multiple smartly
    public static void validateMultipleSmart(List<String> expectedList) {
        List<String> actualMessages = getMessages();

        List<String> normalizedActual = actualMessages.stream()
                .map(MessageUtils::normalize)
                .collect(Collectors.toList());

        List<String> missingMessages = new ArrayList<>();

        for (String expected : expectedList) {

            String expectedNorm = normalize(expected);

            boolean found = normalizedActual.stream()
                    .anyMatch(actual ->
                            actual.contains(expectedNorm) ||
                                    similarity(actual, expectedNorm) > 0.7
                    );

            if (!found) {
                missingMessages.add(expected);
            }
        }

        // Fail only once with full details
        if (!missingMessages.isEmpty()) {
            throw new AssertionError(
                    "\n Missing Messages: " + missingMessages +
                            "\n Actual Messages: " + actualMessages
            );
        }

        // Optional log
        System.out.println(" Toast validation passed: " + actualMessages);
    }

    // Wait for disappear
    public void waitForDisappear() {
            try {
                getWait().until(ExpectedConditions.invisibilityOfElementLocated(TOAST_MESSAGE));
                return;
            } catch (Exception ignored) {}
    }

    private static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}
