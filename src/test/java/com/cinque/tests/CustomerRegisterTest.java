package com.cinque.tests;

import com.cinque.annotations.FrameworkAnnotation;
import com.cinque.pages.CustomerRegistrationPage;
import com.cinque.pages.HomePage;
import com.cinque.pages.LoginPage;
import com.cinque.pages.commonregistration.IndividualPersonalDetailsComponents;
import com.cinque.testdata.DTO.IdentityDetailsData;
import com.cinque.testdata.DTO.PersonalDetailsData;
import com.cinque.testdata.TestData;
import com.cinque.testdata.mapper.PersonalDetailsMapper;
import com.cinque.utils.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CustomerRegisterTest extends BaseTest{

    @FrameworkAnnotation(category = {"Smoke","Regression"})
    @Test(description = "To check whether sidebar working to access menus",dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void registerCustomer(TestData testdata) throws InterruptedException {
        LoginPage login = new LoginPage();
        login.loginToSymexApplication(testdata.getUsername(), testdata.getPassword());
        Thread.sleep(2000);
        login.selectBranch("HEAD OFFICE");
        login.clickContinue();

        HomePage homepage = new HomePage();
        String actualTitle = homepage.getSymexTitle();
        Assert.assertEquals(actualTitle, testdata.getExpectedTitle());

        HomePage homePage = new HomePage();
        homePage.clickOnSidebar();

        Thread.sleep(3000);
        homePage.getGeneralMenu();
        homePage.getCustomerRegistration();
        Thread.sleep(5000);

        PersonalDetailsData personalData = PersonalDetailsMapper.map(testdata);

        CustomerRegistrationPage page = new CustomerRegistrationPage();
        page.fillIdentityDetails(personalData);

        Thread.sleep(5000);
    }
}
