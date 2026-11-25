package com.cinque.utils;

import com.cinque.Reports.ExtentLogger;
import com.cinque.config.Configfactory;
import com.cinque.driver.DriverManager;
import com.cinque.enums.SelectionType;
import com.cinque.enums.WaitType;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.cinque.enums.WaitType.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SeleniumUtils {

    public static void waitForElementToDisappear(By locator) {

        boolean elementAppeared = false;
        try {
            getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
            elementAppeared = true;
        } catch (TimeoutException ignored) {}

        if (elementAppeared) {
            try {
                getWait().until(
                        ExpectedConditions.invisibilityOfElementLocated(locator)
                );
            } catch (TimeoutException e) {}
        }
    }
    public static String getCurrentAreaValue(By locator){
        getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
        return DriverManager.getDriver().findElement(locator).getAttribute("aria-valuemax");
    }

    public static void waitForSleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
        }
    }

    private static final int WAIT_TIME = Math.toIntExact(Configfactory.getConfig().timeout());

    private static WebDriverWait getWait() {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_TIME));
    }

    private static By dropDownsearch = By.xpath("//input[@role='searchbox']");

    private static By dropDownOptions(String value) {
        return By.xpath("//li[@role='option'][contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
                + value.toLowerCase() + "')]");
    }

    public static void selectMultiDropdown(By dropdown, String... values) {
        String[] selections = expandCommaSeparatedValues(values);
        if (selections.length == 0) {
            return;
        }

        WebDriver driver = DriverManager.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement multiSelectRoot = resolveMultiSelectRoot(dropdown);
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", multiSelectRoot);

        By panelLocator = resolveMultiSelectPanelLocator(multiSelectRoot);
        openMultiSelectPanel(multiSelectRoot, panelLocator);

        for (String value : selections) {
            selectMultiSelectOption(panelLocator, value);
        }

        closeMultiSelectPanel(panelLocator);
    }

    public static void selectDropdown(By dropdown, String... values) {
        if (isPrimeNgMultiSelect(dropdown)) {
            selectMultiDropdown(dropdown, values);
        } else {
            for (String value : values) {
                if (isNotBlank(value)) {
                    selectDropDown(dropdown, value.trim());
                }
            }
        }
    }

    private static boolean isPrimeNgMultiSelect(By dropdown) {
        WebElement element = getWait().until(presenceOfElementLocated(dropdown));
        return !element.findElements(By.xpath(
                "./ancestor-or-self::p-multiselect | ./ancestor-or-self::*[contains(@class,'p-multiselect')]"
        )).isEmpty();
    }

    private static WebElement resolveMultiSelectRoot(By dropdown) {
        WebElement element = getWait().until(elementToBeClickable(dropdown));
        List<WebElement> roots = element.findElements(By.xpath(
                "./ancestor::p-multiselect[1] | ./ancestor::*[contains(@class,'p-multiselect') and not(contains(@class,'p-multiselect-panel'))][1]"
        ));
        return roots.isEmpty() ? element : roots.get(0);
    }

    private static By resolveMultiSelectPanelLocator(WebElement multiSelectRoot) {
        String rootId = multiSelectRoot.getAttribute("id");
        if (isNotBlank(rootId)) {
            return By.id(rootId + "_list");
        }

        List<WebElement> comboboxes = multiSelectRoot.findElements(By.cssSelector(
                "[role='combobox'], input[id], input[data-pc-name='multiselect']"
        ));

        for (WebElement combobox : comboboxes) {
            String ariaControls = combobox.getAttribute("aria-controls");
            if (isNotBlank(ariaControls)) {
                return By.id(ariaControls);
            }
        }

        for (WebElement combobox : comboboxes) {
            String id = combobox.getAttribute("id");
            if (isNotBlank(id)) {
                return By.id(id + "_list");
            }
        }

        throw new IllegalStateException("Unable to resolve PrimeNG multiselect panel for: " + multiSelectRoot);
    }

    private static void openMultiSelectPanel(WebElement multiSelectRoot, By panelLocator) {
        if (isMultiSelectPanelOpen(panelLocator)) {
            return;
        }

        WebDriver driver = DriverManager.getDriver();
        WebElement trigger = multiSelectRoot.findElement(By.cssSelector(
                ".p-multiselect-trigger, .p-multiselect-label-container, .p-multiselect"
        ));
        jsClick(driver, trigger);
        getWait().until(visibilityOfElementLocated(panelLocator));
    }

    private static boolean isMultiSelectPanelOpen(By panelLocator) {
        List<WebElement> panels = DriverManager.getDriver().findElements(panelLocator);
        return !panels.isEmpty() && panels.get(0).isDisplayed();
    }

    private static void selectMultiSelectOption(By panelLocator, String value) {
        WebDriver driver = DriverManager.getDriver();
        String normalizedValue = value.toLowerCase();
        String literal = xpathLiteral(normalizedValue);
        String ariaMatch = "contains(translate(@aria-label,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),"
                + literal + ")";
        String textMatch = ".//span[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),"
                + literal + ")]";

        WebElement panel = getWait().until(visibilityOfElementLocated(panelLocator));
        filterMultiSelectOptions(panel, value);

        WebElement option = getWait().until(d -> {
            WebElement visiblePanel = d.findElement(panelLocator);
            List<WebElement> matches = visiblePanel.findElements(By.xpath(
                    ".//li[@role='option' and not(contains(@class,'p-disabled')) and (" + ariaMatch + " or " + textMatch + ")]"
            ));
            return matches.isEmpty() ? null : matches.get(0);
        });

        if ("true".equalsIgnoreCase(option.getAttribute("aria-selected"))) {
            clearMultiSelectFilter(panelLocator);
            return;
        }

        WebElement checkbox = option.findElement(By.cssSelector(".p-checkbox-box, .p-checkbox"));
        jsClick(driver, checkbox);

        getWait().until(d -> "true".equalsIgnoreCase(
                d.findElement(panelLocator)
                        .findElement(By.xpath(".//li[@role='option' and (" + ariaMatch + " or " + textMatch + ")]"))
                        .getAttribute("aria-selected")
        ));

        clearMultiSelectFilter(panelLocator);
    }

    private static void filterMultiSelectOptions(WebElement panel, String value) {
        List<WebElement> filters = panel.findElements(By.cssSelector(
                ".p-multiselect-filter, input[role='searchbox'], .p-multiselect-header input"
        ));
        if (filters.isEmpty()) {
            return;
        }

        WebElement filter = filters.get(0);
        filter.click();
        filter.clear();
        filter.sendKeys(value);
    }

    private static void clearMultiSelectFilter(By panelLocator) {
        WebElement panel = DriverManager.getDriver().findElement(panelLocator);
        List<WebElement> filters = panel.findElements(By.cssSelector(
                ".p-multiselect-filter, input[role='searchbox'], .p-multiselect-header input"
        ));
        if (filters.isEmpty()) {
            return;
        }

        filters.get(0).clear();
    }

    private static String xpathLiteral(String value) {
        if (!value.contains("'")) {
            return "'" + value + "'";
        }
        if (!value.contains("\"")) {
            return "\"" + value + "\"";
        }

        String[] parts = value.split("'", -1);
        StringBuilder expression = new StringBuilder("concat(");
        for (int i = 0; i < parts.length; i++) {
            if (i > 0) {
                expression.append(", \"'\", ");
            }
            expression.append("'").append(parts[i]).append("'");
        }
        expression.append(")");
        return expression.toString();
    }

    private static void closeMultiSelectPanel(By panelLocator) {
        WebDriver driver = DriverManager.getDriver();
        if (!isMultiSelectPanelOpen(panelLocator)) {
            return;
        }

        driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
        getWait().until(ExpectedConditions.invisibilityOfElementLocated(panelLocator));
    }

    private static void jsClick(WebDriver driver, WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    private static String[] expandCommaSeparatedValues(String... values) {
        List<String> expanded = new ArrayList<>();
        if (values == null) {
            return new String[0];
        }

        for (String value : values) {
            if (!isNotBlank(value)) {
                continue;
            }
            for (String part : value.split(",")) {
                if (isNotBlank(part)) {
                    expanded.add(part.trim());
                }
            }
        }
        return expanded.toArray(new String[0]);
    }

    public static String[] toArray(String data) {
        if (data == null || data.trim().isEmpty()) {
            return new String[0];
        }
        return data.split(",");
    }

    public static void selectDropDown(By by, String value) {

        WebDriver driver = DriverManager.getDriver();

        WebElement dropdown = getWait().until(elementToBeClickable(by));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
        waitForSleep(100);

        WebElement trigger = dropdown.findElement(By.cssSelector(".p-dropdown-trigger"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", trigger);
        waitForSleep(100);

        WebElement filterInput = getWait().until(
                visibilityOfElementLocated(By.cssSelector(".p-dropdown-panel .p-dropdown-filter"))
        );

        filterInput.click();
        waitForSleep(100);
        filterInput.sendKeys(value.toUpperCase());
        waitForSleep(200);

        By option = By.xpath(
                "//li[@role='option'][contains(" +
                        "translate(@aria-label, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" +
                        value.toLowerCase() +
                        "')]"
        );

        WebElement element = getWait().until(visibilityOfElementLocated(option));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }

    public static void selectDropdownWithRetry(By by, String value) {

        int attempts = 0;

        while (attempts < 3) {
            try {
                selectDropDown(by, value);
                return;
            } catch (Exception e) {
                attempts++;
                System.out.println("Retrying " + by + " dropdown: " + value);
            }
        }

//        throw new RuntimeException("Dropdown selection failed for: " + value);
    }

    public static void selectDropdown(By dropdown, String value) {
        click(dropdown, CLICKABLE);
        click(dropDownOptions(value.trim()), CLICKABLE);
    }

    public static boolean isNotBlank(String value) {
        return StringUtils.isNotBlank(value);
    }

    public static void click(By by, WaitType waitType, String elementName) {
        WebElement element = waitFor(by, waitType);
        element.click();
        ExtentLogger.info(elementName + " clicked successfully");
    }

    public static void click(By by, WaitType waitType) {
        WebElement element = waitFor(by, waitType);
        element.click();
    }

    public static void sendKeys(By by, String value, WaitType waitType, String elementname) {

        WebElement element = waitFor(by, waitType);
        if (value == null) {
            throw new IllegalArgumentException(elementname + " value is null");
        }
        element.clear();
        element.sendKeys(value);
        ExtentLogger.info(value + " is entered successfully in " + elementname);
    }

    private static void handleCalendarIfPresent() {
        try {
            List<WebElement> calendars = DriverManager.getDriver()
                    .findElements(By.cssSelector(".p-datepicker"));

            if (!calendars.isEmpty() && calendars.get(0).isDisplayed()) {

                DriverManager.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
                DriverManager.getDriver().findElement(By.tagName("body")).click();
            }

        } catch (Exception e) {
        }
    }

    public static void enterDate(By by, String value, WaitType waitType) {
        WebElement element = waitFor(by, waitType);
        element.clear();
        element.sendKeys(value);
        element.sendKeys(Keys.TAB);
    }

    public static boolean isDisplayed(By by) {
        return DriverManager.getDriver().findElement(by).isDisplayed();

    }

    private static WebElement waitFor(By by, WaitType waitType) {

        switch (waitType) {
            case CLICKABLE:
                return getWait().until(elementToBeClickable(by));
            case VISIBLE:
                return getWait().until(visibilityOfElementLocated(by));
            case PRESENT:
                return getWait().until(ExpectedConditions.presenceOfElementLocated(by));
            default:
                throw new RuntimeException("Unsupported waiting type");
        }
    }

    public static void setToggle(By by, boolean desiredState) {

        WebElement toggle = getWait().until(elementToBeClickable(by));

        boolean currentState = getToggleState(toggle);
        System.out.println("[Toggle] Current: " + currentState + " → Desired: " + desiredState);

        if (currentState == desiredState) {
            System.out.println("[Toggle] Already in desired state — skipping click.");
            return;
        }

        toggle.click();

        try {
            getWait().until(driver1 -> {
                WebElement freshToggle = driver1.findElement(by);
                return getToggleState(freshToggle) == desiredState;
            });
          //  System.out.println("[Toggle] Successfully switched to: " + desiredState);

        } catch (TimeoutException e) {
            // Take actual state at timeout — gives meaningful error
            WebElement freshToggle = DriverManager.getDriver().findElement(by);
            boolean actualState = getToggleState(freshToggle);
            throw new IllegalStateException(
                    String.format("[Toggle] Failed! Desired: %s | Actual: %s | Locator: %s",
                            desiredState, actualState, by)
            );
        }

    }
    private static boolean getToggleState(WebElement element) {
        Object state = ((JavascriptExecutor) DriverManager.getDriver()).executeScript(
                "var el = arguments[0];" +
                "function readAria(node) {" +
                "  if (!node) return null;" +
                "  var aria = node.getAttribute('aria-checked');" +
                "  return aria === null ? null : aria === 'true';" +
                "}" +
                "function readChecked(node) {" +
                "  if (!node || typeof node.checked !== 'boolean') return null;" +
                "  return node.checked;" +
                "}" +
                "function resolveInput(node) {" +
                "  if (!node) return null;" +
                "  if (node.matches('input[type=\"checkbox\"], input[role=\"switch\"], [role=\"switch\"]')) return node;" +
                "  return node.querySelector('input[type=\"checkbox\"], input[role=\"switch\"], [role=\"switch\"]');" +
                "}" +
                "var aria = readAria(el);" +
                "if (aria !== null) return aria;" +
                "var checked = readChecked(el);" +
                "if (checked !== null) return checked;" +
                "var input = resolveInput(el);" +
                "if (input) {" +
                "  aria = readAria(input);" +
                "  if (aria !== null) return aria;" +
                "  checked = readChecked(input);" +
                "  if (checked !== null) return checked;" +
                "}" +
                "var root = el.closest('.p-inputswitch, .form-check, .form-switch');" +
                "if (root && root.classList.contains('p-inputswitch-checked')) return true;" +
                "return false;",
                element
        );
        return Boolean.TRUE.equals(state);
    }
}


