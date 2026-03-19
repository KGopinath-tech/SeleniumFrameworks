package com.cinque.pages.commonregistration;

import com.cinque.testdata.DTO.PersonalDetailsData;
import org.openqa.selenium.By;

import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.*;

public class PersonalDetailsComponents {


    private static final By DRP_CUSTOMER_CATEGORY = By.id("Category");
    private static final By DRP_RISK_CATEGORY = By.id("RiskCategory");
    private static final By DRP_RESIDENT_TYPE = By.id("ResidentType");
    private static final By DRP_GENDER = By.id("Gender");
    private static final By DRP_MARITAL_STATUS = By.id("MaritalStatus");
    private static final By CHK_EID_READER = By.xpath("//label[normalize-space()='EID Read Status']/preceding-sibling::*[@id='flexCheckDefault']");
    private static final By TXT_FIRSTNAME = By.id("FirstName");
    private static final By TXT_MIDDLENAME = By.id("MiddleName");
    private static final By TXT_LASTNAME = By.id("LastName");
    private static final By TXT_FIRSTUNICODENAME = By.id("FirstUnicodeName");
    private static final By TXT_MIDDLEUNICODENAME = By.id("MiddleUnicodeName");
    private static final By TXT_LASTUNICODENAME = By.id("LastUnicodeName");
    private static final By TXT_DOB = By.xpath("//label[text()='Date of Birth']/preceding-sibling::*//input");
    private static final By DRP_NATIONALITY = By.id("Nationality");
    private static final By DRP_DUALNATIONALITY = By.id("Dualnationality");
    private static final By DRP_COUNTRYOFBIRTH = By.id("CountryOfBirth");
    private static final By TXT_PLACEOFBIRTH = By.id("PlaceOfBirth");
    private static final By DRP_PHONECODE = By.id("Phonecountrycode");
    private static final By TXT_MOBILE = By.id("Mobilenumber");
    private static final By TXT_PHONE = By.id("Phonenumber");
    private static final By TXT_EMAIL = By.id("Email");
    private static final By DRP_COMPNAY_TYPE = By.id("CompanyType");
    private static final By TXT_DATE_OF_ESTABLISHMENT = By.xpath("//label[text()='Date Of Establishment']/preceding-sibling::*//input");
    private static final By DRP_COUNTRY_OF_INCORPORATION = By.id("CountryOfIncorporate");
    private static final By TXT_PLACE_OF_INCORPORATION = By.id("PlaceOfIncorporate");


    private void clickCustomerCategory(String customerCategory){
        selectDropdown(DRP_CUSTOMER_CATEGORY, customerCategory);
    }
    private void clickRiskCategory(String riskCategory){
        selectDropdown(DRP_RISK_CATEGORY, riskCategory);
    }
    private void clickResidentType(String residentType){
        selectDropdown(DRP_RESIDENT_TYPE, residentType);
    }
    private void clickGender(String gender){
        selectDropdown(DRP_GENDER, gender);
    }
    private void clickMaritalStatus(String materialStatus){
        selectDropdown(DRP_MARITAL_STATUS, materialStatus);
    }
    private void clickEIDReader(){
        click(CHK_EID_READER, CLICKABLE, "EID Reader");
    }
    private void enterFirstName(String firstName){
        sendKeys(TXT_FIRSTNAME, firstName, CLICKABLE,"First Name");
    }
    private void enterMiddleName(String middleName){
            sendKeys(TXT_MIDDLENAME, middleName, CLICKABLE, "Middle Name");
    }
    private void enterLastName(String lastName){
        sendKeys(TXT_LASTNAME, lastName, CLICKABLE,"Last Name");
    }
    private void enterFirstUnicodeName(String firstUnicodeName){
            sendKeys(TXT_FIRSTUNICODENAME, firstUnicodeName, CLICKABLE,"First Unicode Name");
    }
    private void enterMiddleUnicodeName(String middleUnicodeName){
            sendKeys(TXT_MIDDLEUNICODENAME, middleUnicodeName, CLICKABLE,"Middle Unicode Name");
    }
    private void enterLastUnicodeName(String lastUnicodeName){
            sendKeys(TXT_LASTUNICODENAME, lastUnicodeName, CLICKABLE,"Last Unicode Name");
    }
    private void enterDOB(String DOB) {
        sendKeys(TXT_DOB, DOB, CLICKABLE,"DOB");
    }
    private void selectNationality(String nationality){
        selectDropDown(DRP_NATIONALITY, nationality);
    }
    private void selectDualNationality(String dualNationality){
        selectDropDown(DRP_DUALNATIONALITY, dualNationality);
    }
    private void selectCountryOfBirth(String countryOfBirth) {
        selectDropDown(DRP_COUNTRYOFBIRTH, countryOfBirth);
    }
    private void enterPlaceOfBirth(String placeOfBirth){
        sendKeys(TXT_PLACEOFBIRTH,placeOfBirth, CLICKABLE,"PlaceOfBirth");
    }
    private void selectPhoneCode (String phoneCode){
        selectDropDown(DRP_PHONECODE, phoneCode);
    }
    private void enterMobileNumber(String mobileNumber){
        sendKeys(TXT_MOBILE, mobileNumber, CLICKABLE,"Mobile Number");
    }
    private void enterPhoneNumber(String phoneNumber){
            sendKeys(TXT_PHONE, phoneNumber, CLICKABLE,"Phone Number");
    }
    private void enterEmailID(String email) {
        sendKeys(TXT_EMAIL, email, CLICKABLE,"Email ID");
    }
    private void selectCompanyType(String companyType){selectDropDown(DRP_COMPNAY_TYPE, companyType);}
    private void enterDateOfEstablishment(String dateOfEstablishment){sendKeys(TXT_DATE_OF_ESTABLISHMENT,dateOfEstablishment, CLICKABLE,"DateOfEstablishment");}
    private void selectCountryOfIncorporation(String countryOfEstablishment){selectDropDown(DRP_COUNTRY_OF_INCORPORATION, countryOfEstablishment);}
    private void enterPlaceOfIncorporation(String placeOfEstablishment){sendKeys(TXT_PLACE_OF_INCORPORATION,placeOfEstablishment, CLICKABLE,"PlaceOfEstablishment");}


