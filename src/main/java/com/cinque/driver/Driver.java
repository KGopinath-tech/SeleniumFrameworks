package com.cinque.driver;

import com.cinque.config.Configfactory;
import com.cinque.config.FrameworkConfig;
import org.aeonbits.owner.Config;
import org.openqa.selenium.WebDriver;


import java.time.Duration;

public final class Driver {

    private Driver(){}


    public static void initDriver(){

        FrameworkConfig config = Configfactory.getConfig();
        WebDriver driver = DriverFactory.getDriver(config.browser());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.timeout()));
        driver.get(config.url());
        DriverManager.setDriver(driver);

//        String browser = Configfactory.getConfig().browser();
//        WebDriver driver = DriverFactory.getDriver(browser);
//        DriverManager.setDriver(driver);
//        DriverManager.getDriver().manage().window().maximize();
//        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Configfactory.getConfig().timeout()));
//        DriverManager.getDriver().get(Configfactory.getConfig().url());

    }

    public static void quitDriver(){
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            driver.quit();
            DriverManager.unloadDriver();
        }
    }
}
