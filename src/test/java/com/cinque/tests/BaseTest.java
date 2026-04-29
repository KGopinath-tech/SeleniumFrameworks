package com.cinque.tests;
import com.cinque.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import java.lang.reflect.Method;


public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
    Driver.initDriver();
}

    @AfterMethod(alwaysRun = true)
    public void tearDown(Method method) {
        Driver.quitDriver();
    }
    }

