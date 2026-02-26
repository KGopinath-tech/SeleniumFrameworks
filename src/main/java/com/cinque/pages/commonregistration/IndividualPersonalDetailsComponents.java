package com.cinque.pages.commonregistration;

import org.openqa.selenium.By;

import static com.cinque.enums.WaitType.CLICKABLE;
import static com.cinque.enums.WaitType.VISIBLE;
import static com.cinque.utils.SeleniumUtils.click;
import static com.cinque.utils.SeleniumUtils.sendKeys;

public class IndividualPersonalDetailsComponents {

    private static final By MENU_CUSTOMER_REGISTRATION = By.xpath("//span[text()='Customer Registration']");
    private static final By BTN_NEW = By.xpath("//button[text()=' New ']");
    private static final By BTN_SAVE = By.xpath("//button[normalize-space()='Save']");
    private static final By BTN_APPROVE = By.xpath("//button[normalize-space()='Approve']");
    private static final By BTN_PRINT = By.xpath("//button[normalize-space()='Print']");
    private static final By BTN_DEACTIVATE = By.xpath("//button[normalize-space()='Deactivate']");
    private static final By KEBAB_MENU = By.id("moreOptionsDropdown");
    private static final By BTN_EXPAND = By.xpath("//i[@class='fa-solid fa-angles-up']");
    private static final By DRP_CUSTOMER_CATEGORY = By.xpath("//div[@id='Category']");
    private static final By DRP_RISK_CATEGORY = By.xpath("//div[@id='RiskCategory']");
    private static final By DRP_RESIDENT_TYPE = By.xpath("//div[@id='ResidentType']");
    private static final By DRP_GENDER = By.xpath("//div[@id='Gender']");
    private static final By DRP_MARITAL_STATUS = By.xpath("//div[@id='MaterialStatus']");
    private static final By CHK_EID_READER = By.xpath("//div[@id='flexCheckDefault']");
    private static final By TXT_FIRSTNAME = By.xpath("//input[@id='FirstName']");
    private static final By TXT_MIDDLENAME = By.xpath("//input[@id='MiddleName']");
    private static final By TXTBOX_LASTNAME = By.xpath("//input[@id='LastName']");
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

    public void getCustomerRegistrationMenu(){click(MENU_CUSTOMER_REGISTRATION, CLICKABLE, "Register Button");}
    public void clickNewButton(){click(BTN_NEW, CLICKABLE, "New Button");}
    public void clickSaveButton(){click(BTN_SAVE, CLICKABLE, "Save Button");}
    public void clickApproveButton(){click(BTN_APPROVE, CLICKABLE, "Approve Button");}
    public void clickPrintButton(){click(BTN_PRINT, CLICKABLE, "Print Button");}
    public void clickDeactivateButton(){click(BTN_DEACTIVATE, CLICKABLE, "Deactivate Button");}
    public void clickKebabMenu(){click(KEBAB_MENU,VISIBLE, "Kebab Menu");}
    public void clickExpandButton(){click(BTN_EXPAND, CLICKABLE, "Expand");}
    public void clickCuatomerCategory(String customerCategory){selectDropdown(DRP_CUSTOMER_CATEGORY, customerCategory);}
    public void clickRiskCategory(String riskCategory){selectDropdown(DRP_RISK_CATEGORY, riskCategory);}
    public void clickResidentType(String idType){selectDropdown(DRP_RESIDENT_TYPE, idType);}
    public void clickGender(String gender){selectDropdown(DRP_GENDER, gender);}
    public void clickMaritalStatus(String materialStatus){selectDropdown(DRP_MARITAL_STATUS, materialStatus);}
    public void clickEIDReader(){click(CHK_EID_READER, CLICKABLE, "EID Reader");}
    public void enterFirstName(String firstName){sendKeys(TXT_FIRSTNAME, firstName, CLICKABLE,"First Name");}
    public void enterMiddleName(String middleName){sendKeys(TXT_MIDDLENAME, middleName, CLICKABLE,"Middle Name");}
    public void enterLastName(String lastName){sendKeys(TXTBOX_LASTNAME, lastName, CLICKABLE,"Last Name");}
    public void enterFirstUnicodeName(String firstUnicodeName){sendKeys(TXT_FIRSTUNICODENAME, firstUnicodeName, CLICKABLE,"First Unicode Name");}
    public void enterMiddleUnicodeName(String middleUnicodeName){sendKeys(TXT_MIDDLEUNICODENAME, middleUnicodeName, CLICKABLE,"Middle Unicode Name");}
    public void enterLastUnicodeName(String lastUnicodeName){sendKeys(TXT_LASTUNICODENAME, lastUnicodeName, CLICKABLE,"Last Unicode Name");}
    public void enterDOB(String DOB) {sendKeys(TXT_DOB, DOB, CLICKABLE,"DOB");}
    public void selectNationality(String nationality){selectDropdown(DRP_NATIONALITY, nationality);}
    public void selectDualNationality(String dualNationality){selectDropdown(DRP_DUALNATIONALITY, dualNationality);}
    public void selectCountryOfBirth(String countryOfBirth) {selectDropdown(DRP_COUNTRYOFBIRTH, countryOfBirth);}
    public void enterPlaceOfBirth(String placeOfBirth){sendKeys(TXT_PLACEOFBIRTH,placeOfBirth, CLICKABLE,"PlaceOfBirth");}
    public void selectPhoneCode (String value){selectDropdown(DRP_PHONECODE, value);}
    public void enterMobileNumber(String mobileNumber){sendKeys(TXT_MOBILE, mobileNumber, CLICKABLE,"Mobile Number");}
    public void enterPhoneNumber(String phoneNumber){sendKeys(TXT_PHONE, phoneNumber, CLICKABLE,"Phone Number");}
    public void enterEmailID(String email) {sendKeys(TXT_EMAIL, email, CLICKABLE,"Email ID");}
}
