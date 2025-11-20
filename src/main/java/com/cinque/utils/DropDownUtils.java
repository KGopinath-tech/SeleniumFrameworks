package com.cinque.utils;

import com.cinque.config.Configfactory;
import com.cinque.driver.DriverManager;
import com.cinque.enums.SelectionType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropDownUtils {


    private static final int WAIT_TIME = Math.toIntExact(Configfactory.getConfig().timeout());


    private static WebDriverWait getWait() {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_TIME));
    }

    public static void select(By locator, String value, SelectionType type) {

        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        getWait().until(ExpectedConditions.elementToBeClickable(locator));

        Select dropdown = new Select(DriverManager.getDriver().findElement(locator));

        switch (type) {
            case VISIBLE_TEXT:
                dropdown.selectByVisibleText(value);
                break;

            case VALUE:
                dropdown.selectByValue(value);
                break;

            case INDEX:
                dropdown.selectByIndex(Integer.parseInt(value));
                break;

            default:
                throw new IllegalArgumentException("Invalid selection type: " + type);
        }
    }
    }


