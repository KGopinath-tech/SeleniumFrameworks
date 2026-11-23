package com.cinque.tests;

import com.cinque.annotations.FrameworkAnnotation;
import com.cinque.config.Configfactory;
import com.cinque.pages.CustomerRegistrationPage;
import com.cinque.pages.HomePage;
import com.cinque.pages.LoginPage;
import com.cinque.testdata.DTO.customerregisterdata.*;
import com.cinque.testdata.CustomerRegisterTestData;
import com.cinque.testdata.mapper.customerregistermapper.*;
import com.cinque.utils.DataProviderUtils;
import com.cinque.utils.RepresentativeDataReader;
import com.cinque.utils.MessageUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cinque.utils.MessageUtils.waitForNgxSpinner;
import static com.cinque.utils.SeleniumUtils.*;

import java.util.List;


public class CustomerRegisterTest extends BaseTest{

    @FrameworkAnnotation(category = {"Smoke","Regression"})
    @Test(description = "Verify Individual Customer Registration",dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void registerIndividualCustomer(CustomerRegisterTestData testdata) {
        LoginPage login = new LoginPage();
        login.loginToSymexApplication(testdata.getUsername(), testdata.getPassword());
        login.selectBranch(Configfactory.getConfig().entitySelection());
        login.clickContinue();

        HomePage homePage = new HomePage();
        String actualTitle = homePage.getSymexTitle();
        Assert.assertEquals(actualTitle, testdata.getExpectedTitle());
        homePage.getCustomerRegistration();

        CustomerRegistrationPage page = new CustomerRegistrationPage();
        page.fillIndividualPersonalDetails(IndividualPersonalDetailsMapper.map(testdata));
        page.clickExpandButton();
        page.fillAddressDetails(AddressDetailsMapper.map(testdata));
        page.fillEmploymentDetails(testdata.getEmployer(), testdata.getOccupation());
        page.fillIndividualFinancialDetails(FinancialDetailsMapper.map(testdata));
        page.fillIndividualOtherDetails(IndividualOtherDetailsMapper.map(testdata));
        page.fillPromoDetails(testdata.getPromoCode(),testdata.getPromoExpiryDate());
        page.fillIdentityDetails(IdentityDetailsMapper.map(testdata));
        page.clickSaveButton();
        page.clickConfirmationSaveButton();
        page.clickApproveButton();
        page.clickConfirmationApproveButton();
        MessageUtils.validateMessages(testdata.getToastType(), testdata.getExpectedMessage());
        waitForSleep(5000);

    }
    @FrameworkAnnotation(category = {"Regression"}, author = "Shinitha")
    @Test(description = "Verify Corporate Customer Registration",dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void registerCorporateCustomer(CustomerRegisterTestData testdata) {
        LoginPage login = new LoginPage();
        login.loginToSymexApplication(testdata.getUsername(), testdata.getPassword());
        login.selectBranch(Configfactory.getConfig().entitySelection());
        login.clickContinue();

        HomePage homePage = new HomePage();
        String actualTitle = homePage.getSymexTitle();
        Assert.assertEquals(actualTitle, testdata.getExpectedTitle());
        homePage.getCustomerRegistration();

        CustomerRegistrationPage page = new CustomerRegistrationPage();
        page.selectCorporateCustomerType();
        page.fillCorporatePersonalDetails(CorporatePersonalDetailsMapper.map(testdata));
        page.clickExpandButton();
        page.fillAddressDetails(AddressDetailsMapper.map(testdata));
        page.fillCorporateFinancialDetails(FinancialDetailsMapper.map(testdata));
        page.fillCorporateOtherDetails(CorporateOtherDetailsMapper.map(testdata));
        //page.fillPromoDetails(testdata.getPromoCode(),testdata.getPromoExpiryDate());
        page.fillIdentityDetails(IdentityDetailsMapper.map(testdata));

        List<RepresentativeDetailsData> representatives = RepresentativeDataReader.getRepresentatives(testdata.getTestcasename());
        page.fillRepresentativeDetails(representatives);
        page.clickSaveButton();
        page.clickConfirmationSaveButton();
        page.clickApproveButton();
        page.clickConfirmationApproveButton();
        MessageUtils.validateMessages(testdata.getToastType(), testdata.getExpectedMessage());
        waitForSleep(5000);

    }

}
