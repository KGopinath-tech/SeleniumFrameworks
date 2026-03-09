package com.cinque.pages.commonregistration;

import com.cinque.testdata.DTO.RepresentativeDetailsData;
import org.openqa.selenium.By;
import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.*;

public class RepresentativeDetailsComponents {

    private static final By BTN_ADD = By.xpath("//app-representative[@class='ng-star-inserted']//button[@class='btn btn-animation btn-filled fs-medium'][normalize-space()='Add']");
    private static final By DRP_REPRESENTATIVE_TYPE = By.id("repType");
    private static final By DRP_REPRESENTATIVE_ADD_TO = By.id("repAddTo");
    private static final By TXT_REP_FIRSTNAME = By.id("repFirstName");
    private static final By TXT_REP_MIDDLENAME = By.id("repMiddleName");
    private static final By TXT_REP_LASTNAME = By.id("repLastName");
    private static final By DRP_REP_GENDER = By.id("repgender");
    private static final By TXT_REP_DOB = By.xpath("//label[text()='DOB']/preceding-sibling::*//input");
    private static final By DRP_REP_NATIONALITY = By.id("repNationality");
    private static final By DRP_REP_DUALNATIONALITY = By.id("repdualnationality");
    private static final By DRP_REP_PHONECODE = By.id("repcountrycode");
    private static final By TXT_REP_PHONE = By.id("repPhone");
    private static final By DRP_REP_IDTYPE = By.id("repIdCode");
    private static final By TXT_REP_IDNUMBER = By.id("repIdNo");
    private static final By TXT_REP_POI = By.id("repIdPoi");
    private static final By TXT_REP_ID_ISSUEDATE = By.xpath("//label[text()='ID Issued Date']/preceding-sibling::*//input");
    private static final By TXT_REP_ID_EXPIRYDATE = By.xpath("//label[text()='ID Expired Date']/preceding-sibling::*//input");
    private static final By DRP_REP_ID_ISSUEDCOUNTRY = By.id("repIdIssCon");
    private static final By TXT_REP_VISANO = By.id("repVisaNo");
    private static final By TXT_REP_VISA_IDEXPIREDATE = By.xpath("//label[text()='Visa Expiry Date']/preceding-sibling::*//input");
    private static final By DRP_REP_RELATION = By.id("repRelation");
    private static final By DGE_PEP = By.xpath("//label[contains(normalize-space(),'PEP')]/parent::*//*[@id='flexCheckDefault']");
    private static final By DGE_STATUS = By.xpath("//label[contains(normalize-space(),'Status')]/parent::*//*[@id='flexCheckDefault']");
    private static final By REP_FILE_UPLOAD = By.xpath("//p-fileupload//input[@type='file']");
    private static final By BTN_CANCEL = By.xpath("//button[normalize-space()='Cancel']");
    private static final By BTN_SAVE = By.xpath("//button[normalize-space()='Save']");

