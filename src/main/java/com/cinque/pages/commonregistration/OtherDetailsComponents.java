package com.cinque.pages.commonregistration;

import com.cinque.testdata.DTO.OtherDetailsData;
import org.openqa.selenium.By;
import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.*;

public class OtherDetailsComponents {
    private static final By TXT_REMARKS = By.id("Remarks");
    private static final By TXT_LOCATION = By.id("Location");
    private static final By DGE_RELATED_PARTY = By.xpath("//label[normalize-space()='Related Party']/preceding-sibling::*[@id='flexCheckDefault']");
    private static final By GGE_WATCHLIST = By.xpath("//label[normalize-space()='Watchlist']/preceding-sibling::*[@id='flexCheckDefault']");
    private static final By TXT_WATCHLIST_REMARKS = By.id("WatchlistRemarks");
    private static final By DGE_HIGHRISK = By.xpath("//label[normalize-space()='High Risk']/preceding-sibling::*[@id='flexCheckDefault']");
    private static final By TXT_HIGHRISK_REMARKS = By.id("HighRiskRemarks");
    private static final By TXT_CB_LICENCE = By.id("CBLicenseNo");
    private static final By DGE_PEP = By.xpath("//label[normalize-space()='Is Pep']/preceding-sibling::*[@id='flexCheckDefault']");
    private static final By TXT_CAD_IBAN = By.id("CADIban");
    private static final By DRP_REFERRED_BY = By.id("ReferredBy");
    private static final By DRP_EMPLOYEE = By.id("Employee");
    private static final By DRP_CB_BUSINESS_ACTIVITY = By.id("CBBusinessesActivity");
    private static final By DRP_COMPANY_LEGAL_STATUS = By.id("CompanyLegalstatus");
    private static final By TXT_VAT_REG_NO = By.id("VATRegistrationNo");
    private static final By TXT_CB_EXPIRY_DATE = By.xpath("//label[text()='CB License Expiry Date']/preceding-sibling::*//input");
    private static final By DRP_NATURE_OF_BUSINESS = By.id("NatureOfBusiness");
    private static final By DRP_NATURE_OF_BUSINESS_SUBTYPE = By.id("NatureOfBusinessSubType");
    private static final By DRP_COMPANY_SUB_TYPE = By.id("CompanySubType");
    private static final By TXT_UID = By.id("UId");
    private static final By TXT_OTHERS = By.id("Others");

