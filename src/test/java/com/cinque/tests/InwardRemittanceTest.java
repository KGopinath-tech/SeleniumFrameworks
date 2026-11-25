package com.cinque.tests;

import com.cinque.annotations.FrameworkAnnotation;
import com.cinque.config.Configfactory;
import com.cinque.pages.InwardRemittancePage;
import com.cinque.pages.LoginPage;
import com.cinque.testdata.InwardRemittanceTestData;
import com.cinque.testdata.mapper.inwardremittancemapper.PaymentDetailsMapper;
import com.cinque.testdata.mapper.inwardremittancemapper.ReceiverDetailsMapper;
import com.cinque.testdata.mapper.inwardremittancemapper.SenderDetailsMapper;
import com.cinque.utils.DataProviderUtils;
import org.testng.annotations.Test;

import static com.cinque.utils.MessageUtils.*;
import static com.cinque.utils.SeleniumUtils.waitForSleep;

public class InwardRemittanceTest extends BaseTest {

    @FrameworkAnnotation(category = {"Integration", "Regression"}, author = "Gopinath")
    @Test(dataProvider = "getInawardeData", dataProviderClass = DataProviderUtils.class)
    public void InitiateInwardRemittanceTest(InwardRemittanceTestData testData) {
        LoginPage login = new LoginPage();
        login.loginToSymexApplication(testData.getUsername(), testData.getPassword());
        login.selectBranch(Configfactory.getConfig().entitySelection());
        login.clickContinue();

        InwardRemittancePage inwardPage = new InwardRemittancePage();
        inwardPage.getInwardRemittanceScreen();

        inwardPage.fillPaymentDetails(PaymentDetailsMapper.map(testData));
        inwardPage.fillSenderDetails(SenderDetailsMapper.map(testData));
        inwardPage.fillReceiverDetails(ReceiverDetailsMapper.map(testData));
        inwardPage.clickOnSave();
        inwardPage.clickOnApprove();
        validateMessages(testData.getToastType(), testData.getExpectedMessage());
        waitForSleep(2500);
    }
}