    public void fillIndividualPersonalDetails(PersonalDetailsData data){

         clickCustomerCategory(data.getCustomercategory());
         clickRiskCategory(data.getRiskcategory());
         clickResidentType(data.getResidenttype());
         clickGender(data.getGender());
         clickMaritalStatus(data.getMaterialstatus());
         enterFirstName(data.getFirstname());
         if(isNotBlank(data.getMiddlename())){
             enterMiddleName(data.getMiddlename());}
         enterLastName(data.getLastname());
         if(isNotBlank(data.getFirstunicodename())) {
             enterFirstUnicodeName(data.getFirstunicodename());
         }
         if(isNotBlank(data.getMiddleunicodename())){
             enterMiddleUnicodeName(data.getMiddleunicodename());
         }
         if(isNotBlank(data.getLastunicodename())) {
             enterLastUnicodeName(data.getLastunicodename());
         }
         enterDOB(data.getDob());
         selectNationality(data.getNationality());
         if(isNotBlank(data.getDualnationality())){
             selectDualNationality(data.getDualnationality());
         }
         selectCountryOfBirth(data.getCountryofbirth());
         enterPlaceOfBirth(data.getPlaceofbirth());
         selectPhoneCode(data.getPhonecode());
         enterMobileNumber(data.getMobilenumber());
         if(isNotBlank(data.getPhonenumber())){
             enterPhoneNumber(data.getPhonenumber());}
         enterEmailID(data.getEmail());
    }
    public void fillCorporatePersonalDetails(PersonalDetailsData data){
        selectCompanyType(data.getCompanytype());
        clickRiskCategory(data.getRiskcategory());
        clickResidentType(data.getResidenttype());
        enterFirstName(data.getFirstname());
        if(isNotBlank(data.getMiddlename())) { enterMiddleName(data.getMiddlename());}
        if(isNotBlank(data.getLastname())) { enterLastName(data.getLastname());}
        if(isNotBlank(data.getFirstunicodename())) {
            enterFirstUnicodeName(data.getFirstunicodename());
        }
        if(isNotBlank(data.getMiddleunicodename())){
            enterMiddleUnicodeName(data.getMiddleunicodename());
        }
        if(isNotBlank(data.getLastunicodename())) {
            enterLastUnicodeName(data.getLastunicodename());
        }
        enterDateOfEstablishment(data.getDateofestablishment());
        selectCountryOfIncorporation(data.getCountryofincorporation());
        selectNationality(data.getNationality());
        enterPlaceOfIncorporation(data.getPlaceofincorporation());
        selectPhoneCode(data.getPhonecode());
        enterMobileNumber(data.getMobilenumber());
        if(isNotBlank(data.getPhonenumber())){ enterPhoneNumber(data.getPhonenumber());}
        enterEmailID(data.getEmail());
    }

}
