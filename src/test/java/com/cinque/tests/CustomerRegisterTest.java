package com.cinque.tests;

import com.cinque.annotations.FrameworkAnnotation;
import com.cinque.pages.CustomerRegistrationPage;
import com.cinque.pages.HomePage;
import com.cinque.pages.LoginPage;
import com.cinque.testdata.DTO.AddressDetailsData;
import com.cinque.testdata.DTO.FinancialDetailsData;
import com.cinque.testdata.DTO.OtherDetailsData;
import com.cinque.testdata.DTO.PersonalDetailsData;
import com.cinque.testdata.TestData;
import com.cinque.testdata.mapper.AddressDetailsMapper;
import com.cinque.testdata.mapper.FinancialDetailsMapper;
import com.cinque.testdata.mapper.OtherDetailsMapper;
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
        AddressDetailsData  addressData = AddressDetailsMapper.map(testdata);
        FinancialDetailsData financialData = FinancialDetailsMapper.map(testdata);
        OtherDetailsData otherData = OtherDetailsMapper.map(testdata);

        CustomerRegistrationPage page = new CustomerRegistrationPage();
        page.fillIndividualIdentityDetails(personalData);
        page.clickExpandButton();
        Thread.sleep(2000);
        page.fillAddressDetails(addressData);
        page.fillEmploymentDetails(testdata.getEmployer(), testdata.getOccupation());
        Thread.sleep(2000);
        page.fillFinancialDetails(financialData);
        page.fillIndividualOtherDetails(otherData);
        page.fillPromoDetails(testdata.getPromoCode(),testdata.getPromoExpiryDate());

        Thread.sleep(10000);
    }
}
