package com.cinque.pages.commonfcpurchasesale;

import static com.cinque.utils.SeleniumUtils.*;
import static com.cinque.enums.WaitType.*;
import org.openqa.selenium.By;

public class CustomerDetailsComponents {

    private static final By TXT_FIRST_NAME = By.id("FirstName");
    private static final By TXT_MIDDLE_NAME = By.id("MiddleName");
    private static final By TXT_LAST_NAME = By.id("LastName");
    private static final By DRP_RISK_CATEGORY = By.id("RiskCategory");
    private static final By DRP_GENDER = By.id("Gender");
    private static final By DRP_RESIDENT_TYPE = By.id("Resident");
    private static final By DRP_NATIONALITY = By.id("Nationality");
    private static final By CLD_DOB = By.xpath("//label[normalize-space()='Date of Birth']/preceding-sibling::*//input");
    private static final By DRP_COUNTRY_OF_BIRTH = By.id("CountryOfBirth");
    private static final By TXT_MOBILE_NUMBER = By.id("Mobile");
    private static final By DRP_ID_TYPE = By.id("IDType");
    private static final By TXT_ID_NUMBER = By.id("IDNumber");
    private static final By CLD_ID_ISSUE_DATE = By.xpath("//label[normalize-space()='ID Issue Date']/preceding-sibling::*//input");
    private static final By CLD_ID_EXPIRY_DATE = By.xpath("//label[normalize-space()='ID Expiry Date']/preceding-sibling::*//input");
    private static final By DRP_COUNTRY_OF_ISSUE = By.id("CountryOfIssue");
    private static final By BTN_EXPAND = By.xpath("//a[contains(normalize-space(),'Show More')]");
    private static final By TXT_PLACE_OF_ISSUE = By.id("PlaceOfIssue");
    private static final By TXT_ADDRESS = By.id("Address1");
    private static final By TXT_EMAIL = By.id("EmailID");
    private static final By TXT_HOME_COUNTRY_ADDRESS = By.id("HomeCountryAddress");
    private static final By TXT_VISA_NUMBER = By.id("VisaNumber");
    private static final By CLD_VISA_EXPIRY_DATE = By.xpath("//label[normalize-space()='Visa Expiry Date']/preceding-sibling::*//input");
    private static final By DRP_ECONOMIC_ACTIVITY = By.id("EconomicActivity");
    private static final By TXT_EMPLOYER = By.id("Employer");
    private static final By DRP_OCCUPATION = By.id("Occupation");

    private static final By BTN_REGISTERED_CUSTOMER_SWITCH = By.xpath("//button[normalize-space()='Registered Customer']");
    private static final By BTN_SWITCH_CONFIRMATION_ACCEPT = By.xpath("//button[normalize-space()='Leave Page']");
    private static final By BTN_SWITCH_CONFIRMATION_CANCEL = By.xpath("//button[normalize-space()='Cancel']");

    private static final By TXT_REM_SEARCH = By.xpath("//input[@placeholder='Search by UID']");
    private static final By BTN_SEARCH = By.xpath("//button[@class='modern-search-button btn-animation']");
    private static final By BTN_POPUP_CLOSE = By.xpath("//button[contains(@class,'p-element p-ripple')]");
    private static final By BTN_ADVANCED_SEARCH = By.xpath("//button/*[contains(@class,'fa-solid fa-sliders slider-icon')]");
    private static final By BTN_REPRESENTATIVE = By.xpath("//div[normalize-space()='Select Representative']");

    private void enterFirstName( String firstName) { sendKeys(TXT_FIRST_NAME, firstName, CLICKABLE, "Customer First Name" ); }
    private void enterMiddleName( String middleName) { sendKeys(TXT_MIDDLE_NAME,  middleName, CLICKABLE, "Customer Middle Name" ); }
    private void enterLastName(String lastName) { sendKeys(TXT_LAST_NAME, lastName, CLICKABLE, "Customer Last Name" ); }
    private void selectRiskCategory(String category){ selectDropdownWithRetry(DRP_RISK_CATEGORY, category );}
    private void selectGender(String gender){ selectDropdownWithRetry(DRP_GENDER, gender); }
    private void selectResidentType(String residentType){ selectDropdownWithRetry(DRP_RESIDENT_TYPE, residentType);}
    private void selectNationality(String nationality){ selectDropdownWithRetry(DRP_NATIONALITY, nationality); }
    private void enterDOB(String dob){ sendKeys(CLD_DOB, dob, CLICKABLE, "Customer DOB" ); }
    private void selectBirthCountry(String birthCountry){ selectDropdownWithRetry(DRP_COUNTRY_OF_BIRTH, birthCountry); }
    private void enterMobileNo(String mobileNo){ sendKeys(TXT_MOBILE_NUMBER,  mobileNo, CLICKABLE, "Customer Mobile No" ); }
    private void selectIdType(String idType){ selectDropdownWithRetry(DRP_ID_TYPE, idType); }
    private void enterIdNumber(String idNumber){ sendKeys(TXT_ID_NUMBER, idNumber, CLICKABLE, "Customer ID Number" ); }
    private void enterIdIssueDate(String date){ sendKeys(CLD_ID_ISSUE_DATE, date, CLICKABLE, "Customer ID Issued Date" ); }
    private void enterIdExpireDate(String date){ sendKeys(CLD_ID_EXPIRY_DATE, date, CLICKABLE, "Customer ID Expiry Date" ); }
    private void selectCountryOfIssue(String country){ selectDropdownWithRetry(DRP_COUNTRY_OF_ISSUE, country); }
    private void expandCustomerSection(){ click(BTN_EXPAND , CLICKABLE); }
    private void enterPlaceOfIssue(String place){ sendKeys(TXT_PLACE_OF_ISSUE,  place, CLICKABLE, "Customer Place Of Issue" ); }
    private void enterAddress(String address){ sendKeys(TXT_ADDRESS, address, CLICKABLE, "Customer Address" ); }
    private void enterMail(String email){ sendKeys(TXT_EMAIL, email, CLICKABLE, "Customer Mail" ); }
    private void enterHomeAddress(String address){ sendKeys(TXT_HOME_COUNTRY_ADDRESS, address, CLICKABLE, "Customer Home Address" ); }
    private void enterVisaNumber(String visaNo){ sendKeys(TXT_VISA_NUMBER, visaNo, CLICKABLE, "Customer Visa Number" ); }
    private void enterVisaExpiryDate(String date){ sendKeys(CLD_VISA_EXPIRY_DATE, date, CLICKABLE, "Customer Visa Expiry Date" ); }
    private void selectEconomicActivity(String economicActivity){ selectDropdownWithRetry(DRP_ECONOMIC_ACTIVITY, economicActivity); }
    private void enterEmployerName(String employer){ sendKeys(TXT_EMPLOYER, employer, CLICKABLE, "Customer Employer Name" ); }
    private void selectOccupation(String occupation){ selectDropdownWithRetry(DRP_OCCUPATION, occupation); }

    private void registeredCustomerSwitch(){ click(BTN_REGISTERED_CUSTOMER_SWITCH, CLICKABLE); }
    private void customerSwitchConfirmation(){click(BTN_SWITCH_CONFIRMATION_ACCEPT, CLICKABLE); }
}
