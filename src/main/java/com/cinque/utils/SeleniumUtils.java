package com.cinque.utils;

import com.cinque.Reports.ExtentLogger;
import com.cinque.config.Configfactory;
import com.cinque.driver.DriverManager;
import com.cinque.enums.SelectionType;
import com.cinque.enums.WaitType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtils {

    public static void click(By by, WaitType clickable, String elementName){
        WebElement element = waitUntilElementPresent(by);
        element.click();
       // ExtentLogger.info(elementName +" is clicked successfully");
    }

    public static void sendKeys(By by, String value, String elementname){

        WebElement element = waitUntilElementPresent(by);
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

    private static WebElement waitUntilElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Configfactory.getConfig().timeout()));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return element;
    }
    private static WebElement waitUntilElementClickable(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Configfactory.getConfig().timeout()));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }
    private static WebElement waitUntilElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Configfactory.getConfig().timeout()));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }
}