    private void clickAddButton() {
        click(BTN_ADD, CLICKABLE , "Add Button");
    }
    private void selectRepresentativeType(String type) {
        selectDropdown(DRP_REPRESENTATIVE_TYPE, type);
    }
    private void selectRepresentativeAddTo(String addTo) {
        selectDropdown(DRP_REPRESENTATIVE_ADD_TO, addTo);
    }
    private void enterRepFirstName(String firstName) {
        sendKeys(TXT_REP_FIRSTNAME, firstName,CLICKABLE, "Representative First Name");
    }
    private void enterRepMiddleName(String middleName) {
        sendKeys(TXT_REP_MIDDLENAME, middleName,CLICKABLE, "Representative Middle Name");
    }
    private void enterRepLastName(String lastName) {
        sendKeys(TXT_REP_LASTNAME, lastName,CLICKABLE, "Representative Last Name");
    }
    private void selectRepGender(String gender) {
        selectDropdown(DRP_REP_GENDER, gender);
    }
    private void enterRepDob(String dob) {
        selectDropdown(TXT_REP_DOB, dob);
    }
    private void selectRepNationality(String nationality) {
        selectDropDown(DRP_REP_NATIONALITY, nationality);
    }
    private void selectRepDualNationality(String dualNationality) {
        selectDropDown(DRP_REP_DUALNATIONALITY, dualNationality);
    }
    private void selectRepPhoneCode(String phoneCode) {
        selectDropDown(DRP_REP_PHONECODE, phoneCode);
    }
    private void enterRepPhoneNumber(String phoneNumber) {
        sendKeys(TXT_REP_PHONE, phoneNumber, CLICKABLE, "Representative Phone Number");
    }
    private void enterRepIdType(String idType) {
        selectDropdown(DRP_REP_IDTYPE, idType);
    }
    private void enterRepIdNumber(String idNumber) {
        sendKeys(TXT_REP_IDNUMBER, idNumber, CLICKABLE, "Representative ID Number");
    }
    private void enterPlaceOfIssue(String placeOfIssue) {
        sendKeys(TXT_REP_POI, placeOfIssue, CLICKABLE, "Representative Place Of Issue");
    }
    private void enterIdIssuedDate(String issuedDate) {
        sendKeys(TXT_REP_ID_ISSUEDATE, issuedDate, CLICKABLE, "Representative ID Issued Date");
    }
    private void enterIdExpireDate(String expireDate) {
        sendKeys(TXT_REP_ID_EXPIRYDATE, expireDate, CLICKABLE, "Representative ID Expiry Date");
    }
    private void enterIdIssuedCountry(String issuedCountry) {
        selectDropDown(DRP_REP_ID_ISSUEDCOUNTRY, issuedCountry);
    }
    private void enterVisaNumber(String visaNumber) {
        sendKeys(TXT_REP_VISANO,  visaNumber, CLICKABLE, "Representative Visa Number");
    }
    private void enterVisaIdExpireDate(String expireDate) {
        sendKeys(TXT_REP_VISA_IDEXPIREDATE, expireDate, CLICKABLE, "Representative Visa Expiry Date");
    }
    private void selectRepRelation(String relation) {
        selectDropdown(DRP_REP_RELATION, relation);
    }
    private void enablePep(){
        setToggle(DGE_PEP, false);
    }
    private void enableStatus(){
        setToggle(DGE_PEP, true);
    }
    private void uploadRepIdImage(String repId) {
        sendKeys(REP_FILE_UPLOAD, repId, CLICKABLE, "Representative Image File Upload");
    }
    private void clickCancel() {
        click(BTN_CANCEL, CLICKABLE, "Cancel");
    }
    private void clickSave() {
        click(BTN_SAVE, CLICKABLE, "Save");
    }

    public void fillRepresentativeDetails(RepresentativeDetailsData data) {
        clickAddButton();
        selectRepresentativeType(data.getRepresentativeType());
        enterRepFirstName(data.getRepresentativeFirstName());
        if(isNotBlank(data.getRepresentativeMiddleName())){
            enterRepMiddleName(data.getRepresentativeMiddleName());}
        enterRepLastName(data.getRepresentativeLastName());
        selectRepGender(data.getRepresentativeGender());
        enterRepDob(data.getRepresentativeDOB());
        selectRepNationality(data.getRepresentativeNationality());
        if(isNotBlank(data.getRepresentativeDualNationality())){
            selectRepDualNationality(data.getRepresentativeDualNationality()); }
        selectRepPhoneCode(data.getRepresentativePhoneCode());
        enterRepPhoneNumber(data.getRepresentativePhoneNumber());
        enterRepIdType(data.getRepresentativeIdType());
        enterRepIdNumber(data.getRepresentativeIdNumber());
        enterPlaceOfIssue(data.getPlaceOfIssue());
        enterIdIssuedDate(data.getIdIssueDate());
        enterIdExpireDate(data.getIdExpiryDate());
        enterIdIssuedCountry(data.getIdIssueCountry());
        if (isNotBlank(data.getVisaNumber())){
            enterVisaNumber(data.getVisaNumber());
        }
        enterVisaIdExpireDate(data.getVisaIdExpiryDate());
        selectRepRelation(data.getRelation());
        enableStatus();
        uploadRepIdImage(data.getRepIdImagePath());
        clickSave();
    }

}
