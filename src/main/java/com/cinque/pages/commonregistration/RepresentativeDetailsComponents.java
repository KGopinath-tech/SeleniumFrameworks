package com.cinque.pages.commonregistration;

import org.openqa.selenium.By;

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
    private static final By TXT_REP_IDEXPIREDATE = By.xpath("//label[text()='Visa Expiry Date']/preceding-sibling::*//input");
    private static final By DRP_REP_RELATION = By.id("repRelation");

}
