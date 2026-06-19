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

import static com.cinque.utils.SeleniumUtils.waitForSleep;

public class InwardRemittanceTest extends BaseTest {

    @FrameworkAnnotation(category = {"Integration", "Regression"}, author = "Gopinath")
    @Test(dataProvider = "getInawardeData", dataProviderClass = DataProviderUtils.class)
    public void InwardRemittanceTest(InwardRemittanceTestData testData) {
        LoginPage login = new LoginPage();
        login.loginToSymexApplication(testData.getUsername(), testData.getPassword());
        waitForSleep(2500);
        login.selectBranch(Configfactory.getConfig().entitySelection());
        login.clickContinue();
        waitForSleep(2000);

        InwardRemittancePage inwardPage = new InwardRemittancePage();
        inwardPage.getInwardRemittanceScreen();
        waitForSleep(2500);

        inwardPage.fillPaymentDetails(PaymentDetailsMapper.map(testData));
        waitForSleep(2500);
        inwardPage.fillSenderDetails(SenderDetailsMapper.map(testData));
        waitForSleep(2500);
        inwardPage.fillReceiverDetails(ReceiverDetailsMapper.map(testData));
        waitForSleep(2500);
        inwardPage.clickOnSave();
        waitForSleep(2500);
    }
}
