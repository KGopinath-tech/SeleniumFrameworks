package com.cinque.tests;

import com.cinque.annotations.FrameworkAnnotation;
import com.cinque.pages.HomePage;
import com.cinque.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CustomerRegisterTest extends BaseTest{

    @FrameworkAnnotation(category = {"Smoke","Regression"})
    @Test(description = "To check whether sidebar working to access menus")
    public void registerCustomer() throws InterruptedException {
        LoginPage login = new LoginPage();
        login.loginToSymexApplication( "Gopinath", "Symx@14#");
        Thread.sleep(2000);
        login.selectBranch("HEAD OFFICE");
        login.clickContinue();

        HomePage homepage = new HomePage();
        String actualTitle = homepage.getSymexTitle();
        Assert.assertEquals(actualTitle, "Symex");

        HomePage homePage = new HomePage();
        homePage.clickOnSidebar();

        Thread.sleep(3000);
        homePage.getGeneralMenu();
        homePage.getCustomerRegistration();
        Thread.sleep(5000);
    }
}
