package com.cinque.tests;

import com.cinque.annotations.FrameworkAnnotation;
import com.cinque.pages.HomePage;
import com.cinque.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DummyTest extends BaseTest{

    @FrameworkAnnotation(author = "Shinitha", category = "Smoke")
    @Test(description = "Dummay test")
    public void titleValidationTest() throws InterruptedException {


        LoginPage login = new LoginPage();
        login.loginToSymexApplication("Gopinath", "Symx@15#");
        login.selectBranch("BUR DUBAI");
        login.clickContinue();

        HomePage homepage = new HomePage();
        String actualTitle = homepage.getSymexTitle();

        Assert.assertEquals(actualTitle,"Symex");
        Thread.sleep(5000);

    }
}
