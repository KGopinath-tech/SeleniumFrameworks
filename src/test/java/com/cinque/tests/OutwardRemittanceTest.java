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

import static com.cinque.utils.MessageUtils.waitForNgxSpinner;
import static com.cinque.utils.SeleniumUtils.waitForSleep;

public class OutwardRemittanceTest extends BaseTest {

    @FrameworkAnnotation(category = {"Funtional"}, author = "Gopinath")
    @Test(dataProvider = "getOutwardData", dataProviderClass = DataProviderUtils.class)
    public void InitiateOutwardRemittanceTTSale(OutwardRemittanceTestData testData) {
        LoginPage login = new LoginPage();
        login.loginToSymexApplication(testData.getUsername(), testData.getPassword());
        login.selectBranch(Configfactory.getConfig().entitySelection());
        login.clickContinue();

        OutwardRemittancePage  outwardRemittancePage = new OutwardRemittancePage();
        outwardRemittancePage.getOuwardemittanceScreen();

        waitForNgxSpinner();
        outwardRemittancePage.fillProductSectionDetails(ProductSectionMapper.map(testData));
        outwardRemittancePage.fillRemitterInformation(RemitterInformationMapper.map(testData));
        outwardRemittancePage.fillAmountAndRates(AmountAndRatesMapper.map(testData));
        outwardRemittancePage.fillReceiverInformation(ReceiverInformationMapper.map(testData));
        outwardRemittancePage.fillComplianceDetails(ComplianceInformationMapper.map(testData));
        outwardRemittancePage.clickOnSave();
        outwardRemittancePage.clickOnApprove();
        outwardRemittancePage.clickOnConfirmationApprove();

        MessageUtils.validateMessages(testData.getToastType(), testData.getExpectedMessage());

    }
}
