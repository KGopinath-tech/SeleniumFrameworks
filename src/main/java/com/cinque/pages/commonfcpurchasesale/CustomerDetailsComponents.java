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
}
