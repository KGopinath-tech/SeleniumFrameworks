package com.cinque.tests;
import com.cinque.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.lang.reflect.Method;


public class BaseTest {

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

    @BeforeMethod
    public void setUp(Method method){
        Driver.initDriver();
    }
}