    private void enterRemarks(String remarks) {
        sendKeys(TXT_REMARKS, remarks,CLICKABLE, "Customer Remarks");
    }
    private void enterLocation(String location) {
        sendKeys(TXT_LOCATION, location,CLICKABLE, "Location");
    }
    private void clickRelatedParty() {
        setToggle(DGE_RELATED_PARTY, true );
    }
    private void clickWatchlist() {
        setToggle(GGE_WATCHLIST, true );
    }
    private void enterWatchlistRemarks(String remarks) {
        sendKeys(TXT_WATCHLIST_REMARKS,  remarks,CLICKABLE, "Watchlist Remarks");
    }
    private void clickHighRisk() {
        setToggle(DGE_HIGHRISK, true );
    }
    private void enterHighRiskRemarks(String remarks) {
        sendKeys(TXT_HIGHRISK_REMARKS, remarks,CLICKABLE, "High Risk Remarks");
    }
    private void enterCBLicenseNo(String CBLicenseNo) {
        sendKeys(TXT_CB_LICENCE,  CBLicenseNo,CLICKABLE, "CBLical No");
    }
    private void clickPep() {
        setToggle(DGE_PEP, true );
    }
    private void enterCadIban(String CADIban) {
        sendKeys(TXT_CAD_IBAN, CADIban,CLICKABLE, "Cad Iban");
    }
    private void selectReferredBy(String referredBy) {
        selectDropdown(DRP_REFERRED_BY, referredBy);
    }
    private void selectEmployee(String employee) {
        if(isDisplayed(DRP_EMPLOYEE)){
            selectDropdownWithRetry(DRP_EMPLOYEE,employee);}}
    private void selectCBBusinessActivity(String businessActivity) {
        selectDropdownWithRetry(DRP_CB_BUSINESS_ACTIVITY, businessActivity);
    }
    private void selectCompanyLegalStatus(String companyLegalStatus) {
        selectDropdownWithRetry(DRP_COMPANY_LEGAL_STATUS, companyLegalStatus);
    }
    private void enterVATRegistrationNo(String VATRegistrationNo) {
        sendKeys(TXT_VAT_REG_NO, VATRegistrationNo,CLICKABLE, "VAT Registration No");
    }
    private void enterCBExpiryDate(String CBExpiryDate) {
        sendKeys(TXT_CB_EXPIRY_DATE, CBExpiryDate,CLICKABLE, "CB Expiry Date");
    }
    private void selectNatureOfBusiness(String natureOfBusiness) {
        selectDropdownWithRetry(DRP_NATURE_OF_BUSINESS, natureOfBusiness);
    }
    private void selectNatureOfBusinessSubType(String natureOfBusinessSubType) {
        selectDropdownWithRetry(DRP_NATURE_OF_BUSINESS_SUBTYPE, natureOfBusinessSubType);
    }
    private void selectCompanySubType(String companySubType) {
        selectDropDown(DRP_COMPANY_SUB_TYPE, companySubType);
    }
    private void enterUniqueRefNo(String uniqueRefNo) {
        sendKeys(TXT_UID, uniqueRefNo,CLICKABLE, "Unique Ref No");
    }
    private void enterOthers(String others) {
        sendKeys(TXT_OTHERS, others,CLICKABLE, "Others");
    }

    public void fillIndividualOtherDetails(OtherDetailsData data){
        enterRemarks(data.getRemarks());
        enterLocation(data.getLocation());
        clickRelatedParty();
        clickWatchlist();
        enterWatchlistRemarks(data.getWatchlistRemarks());
        clickHighRisk();
        enterHighRiskRemarks(data.getHighRiskRemarks());
        enterCBLicenseNo(data.getCADIban());
        clickPep();
        //enterCadIban(data.getCADIban());
        selectReferredBy(data.getReferredBy());
        if(data.getReferredBy().equalsIgnoreCase("Employee")){
            selectEmployee(data.getEmployee());
        }else if (data.getReferredBy().equalsIgnoreCase("Customer")){
            enterUniqueRefNo(data.getUID());
        }else
            enterOthers(data.getOthers());

    }
    public void fillCorpOtherDetails(OtherDetailsData data){
        selectCBBusinessActivity(data.getCBBusinessActivity());
        enterRemarks(data.getRemarks());
        selectCompanyLegalStatus(data.getCompanyLegalStatus());
        enterLocation(data.getLocation());
        clickRelatedParty();
        clickWatchlist();
        enterWatchlistRemarks(data.getWatchlistRemarks());
        clickHighRisk();
        enterHighRiskRemarks(data.getHighRiskRemarks());
        enterVATRegistrationNo(data.getVATRegistrationNumber());
        enterCBLicenseNo(data.getCBLicence());
        enterCBExpiryDate(data.getCBExpiryDate());
        selectNatureOfBusiness(data.getNatureOfBusiness());
        selectNatureOfBusinessSubType(data.getNatureOfBusinessSubtype());
        selectCompanySubType(data.getCompanySubtype());
        clickPep();
        //enterCadIban(data.getCADIban());
        selectReferredBy(data.getReferredBy());
        if(data.getReferredBy().equalsIgnoreCase("Employee")){
            selectEmployee(data.getEmployee());
        }else if (data.getReferredBy().equalsIgnoreCase("Customer")){
            enterUniqueRefNo(data.getUID());
        }else
            enterOthers(data.getOthers());
    }

}
