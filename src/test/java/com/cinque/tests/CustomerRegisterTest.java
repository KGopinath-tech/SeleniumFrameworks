package com.cinque.tests;

import com.cinque.annotations.FrameworkAnnotation;
import com.cinque.config.Configfactory;
import com.cinque.pages.CustomerRegistrationPage;
import com.cinque.pages.HomePage;
import com.cinque.pages.LoginPage;
import com.cinque.testdata.DTO.*;
import com.cinque.testdata.TestData;
import com.cinque.testdata.mapper.*;
import com.cinque.utils.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CustomerRegisterTest extends BaseTest{

    @FrameworkAnnotation(category = {"Smoke","Regression"})
    @Test(description = "Verify Individual Customer Registration",dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void registerIndividualCustomer(TestData testdata) throws InterruptedException {
        LoginPage login = new LoginPage();
        login.loginToSymexApplication(testdata.getUsername(), testdata.getPassword());
        Thread.sleep(2000);
        login.selectBranch(Configfactory.getConfig().entitySelection());
        login.clickContinue();

        HomePage homepage = new HomePage();
        String actualTitle = homepage.getSymexTitle();
        Assert.assertEquals(actualTitle, testdata.getExpectedTitle());

        HomePage homePage = new HomePage();
        homePage.clickOnSidebar();

        Thread.sleep(1000);
        homePage.getGeneralMenu();
        homePage.getCustomerRegistration();
        Thread.sleep(2000);

        PersonalDetailsData personalData = IndividualPersonalDetailsMapper.map(testdata);
        AddressDetailsData  addressData = AddressDetailsMapper.map(testdata);
        FinancialDetailsData financialData = FinancialDetailsMapper.map(testdata);
        OtherDetailsData otherData = IndividualOtherDetailsMapper.map(testdata);
        IdentityDetailsData identityData = IdentityDetailsMapper.map(testdata);

        CustomerRegistrationPage page = new CustomerRegistrationPage();
        page.fillIndividualPersonalDetails(personalData);
        page.clickExpandButton();
        Thread.sleep(1000);
        page.fillAddressDetails(addressData);
        page.fillEmploymentDetails(testdata.getEmployer(), testdata.getOccupation());
        Thread.sleep(1000);
        page.fillFinancialDetails(financialData);
        page.fillIndividualOtherDetails(otherData);
        page.fillPromoDetails(testdata.getPromoCode(),testdata.getPromoExpiryDate());
        Thread.sleep(1000);
        page.fillIdentityDetails(identityData);
        Thread.sleep(1000);
        page.clickSaveButton();
        page.clickConfirmationSaveButton();
        Thread.sleep(60000);
    }
//    @FrameworkAnnotation(category = {"Regression"}, author = "Shinitha")
//    @Test(description = "Verify Corporate Customer Registration",dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
//    public void registerCorporateCustomer(TestData testdata) throws InterruptedException {
//        LoginPage login = new LoginPage();
//        login.loginToSymexApplication(testdata.getUsername(), testdata.getPassword());
//        Thread.sleep(2000);
//        login.selectBranch(Configfactory.getConfig().entitySelection());
//        login.clickContinue();
//
//        HomePage homepage = new HomePage();
//        String actualTitle = homepage.getSymexTitle();
//        Assert.assertEquals(actualTitle, testdata.getExpectedTitle());
//
//        HomePage homePage = new HomePage();
//        homePage.clickOnSidebar();
//
//        Thread.sleep(1000);
//        homePage.getGeneralMenu();
//        homePage.getCustomerRegistration();
//        Thread.sleep(2000);
//
//        PersonalDetailsData personalData = CorporatePersonalDetailsMapper.map(testdata);
//        AddressDetailsData  addressData = AddressDetailsMapper.map(testdata);
//        FinancialDetailsData financialData = FinancialDetailsMapper.map(testdata);
//        OtherDetailsData otherData = CorporateOtherDetailsMapper.map(testdata);
//        IdentityDetailsData identityData = IdentityDetailsMapper.map(testdata);
//
//        CustomerRegistrationPage page = new CustomerRegistrationPage();
//        page.fillIndividualPersonalDetails(personalData);
//        page.clickExpandButton();
//        Thread.sleep(1000);
//        page.fillAddressDetails(addressData);
//        page.fillEmploymentDetails(testdata.getEmployer(), testdata.getOccupation());
//        Thread.sleep(1000);
//        page.fillFinancialDetails(financialData);
//        page.fillIndividualOtherDetails(otherData);
//        page.fillPromoDetails(testdata.getPromoCode(),testdata.getPromoExpiryDate());
//        Thread.sleep(1000);
//        page.fillIdentityDetails(identityData);
//        Thread.sleep(1000);
//        page.clickSaveButton();
//        page.clickConfirmationSaveButton();
//        Thread.sleep(60000);
//    }

}
