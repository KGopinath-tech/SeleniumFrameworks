package com.cinque.utils;

import com.cinque.config.Configfactory;
import com.cinque.driver.DriverManager;
import com.cinque.enums.SelectionType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.cinque.utils.SeleniumUtils.wait;

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
    public static void selectDropdown(By dropdown, String value) {
        selectDropdown(dropdown, value, null);
    }

    public static void selectDropdown(By dropdown, String value, By searchBox) {

        int attempts = 0;

        while (attempts < 3) {
            try {
                // Step 1: Click dropdown
                WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(dropdown));
                scrollIntoView(dd);
                dd.click();

                // Step 2: Wait for overlay
                By panel = By.cssSelector(".p-dropdown-panel");
                WebElement panelElement = wait.until(ExpectedConditions.visibilityOfElementLocated(panel));

                // Step 3: Handle search (if present)
                if (searchBox != null) {
                    WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
                    search.clear();
                    search.sendKeys(value);
                }

                // Step 4: Select option inside ACTIVE panel only
                By option = By.xpath(
                        "//div[contains(@class,'p-dropdown-panel') and contains(@style,'block')]//span[normalize-space()='"
                                + value + "']"
                );

                WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(option));
                scrollIntoView(optionElement);
                optionElement.click();

                // Step 5: Wait for overlay to disappear
                wait.until(ExpectedConditions.invisibilityOf(panelElement));

                return;

            } catch (Exception e) {
                attempts++;
                System.out.println("Retrying dropdown (" + attempts + "): " + value);

                // cleanup overlay before retry
                closeOverlayIfPresent();
            }
        }

        throw new RuntimeException("Dropdown selection failed for: " + value);
    }
    private static void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }
    private static void closeOverlayIfPresent() {
        try {
            List<WebElement> panels = DriverManager.getDriver().findElements(By.cssSelector(".p-dropdown-panel"));

            if (!panels.isEmpty() && panels.get(0).isDisplayed()) {
                DriverManager.getDriver().findElement(By.tagName("body")).click();
                Thread.sleep(300); // small stabilization
            }
        } catch (Exception ignored) {}
    }
    }


