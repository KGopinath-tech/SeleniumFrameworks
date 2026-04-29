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
import com.cinque.utils.RepresentativeDataReader;
import com.cinque.utils.MessageUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.cinque.utils.SeleniumUtils.*;

import java.util.List;


public class CustomerRegisterTest extends BaseTest{

    @FrameworkAnnotation(category = {"Smoke","Regression"})
    @Test(description = "Verify Individual Customer Registration",dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void registerIndividualCustomer(TestData testdata) {
        LoginPage login = new LoginPage();
        login.loginToSymexApplication(testdata.getUsername(), testdata.getPassword());
        waitforSleep(1000);
        login.selectBranch(Configfactory.getConfig().entitySelection());
        login.clickContinue();

        HomePage homepage = new HomePage();
        String actualTitle = homepage.getSymexTitle();
        Assert.assertEquals(actualTitle, testdata.getExpectedTitle());

        HomePage homePage = new HomePage();
        homePage.clickOnSidebar();

        //Thread.sleep(500);
        homePage.getGeneralMenu();
        homePage.getCustomerRegistration();

        PersonalDetailsData personalData = IndividualPersonalDetailsMapper.map(testdata);
        AddressDetailsData  addressData = AddressDetailsMapper.map(testdata);
        FinancialDetailsData financialData = FinancialDetailsMapper.map(testdata);
        OtherDetailsData otherData = IndividualOtherDetailsMapper.map(testdata);
        IdentityDetailsData identityData = IdentityDetailsMapper.map(testdata);

        CustomerRegistrationPage page = new CustomerRegistrationPage();
        waitforSleep(3500);
        page.fillIndividualPersonalDetails(personalData);
        page.clickExpandButton();
        waitforSleep(500);
        page.fillAddressDetails(addressData);
        page.fillEmploymentDetails(testdata.getEmployer(), testdata.getOccupation());
        page.fillIndividualFinancialDetails(financialData);
        page.fillIndividualOtherDetails(otherData);
        page.fillPromoDetails(testdata.getPromoCode(),testdata.getPromoExpiryDate());
        page.fillIdentityDetails(identityData);
        page.clickSaveButton();
        page.clickConfirmationSaveButton();
        MessageUtils.validateMessages(testdata.getToastType(), testdata.getExpectedMessage());

    }
    @FrameworkAnnotation(category = {"Regression"}, author = "Shinitha")
    @Test(description = "Verify Corporate Customer Registration",dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void registerCorporateCustomer(TestData testdata) {
        LoginPage login = new LoginPage();
        login.loginToSymexApplication(testdata.getUsername(), testdata.getPassword());
        waitforSleep(500);
        login.selectBranch(Configfactory.getConfig().entitySelection());
        login.clickContinue();

        HomePage homepage = new HomePage();
        String actualTitle = homepage.getSymexTitle();
        Assert.assertEquals(actualTitle, testdata.getExpectedTitle());

        HomePage homePage = new HomePage();
        homePage.clickOnSidebar();

        waitforSleep(500);
        homePage.getGeneralMenu();
        homePage.getCustomerRegistration();

        PersonalDetailsData corporateData = CorporatePersonalDetailsMapper.map(testdata);
        AddressDetailsData  addressData = AddressDetailsMapper.map(testdata);
        FinancialDetailsData financialData = FinancialDetailsMapper.map(testdata);
        OtherDetailsData otherData = CorporateOtherDetailsMapper.map(testdata);
        IdentityDetailsData identityData = IdentityDetailsMapper.map(testdata);

        CustomerRegistrationPage page = new CustomerRegistrationPage();
        waitforSleep(3500);
        page.selectCorporateCustomerType();
        page.fillCorporatePersonalDetails(corporateData);
        page.clickExpandButton();
        //Thread.sleep(500);
        page.fillAddressDetails(addressData);
        page.fillCorporateFinancialDetails(financialData);
        page.fillCorporateOtherDetails(otherData);
        //page.fillPromoDetails(testdata.getPromoCode(),testdata.getPromoExpiryDate());
        page.fillIdentityDetails(identityData);

        List<RepresentativeDetailsData> representatives = RepresentativeDataReader.getRepresentatives(testdata.getTestcasename());
        page.fillRepresentativeDetails(representatives);
        waitforSleep(500);
        page.clickSaveButton();
        page.clickConfirmationSaveButton();
        MessageUtils.validateMessages(testdata.getToastType(), testdata.getExpectedMessage());

    }

}
