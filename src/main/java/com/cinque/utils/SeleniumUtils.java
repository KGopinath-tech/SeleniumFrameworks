package com.cinque.utils;

import com.cinque.Reports.ExtentLogger;
import com.cinque.config.Configfactory;
import com.cinque.driver.DriverManager;
import com.cinque.enums.SelectionType;
import com.cinque.enums.WaitType;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.cinque.enums.WaitType.*;

public class SeleniumUtils {


    static WebDriverWait wait = new WebDriverWait(
            DriverManager.getDriver(),
            Duration.ofSeconds(Configfactory.getConfig().timeout()));

    private static By dropDownsearch = By.xpath("//input[@type='text' or @role='searchbox']");
    private static By dropDownOptions(String value){
        return By.xpath("//li[@role='option'][.//span[contains(text(),'" + value + "')]]");
    }

    public static void selectMultiDropdown(By dropdown, String... values) {

        // 1. Open dropdown ONLY ONCE
        WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        dd.click();

        // 2. Wait for panel
        By panel = By.xpath("//div[@id='ServiceType_list']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(panel));

        for (String value : values) {

            // 3. Search (if available)
            try {
                WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class,'p-multiselect-panel')]//input")
                ));
                search.clear();
                search.sendKeys(value);
            } catch (Exception ignored) {}

            // 4. Select checkbox option (IMPORTANT: not span click sometimes)
            By option = By.xpath(
                    "//li[@role='option'][.//span[normalize-space()='" + value + "']]//div[contains(@class,'p-checkbox')]");

            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(option));

            try {
                element.click();
            } catch (Exception e) {
                ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", element);
            }
        }

        // 5. Close dropdown (VERY IMPORTANT)
        DriverManager.getDriver().findElement(By.xpath("//body")).click();
    }
    public static void selectDropdown(By dropdown, String... values) {

        if (DriverManager.getDriver().findElements(By.xpath("//p-multiselect")).size() > 0) {
            selectMultiDropdown(dropdown, values);
        } else {
            for (String value : values) {
                selectDropDown(dropdown, value);
            }
        }
    }

    public static String[] toArray(String data) {
            if (data == null || data.trim().isEmpty()) {
                return new String[0];
            }
            return data.split(",");
        }

    public static void selectDropDown(By by, String value){
        click(by, CLICKABLE);
        WebElement search = wait.until(
                ExpectedConditions.visibilityOfElementLocated(dropDownsearch)
        );
        search.clear();
        search.sendKeys(value);
        By option = By.xpath("//li[@role='option']//span[contains(normalize-space(),'" + value.toUpperCase() + "')]");

        wait.until(ExpectedConditions.presenceOfElementLocated(option));
        WebElement element = DriverManager.getDriver().findElement(option);
        ((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].click();", element);

    }
    public static void selectDropdownWithRetry(By by, String value) {

        int attempts = 0;

        while (attempts < 3) {
            try {
                selectDropDown(by, value);
                return;
            } catch (Exception e) {
                attempts++;
                System.out.println("Retrying dropdown: " + value);
            }
        }

        throw new RuntimeException("Dropdown selection failed for: " + value);
    }

    public static void selectDropdown(By dropdown, String value){
        click(dropdown, CLICKABLE);
        click(dropDownOptions(value.trim()), CLICKABLE);
    }

    public static boolean isNotBlank(String value){
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

    public static void sendKeys(By by, String value, WaitType waitType, String elementname){

        WebElement element = waitFor(by, waitType);
        if (value == null) {
            throw new IllegalArgumentException(elementname + " value is null");
        }
        element.sendKeys(value);
        ExtentLogger.info(value+ " is entered successfully in " +elementname);
    }
    private static void handleCalendarIfPresent() {
        try {
            List<WebElement> calendars = DriverManager.getDriver()
                    .findElements(By.cssSelector(".p-datepicker"));

            if (!calendars.isEmpty() && calendars.get(0).isDisplayed()) {

                // Option 1: Press TAB (most stable)
               // DriverManager.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);

                // Option 2 (backup): click outside if still visible
                DriverManager.getDriver().findElement(By.tagName("body")).click();
            }

        } catch (Exception e) {
            // Fail-safe: ignore
        }
    }
    public static void enterDate(By by, String value, WaitType waitType) {
        WebElement element = waitFor(by, waitType);
        element.clear();
        element.sendKeys(value);
        element.sendKeys(Keys.TAB);
    }
    public static void select(WebElement element, String elementName, String userInput, SelectionType selectType){
        Select select = new Select(element);
        if(selectType == selectType.VALUE)
        select.selectByValue(userInput);
        else if (selectType == selectType.INDEX) {
            select.selectByIndex(Integer.parseInt(userInput));
        } else if (selectType == selectType.VISIBLE_TEXT) {
            select.selectByVisibleText(userInput);
        }else if (selectType == selectType.CONTAIN_TEXT){
            select.selectByContainsVisibleText(userInput);
        }
        ExtentLogger.info(elementName+ " is selected successfully");
    }
    public static boolean isDisplayed(By by) {
       return DriverManager.getDriver().findElement(by).isDisplayed();

    }
    private static WebElement waitFor(By by, WaitType waitType) {

        switch (waitType) {
            case CLICKABLE:
                return wait.until(ExpectedConditions.elementToBeClickable(by));
            case VISIBLE:
                return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            case PRESENT:
                return wait.until(ExpectedConditions.presenceOfElementLocated(by));
            default:
                throw new RuntimeException("Unsupported waiting type");
        }
    }
    public static void setToggle(By by, boolean shouldBeOn) {

        WebElement toggle = wait.until(ExpectedConditions.elementToBeClickable(by));

        boolean isCurrentlyOn = Boolean.parseBoolean(toggle.getAttribute("aria-checked"));

        if (isCurrentlyOn != shouldBeOn) {
            toggle.click();
        }
    }
}
