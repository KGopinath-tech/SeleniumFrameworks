package com.cinque.tests;

import com.cinque.annotations.FrameworkAnnotation;
import com.cinque.driver.DriverManager;
import com.cinque.pages.HomePage;
import com.cinque.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DummyTest extends BaseTest{

    @Test
    @FrameworkAnnotation(category = {"Regression"}, author = "Gopinath")
    public void test1() {
        System.out.println("Thread: " + Thread.currentThread().getId());
        String expectedTitle =DriverManager.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, "Symex1");
    }
    @Test
    @FrameworkAnnotation(category = {"Regression"}, author = "Shinitha")
    public void test2() {
        System.out.println("Thread: " + Thread.currentThread().getId());
        String expectedTitle =DriverManager.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, "Symex");
    }
}
