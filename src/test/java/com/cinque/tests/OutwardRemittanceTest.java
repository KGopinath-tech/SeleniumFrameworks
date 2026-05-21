package com.cinque.tests;

import com.cinque.annotations.FrameworkAnnotation;
import com.cinque.config.Configfactory;
import com.cinque.pages.LoginPage;
import com.cinque.pages.OutwardRemittancePage;
import com.cinque.testdata.DTO.outwardremittancedata.*;
import com.cinque.testdata.OutwardRemittanceTestData;
import com.cinque.testdata.mapper.outwardremittancemapper.*;
import com.cinque.utils.DataProviderUtils;
import com.cinque.utils.MessageUtils;
import org.testng.annotations.Test;

import static com.cinque.utils.SeleniumUtils.waitForSleep;

public class OutwardRemittanceTest extends BaseTest {

    @FrameworkAnnotation(category = {"Funtional"}, author = "Gopinath")
    @Test(dataProvider = "getOutwardData", dataProviderClass = DataProviderUtils.class)
    public void InitiateOutwardRemittanceTTSale(OutwardRemittanceTestData testData) {
        LoginPage login = new LoginPage();
        login.loginToSymexApplication(testData.getUsername(), testData.getPassword());
        waitForSleep(1000);
        login.selectBranch(Configfactory.getConfig().entitySelection());
        login.clickContinue();
        waitForSleep(2000);
        OutwardRemittancePage  outwardRemittancePage = new OutwardRemittancePage();
        outwardRemittancePage.getOuwardemittanceScreen();
        waitForSleep(3000);

        ProductSectionData productSectionData = ProductSectionMapper.map(testData);
        AmountAndRatesData amountAndRatesData = AmountAndRatesMapper.map(testData);
        RemitterInformationData remitterData = RemitterInformationMapper.map(testData);
        ReceiverInformationData receiverData = ReceiverInformationMapper.map(testData);
        ComplianceInformationData complianceData = ComplianceInformationMapper.map(testData);

        outwardRemittancePage.fillProductSectionDetails(productSectionData);
        waitForSleep(1000);
        outwardRemittancePage.fillAmountAndRates(amountAndRatesData);
        waitForSleep(1000);
        outwardRemittancePage.fillRemitterInformation(remitterData);
        //waitForSleep(1000);
        outwardRemittancePage.fillReceiverInformation(receiverData);
        waitForSleep(1000);
        outwardRemittancePage.fillComplianceDetails(complianceData);
        waitForSleep(1000);
        outwardRemittancePage.clickOnSave();
        MessageUtils.validateMessages(testData.getToastType(), testData.getExpectedMessage());
        waitForSleep(1000);
    }
}
