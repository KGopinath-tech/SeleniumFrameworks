package com.cinque.tests;

import com.cinque.annotations.FrameworkAnnotation;
import com.cinque.config.Configfactory;
import com.cinque.pages.LoginPage;
import com.cinque.pages.SpecialRateRequestPage;
import com.cinque.testdata.DTO.specialraterequest.SpecialRateRequestData;
import com.cinque.testdata.SpecialRateRequestTestData;
import com.cinque.testdata.mapper.specialraterequest.FCSpecialRateRequestMapper;
import com.cinque.testdata.mapper.specialraterequest.RemittanceSpecialRateRequestMapper;
import com.cinque.utils.DataProviderUtils;
import com.cinque.utils.MessageUtils;
import org.testng.annotations.Test;

import static com.cinque.utils.MessageUtils.*;
import static com.cinque.utils.SeleniumUtils.*;

public class SpecialRateRequestTest extends BaseTest{

    @FrameworkAnnotation(category = {"Functional", "Regression"}, author = "Gopinath")
    @Test(dataProvider = "getSpecialRateData", dataProviderClass = DataProviderUtils.class)
    public void InitiateRemittanceSpecialRate(SpecialRateRequestTestData testData){
        LoginPage login = new LoginPage();
        login.loginToSymexApplication(testData.getUsername(), testData.getPassword());
        login.selectBranch(Configfactory.getConfig().entitySelection());
        login.clickContinue();

        SpecialRateRequestPage specialRateRequestPage = new SpecialRateRequestPage();
        specialRateRequestPage.getSpecialRateRequestScreen();

        specialRateRequestPage.initiateRMSpecialRateRequest(RemittanceSpecialRateRequestMapper.map(testData));
        specialRateRequestPage.clickOnSaveButton();
        specialRateRequestPage.clickOnApproveButton();
        validateMessages(testData.getToastType(), testData.getExpectedMessage());
        waitForSleep(2000);
    }
    @FrameworkAnnotation(category = {"Functional", "Regression"}, author = "Gopinath")
    @Test(dataProvider = "getSpecialRateData", dataProviderClass = DataProviderUtils.class)
    public void InitiateFcSpecialRate(SpecialRateRequestTestData testData){
        LoginPage login = new LoginPage();
        login.loginToSymexApplication(testData.getUsername(), testData.getPassword());
        login.selectBranch(Configfactory.getConfig().entitySelection());
        login.clickContinue();

        SpecialRateRequestPage specialRateRequestPage = new SpecialRateRequestPage();
        specialRateRequestPage.getSpecialRateRequestScreen();

        SpecialRateRequestData requestData = FCSpecialRateRequestMapper.map(testData);
        specialRateRequestPage.initiateFCSpecialRateRequest(requestData);
        specialRateRequestPage.clickOnSaveButton();
        specialRateRequestPage.clickOnApproveButton();
        validateMessages(testData.getToastType(), testData.getExpectedMessage());
        waitForSleep(2000);
    }
}
