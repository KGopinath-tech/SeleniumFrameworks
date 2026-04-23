package com.cinque.driver;

import com.cinque.enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class DriverFactory {

    private DriverFactory() {
    }

    // One-time setup per browser type, thread-safe
    private static final Map<String, Boolean> initialized = new ConcurrentHashMap<>();

    public static WebDriver getDriver(String browserName) {

        return switch (browserName.toLowerCase()) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            case "safari" -> new SafariDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browserName);
        };
    }
}

//    public static WebDriver getDriver(String browserName){
//
//        WebDriver driver;
//        if(browserName.equalsIgnoreCase("chrome")){
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        } else if (browserName.equalsIgnoreCase("firefox")){
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        } else if  (browserName.equalsIgnoreCase("edge")){
//            WebDriverManager.edgedriver().setup();
//            driver= new EdgeDriver();
//        }else {
//            WebDriverManager.safaridriver().setup();
//            driver = new SafariDriver();
//        }
//        return driver;
//
//    }



