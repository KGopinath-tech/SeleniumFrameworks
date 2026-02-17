package com.cinque.tests;


import com.cinque.annotations.FrameworkAnnotation;
import com.cinque.pages.HomePage;
import com.cinque.pages.LoginPage;
import com.cinque.testdata.TestData;
import com.cinque.utils.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.*;


public class HomePageTest extends BaseTest{


    @FrameworkAnnotation(category = {"Smoke","Regression"})
    @Test(description = "To check Symex Title", dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void titleValidationTest(TestData testData) throws InterruptedException {

        LoginPage login = new LoginPage();
        login.loginToSymexApplication(testData.getUsername(), testData.getPassword());
        login.selectBranch("HEAD OFFICE");
        login.clickContinue();

        HomePage homepage = new HomePage();
        String actualTitle = homepage.getSymexTitle();

        Assert.assertEquals(actualTitle,testData.getExpectedTitle());
        Thread.sleep(5000);

    }
    @FrameworkAnnotation(category = "Integration")
    @Test(description = "To check whether sidebar working to access menus", dataProvider = "getData",
            dataProviderClass = DataProviderUtils.class)
    public void sideBarMenuTest(TestData testData ) throws InterruptedException {
        LoginPage login = new LoginPage();
        login.loginToSymexApplication(testData.getUsername(), testData.getPassword());
        login.selectBranch("HEAD OFFICE");
        login.clickContinue();

        HomePage homepage = new HomePage();
        String actualTitle = homepage.getSymexTitle();
        Assert.assertEquals(actualTitle,testData.getExpectedTitle());

        HomePage homePage = new HomePage();
        homePage.clickOnSidebar();
        String labelText = homePage.getMasterLabelText();
        Assert.assertEquals(labelText,"MASTERS");
    }
}

