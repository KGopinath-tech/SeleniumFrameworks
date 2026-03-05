package com.cinque.utils;

import com.cinque.Reports.ExtentLogger;
import com.cinque.config.Configfactory;
import com.cinque.driver.DriverManager;
import com.cinque.enums.SelectionType;
import com.cinque.enums.WaitType;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.cinque.enums.WaitType.CLICKABLE;
import static com.cinque.enums.WaitType.PRESENT;

public class SeleniumUtils {


    private static By dropDownOptions(String value){
        return By.xpath("//li[normalize-space()='" + value + "']");
    }

    public static void selectDropdown(By dropdown, String value){
        click(dropdown, CLICKABLE);
        click(dropDownOptions(value), CLICKABLE);
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
        element.sendKeys(value);
       ExtentLogger.info(value+ " is entered successfully in " +elementname);
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

        WebDriverWait wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(Configfactory.getConfig().timeout())
        );

        switch (waitType) {
            case CLICKABLE:
                return wait.until(ExpectedConditions.elementToBeClickable(by));

            case VISIBLE:
                return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

            case PRESENT:
            default:
                return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }
    }
    public static void setToggle(By by, boolean shouldBeOn) {

        WebDriverWait wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(Configfactory.getConfig().timeout())
        );
        WebElement toggle = wait.until(ExpectedConditions.elementToBeClickable(by));

        boolean isCurrentlyOn = Boolean.parseBoolean(toggle.getAttribute("aria-checked"));

        if (isCurrentlyOn != shouldBeOn) {
            toggle.click();
        }
    }
//    private static WebElement waitUntilElementClickable(By by) {
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Configfactory.getConfig().timeout()));
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
//        return element;
//    }
//    private static WebElement waitUntilElementVisible(By by) {
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Configfactory.getConfig().timeout()));
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//        return element;
//    }
}
