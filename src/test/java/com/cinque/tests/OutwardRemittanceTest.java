package com.cinque.tests;

import com.cinque.annotations.FrameworkAnnotation;
import com.cinque.config.Configfactory;
import com.cinque.pages.LoginPage;
import com.cinque.pages.OutwardRemittancePage;
import com.cinque.testdata.DTO.outwardremittancedata.*;
import com.cinque.testdata.OutwardRemittanceTestData;
import com.cinque.testdata.mapper.outwardremittancemapper.*;
import com.cinque.utils.DataProviderUtils;
import org.testng.annotations.Test;

import static com.cinque.utils.MessageUtils.waitForNgxSpinner;
import static com.cinque.utils.SeleniumUtils.waitforSleep;

public class OutwardRemittanceTest extends BaseTest {

    @FrameworkAnnotation(category = {"Funtional"}, author = "Gopinath")
    @Test(dataProvider = "getOutwardData", dataProviderClass = DataProviderUtils.class)
    public void InitiateOutwardRemittanceTTSale(OutwardRemittanceTestData testData) {
        LoginPage login = new LoginPage();
        login.loginToSymexApplication(testData.getUsername(), testData.getPassword());
        waitforSleep(1000);
        login.selectBranch(Configfactory.getConfig().entitySelection());
        login.clickContinue();
        waitforSleep(2000);
        OutwardRemittancePage  outwardRemittancePage = new OutwardRemittancePage();
        outwardRemittancePage.getOuwardemittanceScreen();
        waitforSleep(5000);

        ProductSectionData productSectionData = ProductSectionMapper.map(testData);
        AmountAndRatesData amountAndRatesData = AmountAndRatesMapper.map(testData);
        RemitterInformationData remitterData = RemitterInformationMapper.map(testData);
        ReceiverInformationData ReceiverData = ReceiverInformationMapper.map(testData);
        ComplianceInformationData complianceData = ComplianceInformationMapper.map(testData);

        outwardRemittancePage.fillProductSectionDetails(productSectionData);
        waitforSleep(1000);
        outwardRemittancePage.fillAmountAndRates(amountAndRatesData);
        waitforSleep(1000);
        outwardRemittancePage.fillRemitterInformation(remitterData);
        waitforSleep(2000);
        outwardRemittancePage.fillReceiverInformation(ReceiverData);
        waitforSleep(1000);
        outwardRemittancePage.fillComplianceDetails(complianceData);
        waitforSleep(1000);
        outwardRemittancePage.clickOnSave();
        waitforSleep(1000);

    }
}
