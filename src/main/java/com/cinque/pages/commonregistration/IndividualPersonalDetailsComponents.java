package com.cinque.pages.commonregistration;

import com.cinque.pages.CustomerRegistrationPage;
import com.cinque.testdata.DTO.PersonalDetailsData;
import org.openqa.selenium.By;

import static com.cinque.enums.WaitType.CLICKABLE;
import static com.cinque.utils.SeleniumUtils.click;
import static com.cinque.utils.SeleniumUtils.sendKeys;

public class IndividualPersonalDetailsComponents {


    private static final By DRP_CUSTOMER_CATEGORY = By.xpath("//div[@id='Category']");
    private static final By DRP_RISK_CATEGORY = By.xpath("//div[@id='RiskCategory']");
    private static final By DRP_RESIDENT_TYPE = By.xpath("//div[@id='ResidentType']");
    private static final By DRP_GENDER = By.xpath("//div[@id='Gender']");
    private static final By DRP_MARITAL_STATUS = By.xpath("//div[@id='MaterialStatus']");
    private static final By CHK_EID_READER = By.xpath("//div[@id='flexCheckDefault']");
    private static final By TXT_FIRSTNAME = By.xpath("//input[@id='FirstName']");
    private static final By TXT_MIDDLENAME = By.xpath("//input[@id='MiddleName']");
    private static final By TXT_LASTNAME = By.xpath("//input[@id='LastName']");
    private static final By TXT_FIRSTUNICODENAME = By.xpath("//input[@id='FirstUnicodeName']");
    private static final By TXT_MIDDLEUNICODENAME = By.xpath("//input[@id='MiddleUnicodeName']");
    private static final By TXT_LASTUNICODENAME = By.xpath("//input[@id='LastUnicodeName']");
    private static final By TXT_DOB = By.xpath("//input[@class='p-element ng-tns-c1685646730-107 p-inputtext p-component ng-star-inserted']");
    private static final By DRP_NATIONALITY = By.xpath("//input[@id='Nationality']");
    private static final By DRP_DUALNATIONALITY = By.xpath("//input[@id='Dualnationality']");
    private static final By DRP_COUNTRYOFBIRTH = By.xpath("//input[@id='CountryOfBirth']");
    private static final By TXT_PLACEOFBIRTH = By.xpath("//input[@id='PlaceOfBirth']");
    private static final By DRP_PHONECODE = By.xpath("//input[@id='Phonecountrycode']");
    private static final By TXT_MOBILE = By.xpath("//input[@id='Mobilenumber']");
    private static final By TXT_PHONE = By.xpath("//input[@id='Phonenumber']");
    private static final By TXT_EMAIL = By.xpath("//input[@id='Email']");


    private By dropDownOptions(String value){
        return By.xpath("///li[normalize-space()='" + value + "']");
    }

    private void selectDropdown(By dropdown, String value){
        click(dropdown, CLICKABLE);
        click(dropDownOptions(value), CLICKABLE);
    }

    private void clickCuatomerCategory(String customerCategory){
        selectDropdown(DRP_CUSTOMER_CATEGORY, customerCategory);
    }
    private void clickRiskCategory(String riskCategory){
        selectDropdown(DRP_RISK_CATEGORY, riskCategory);
    }
    private IndividualPersonalDetailsComponents clickResidentType(String residentType){
        selectDropdown(DRP_RESIDENT_TYPE, residentType);
        return this;
    }
    private void clickGender(String gender){
        selectDropdown(DRP_GENDER, gender);
    }
    private void clickMaritalStatus(String materialStatus){
        selectDropdown(DRP_MARITAL_STATUS, materialStatus);
    }
    private IndividualPersonalDetailsComponents clickEIDReader(){
        click(CHK_EID_READER, CLICKABLE, "EID Reader");
        return this;
    }
    private void enterFirstName(String firstName){
        sendKeys(TXT_FIRSTNAME, firstName, CLICKABLE,"First Name");
    }
    private void enterMiddleName(String middleName){
        sendKeys(TXT_MIDDLENAME, middleName, CLICKABLE,"Middle Name");
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
        selectDropdown(DRP_NATIONALITY, nationality);
    }
    private void selectDualNationality(String dualNationality){
        selectDropdown(DRP_DUALNATIONALITY, dualNationality);
    }
    private void selectCountryOfBirth(String countryOfBirth) {
        selectDropdown(DRP_COUNTRYOFBIRTH, countryOfBirth);
    }
    private void enterPlaceOfBirth(String placeOfBirth){
        sendKeys(TXT_PLACEOFBIRTH,placeOfBirth, CLICKABLE,"PlaceOfBirth");
    }
    private void selectPhoneCode (String phoneCode){
        selectDropdown(DRP_PHONECODE, phoneCode);
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

    public IndividualPersonalDetailsComponents fillPersonalDetails(PersonalDetailsData data){
         clickCuatomerCategory(data.getCustomercategory());
         clickRiskCategory(data.getRiskcategory());
         clickResidentType(data.getResidenttype());
         clickGender(data.getGender());
         clickMaritalStatus(data.getMaterialstatus());
         enterFirstName(data.getFirstname());
         enterMiddleName(data.getMiddlename());
         enterLastName(data.getLastname());
         enterFirstUnicodeName(data.getFirstunicodename());
         enterMiddleUnicodeName(data.getMiddleunicodename());
         enterLastUnicodeName(data.getLastunicodename());
         enterDOB(data.getDob());
         selectNationality(data.getNationality());
         selectDualNationality(data.getDualnationality());
         selectCountryOfBirth(data.getCountryofbirth());
         enterPlaceOfBirth(data.getPlaceofbirth());
         selectPhoneCode(data.getPhonecode());
         enterMobileNumber(data.getMobilenumber());
         enterPhoneNumber(data.getPhonenumber());
         enterEmailID(data.getEmail());
         return this;
    }
}
