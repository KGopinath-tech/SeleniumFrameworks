package com.cinque.pages.commonfcpurchasesale;

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
}
