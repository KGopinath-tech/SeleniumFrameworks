package com.cinque.driver;

import com.cinque.config.Configfactory;
import org.openqa.selenium.WebDriver;


import java.time.Duration;

public final class Driver {

    private Driver(){}


    public static void initDriver(){

        String browser = Configfactory.getConfig().browser();
        if (DriverManager.getDriver() == null) {
            WebDriver driver = DriverFactory.getDriver(browser);
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Configfactory.getConfig().timeout()));
            DriverManager.getDriver().get(Configfactory.getConfig().url());
        }
    }

    public static void quitDriver(){
        if ( DriverManager.getDriver()!= null) {
            DriverManager.getDriver().quit();
            DriverManager.setDriver(null);
        }
    }
}
