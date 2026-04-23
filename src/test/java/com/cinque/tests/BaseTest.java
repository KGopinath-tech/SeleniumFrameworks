package com.cinque.tests;
import com.cinque.config.Configfactory;
import com.cinque.driver.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import java.lang.reflect.Method;


public class BaseTest {

//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        Driver.quitDriver();
//    }
//
//    @BeforeMethod
//    public void setUp(Method method){
//        Driver.initDriver();
//    }
    @BeforeMethod(alwaysRun = true)   // ✅ was missing alwaysRun
    public void setUp(Method method) {
    System.out.println("▶ setUp: " + method.getName()
            + " | Thread: " + Thread.currentThread().getId());
    Driver.initDriver();
    System.out.println("✅ Driver initialized for thread: "
            + Thread.currentThread().getId());
}

    @AfterMethod(alwaysRun = true)
    public void tearDown(Method method) {
        System.out.println("⏹ tearDown: " + method.getName()
                + " | Thread: " + Thread.currentThread().getId());
        Driver.quitDriver();
    }
    }

