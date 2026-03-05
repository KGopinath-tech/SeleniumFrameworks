package com.cinque.pages.commonregistration;

import com.cinque.testdata.DTO.FinancialDetailsData;
import org.openqa.selenium.By;

import static com.cinque.enums.WaitType.CLICKABLE;
import static com.cinque.utils.SeleniumUtils.*;
import static com.cinque.utils.SeleniumUtils.sendKeys;

public class FinancialDetailsComponents {

    private static final By DRP_SERVICE_TYPE = By.id("ServiceType");
    private static final By DRP_ECONOMIC_ACTIVITY = By.id("EconomicActivity");
    private static final By TXT_ANNUAL_INCOME = By.id("AnnualIncome");
    private static final By TXT_EXP_ANNUAL_AVT_REMITTANCE = By.id("ExpectedAnnualActivityRemittance");
    private static final By TXT_No_TXNS_REMITTANCE = By.id("NoOfTransactionsRemittance");
    private static final By TXT_EXP_ANNUAL_AVT_FC = By.id("ExpectedAnnualActivityFC");
    private static final By TXT_No_TXNS_FC = By.id("NoOfTransactionsFC");
    private static final By DRP_BLOCKED_COUNTRIES = By.id("BlockedCountries");
    private static final By TXT_CORE_ACTIVITIES = By.id("CoreActivities");

    private void selectServiceType(String serviceType) {
        selectDropdown(DRP_SERVICE_TYPE, serviceType);
    }
    private void selectEconomicActivity(String economicActivity) {
        selectDropdown(DRP_ECONOMIC_ACTIVITY, economicActivity);
    }
    private void enterAnnualIncome(String annualIncome) {
        sendKeys(TXT_ANNUAL_INCOME, annualIncome, CLICKABLE, "Annual Income" );
    }
    private void enterExpectedAnnualActivityRemittance(String expectedAnnualActivityRemittance) {
        if(isNotBlank(expectedAnnualActivityRemittance)){
            sendKeys(TXT_EXP_ANNUAL_AVT_REMITTANCE, expectedAnnualActivityRemittance, CLICKABLE, "Expected Annual Activity Remittance");
        }
    }
    private void enterNoOfTransactionsRemittance(String noOfTransactionsRemittance) {
        if(isNotBlank(noOfTransactionsRemittance)){
            sendKeys(TXT_No_TXNS_REMITTANCE, noOfTransactionsRemittance, CLICKABLE, "No Of Transaction Remittance" );
        }
    }
    private void enterExpectedAnnualActivityFC(String expectedAnnualActivityFC) {
        if(isNotBlank(expectedAnnualActivityFC)){
            sendKeys(TXT_EXP_ANNUAL_AVT_FC,  expectedAnnualActivityFC, CLICKABLE, "Expected Annual Activity FC");
        }
    }
    private void enterNoOfTransactionsFC(String noOfTransactionsFC) {
        if(isNotBlank(noOfTransactionsFC)){
            sendKeys(TXT_No_TXNS_FC,  noOfTransactionsFC, CLICKABLE, "No Of Transaction FC");
        }
    }
    private void selectBlockedCountries(String blockedCountries) {
        if(isNotBlank(blockedCountries)){
            selectDropdown(DRP_BLOCKED_COUNTRIES, blockedCountries);
        }
    }
    private void enterCoreActivities(String coreActivities) {
        if(isNotBlank(coreActivities)){
            sendKeys(TXT_CORE_ACTIVITIES,  coreActivities, CLICKABLE, "Core Activities");
        }
    }

    public void fillFinancialDetails(FinancialDetailsData data){
        selectServiceType(data.getServiceType());
        selectEconomicActivity(data.getEconomicActivity());
        enterAnnualIncome(data.getAnnualIncome());
        enterExpectedAnnualActivityRemittance(data.getExpectedAnnualActivityRemittance());
        enterNoOfTransactionsRemittance(data.getNumberOfTransactionsRemittance());
        enterExpectedAnnualActivityFC(data.getExpectedAnnualActivityFC());
        enterNoOfTransactionsFC(data.getNumberOfTransactionsFC());
        selectBlockedCountries(data.getBlockedCountries());
        enterCoreActivities(data.getCoreActivities());
    }
}
