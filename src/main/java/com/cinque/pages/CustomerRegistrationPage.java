package com.cinque.pages;

import org.openqa.selenium.By;

import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.*;

public class CustomerRegistrationPage {

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
    public void clickCuatomerCategory(String value){selectDropdown(DRP_CUSTOMER_CATEGORY, value);}
    public void clickRiskCategory(String value){selectDropdown(DRP_RISK_CATEGORY, value);}
    public void clickResidentType(String value){selectDropdown(DRP_RESIDENT_TYPE, value);}
    public void clickGender(String value){selectDropdown(DRP_GENDER, value);}
    public void clickMaritalStatus(String value){selectDropdown(DRP_MARITAL_STATUS, value);}
    public void clickEIDReader(){click(CHK_EID_READER, CLICKABLE, "EID Reader");}
    public void enterFirstName(String value){sendKeys(TXT_FIRSTNAME, value, CLICKABLE,"First Name");}
    public void enterMiddleName(String value){sendKeys(TXT_MIDDLENAME, value, CLICKABLE,"Middle Name");}
    public void enterLastName(String value){sendKeys(TXTBOX_LASTNAME, value, CLICKABLE,"Last Name");}
    public void enterFirstUnicodeName(String value){sendKeys(TXT_FIRSTUNICODENAME, value, CLICKABLE,"First Unicode Name");}
    public void enterMiddleUnicodeName(String value){sendKeys(TXT_MIDDLEUNICODENAME, value, CLICKABLE,"Middle Unicode Name");}
    public void enterLastUnicodeName(String value){sendKeys(TXT_LASTUNICODENAME, value, CLICKABLE,"Last Unicode Name");}
    public void enterDOB(String value) {sendKeys(TXT_DOB, value, CLICKABLE,"DOB");}
    public void selectNationality(String value){selectDropdown(DRP_NATIONALITY, value);}
    public void selectDualNationality(String value){selectDropdown(DRP_DUALNATIONALITY, value);}
    public void selectCountryOfBirth(String value) {selectDropdown(DRP_COUNTRYOFBIRTH, value);}
    public void enterPlaceOfBirth(String value){sendKeys(TXT_PLACEOFBIRTH,value, CLICKABLE,"PlaceOfBirth");}
    public void selectPhoneCode (String value){selectDropdown(DRP_PHONECODE, value);}
    public void enterMobileNumber(String value){sendKeys(TXT_MOBILE, value, CLICKABLE,"Mobile Number");}
    public void enterPhoneNumber(String value){sendKeys(TXT_PHONE, value, CLICKABLE,"Phone Number");}
    public void enterEmailID(String value) {sendKeys(TXT_EMAIL, value, CLICKABLE,"Email ID");}

}

