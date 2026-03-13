package com.cinque.pages.commonregistration;

import com.cinque.testdata.DTO.WPSDetailsData;
import org.openqa.selenium.By;
import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.*;

public class WPSComponents {

    private static final By TXT_MOLID = By.id("WPSMOLID");
    private static final By TXT_VAT_GIBAN = By.id("WPSVATGIBAN");
    private static final By TXT_GPSSA_PENSION_GIBAN = By.id("WPSGpssaPensionGIBAN");
    private static final By TXT_Corporate_TAX_GIABN = By.id("WPSCorporateTaxGIBAN");
    private static final By DRP_COMPANY_TYPE = By.id("WPSCompany");
    private static final By TXT_ACCOUNT_NUMBER = By.id("WPSAccountNumber");
    private static final By TXT_ACCOUNT_NAME = By.id("WPSAccountName");
    private static final By DRP_BANK_NAME = By.id("WPSBankName");
    private static final By DRP_REGISTERED_BRANCH = By.id("WPSRegisteredBranch");
    private static final By DRP_ANNUAL_CHARGES = By.id("WPSAnnualCharges");
    private static final By TXT_ANNUAL_CHARGE_DATE = By.xpath("//label[normalize-space()='Annual Charge Date']/preceding-sibling::*//input");
    private static final By DRP_SERVICE_CHARGES = By.id("WPSServiceCharges");
    private static final By TXT_SIF_CHARGE = By.id("WPSSifCharge");
    private static final By TXT_ATM_CHARGE = By.id("WPSATMCharge");

    private void enterMOLID(String MOLID) {
        sendKeys(TXT_MOLID, MOLID, CLICKABLE, "MOL ID");
    }
    private void enterVAT_GIBAN(String VAT_GIBAN) {
        sendKeys(TXT_VAT_GIBAN, VAT_GIBAN, CLICKABLE, "VAT GIBAN");
    }
    private void enterGPSSA_PENSION(String GPSSA_PENSION) {
        sendKeys(TXT_GPSSA_PENSION_GIBAN, GPSSA_PENSION, CLICKABLE, "GPSSA Pension GIBAN");
    }
    private void enterCorporate_TAX_GIBAN(String TAX_GIBAN) {
        sendKeys(TXT_Corporate_TAX_GIABN,TAX_GIBAN, CLICKABLE, "Corporate Tax GIBAN" );
    }
    private void selectCompanyType(String companyType) {
        selectDropdown(DRP_COMPANY_TYPE, companyType);
    }
    private void enterAccountNumber(String accountNumber) {
        sendKeys(TXT_ACCOUNT_NUMBER, accountNumber, CLICKABLE, "Account Number");
    }
    private void enterAccountName(String accountName) {
        sendKeys(TXT_ACCOUNT_NAME, accountName, CLICKABLE, "Account Name");
    }
    private void selectBankName(String bankName) {
        selectDropdown(DRP_BANK_NAME, bankName);
    }
    private void selectRegisteredBranch(String branch) {
        selectDropdown(DRP_REGISTERED_BRANCH, branch);
    }
    private void selectAnnualCharges(String annualCharges) {
        selectDropdown(DRP_ANNUAL_CHARGES, annualCharges);
    }
    private void enterAnnualChargeDate(String annualChargeDate) {
        sendKeys(TXT_ANNUAL_CHARGE_DATE, annualChargeDate, CLICKABLE, "Annual Charge Date");
    }
    private void selectServiceCharges(String serviceCharges) {
        selectDropdown(DRP_SERVICE_CHARGES, serviceCharges);
    }
    private void enterSifCharge(String sifCharge) {
        sendKeys(TXT_SIF_CHARGE, sifCharge, CLICKABLE, "Sif Charge");
    }
    private void enterAtmCharge(String atmCharge) {
        sendKeys(TXT_ATM_CHARGE, atmCharge, CLICKABLE, "ATM Charge");
    }
    public void fillWPSDetails(WPSDetailsData data){
        enterMOLID(data.getMOLId());
        enterVAT_GIBAN(data.getVATGiban());
        enterGPSSA_PENSION(data.getGPSSAPenssionGiban());
        enterCorporate_TAX_GIBAN(data.getCorporateTaxGiban());
        selectCompanyType(data.getCompanyType());
        enterAccountNumber(data.getAccountNumber());
        enterAccountName(data.getAccountName());
        selectBankName(data.getBankName());
        selectRegisteredBranch(data.getRegisteredBranch());
        selectAnnualCharges(data.getAnnualCharges());
        enterAnnualChargeDate(data.getAnnualChargeDate());
        selectServiceCharges(data.getServiceCharges());
        enterSifCharge(data.getSIFCharge());
        enterAtmCharge(data.getATMCharge());
    }
}