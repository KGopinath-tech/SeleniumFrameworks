package com.cinque.utils;

import com.cinque.config.Configfactory;
import com.cinque.driver.DriverManager;
import com.cinque.enums.SelectionType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;


public class DropDownUtils {


    private static final int WAIT_TIME = Math.toIntExact(Configfactory.getConfig().timeout());

    private static WebDriverWait getWait() {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_TIME));
    }

    public static void select(By locator, String userInput, SelectionType type) {

        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        getWait().until(ExpectedConditions.elementToBeClickable(locator));

        Select dropdown = new Select(DriverManager.getDriver().findElement(locator));

        switch (type) {
            case VISIBLE_TEXT:
                dropdown.selectByVisibleText(userInput);
                break;

            case VALUE:
                dropdown.selectByValue(userInput);
                break;

            case INDEX:
                dropdown.selectByIndex(Integer.parseInt(userInput));
                break;

            default:
                throw new IllegalArgumentException("Invalid selection type: " + type);
        }
    }

    }



