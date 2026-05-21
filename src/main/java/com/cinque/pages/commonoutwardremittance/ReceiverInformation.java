package com.cinque.pages.commonoutwardremittance;

import static com.cinque.enums.WaitType.*;

import com.cinque.testdata.DTO.outwardremittancedata.ReceiverInformationData;
import org.openqa.selenium.By;

import static com.cinque.utils.MessageUtils.waitForNgxSpinner;
import static com.cinque.utils.SeleniumUtils.*;

public class ReceiverInformation {

    private static final By DRP_RECEIVER_TYPE = By.id("receiverType");
    private static final By DRP_RECEIVER_GENDER = By.id("receiverGender");
    private static final By TXT_RECEIVER_FIRSTNAME = By.id("receiverFirstName");
    private static final By TXT_RECEIVER_MIDDLENAME = By.id("receiverMiddleName");
    private static final By TXT_RECEIVER_LASTNAME = By.id("receiverLastName");
    private static final By TXT_RECEIVER_ADDRESS = By.id("receiverAddress1");
    private static final By TXT_RECEIVER_CITY = By.id("receiverCity");
    private static final By DRP_RECEIVER_COUNTRY = By.id("receiverCountry");
    private static final By DRP_RECEIVER_NATIONALITY = By.id("receiverNationality");
    private static final By DRP_RECEIVER_MOBILE_CODE = By.id("receiverMobileCode");
    private static final By TXT_RECEIVER_MOBILE_NUMBER = By.id("receiverMobile");
    private static final By DRP_RECEIVER_IDTYPE = By.id("receiverIdType");
    private static final By TXT_RECEIVER_IDNUMBER = By.id("receiverIdNumber");
    private static final By TXT_ISSUE_DATE = By.xpath("//label[text()='Id Issue Date']/preceding-sibling::*//input");
    private static final By TXT_EXPIRY_DATE = By.xpath("//label[text()='Id Expiry Date']/preceding-sibling::*//input");
    private static final By DRP_RECEIVER_RELATIONSHIP = By.id("receiverRelation");
    private static final By DRP_RECEIVER_AIRPORT = By.id("receiverAirport");

    private void selectReceiverType(String receiverType) {
        selectDropdown(DRP_RECEIVER_TYPE, receiverType);
    }
    private void selectReceiverGender(String receiverGender) {
        selectDropdown(DRP_RECEIVER_GENDER, receiverGender);
    }
    private void enterReceiverFirstName(String receiverFirstName) {
        sendKeys(TXT_RECEIVER_FIRSTNAME, receiverFirstName, CLICKABLE , "Receiver First Name");
    }
    private void enterReceiverMiddleName(String receiverMiddleName) {
        sendKeys(TXT_RECEIVER_MIDDLENAME,  receiverMiddleName, CLICKABLE , "Receiver Middle Name");
    }
    private void enterReceiverLastName(String receiverLastName) {
        sendKeys(TXT_RECEIVER_LASTNAME,  receiverLastName, CLICKABLE , "Receiver Last Name");
    }
    private void enterReceiverAddress(String receiverAddress) {
        sendKeys(TXT_RECEIVER_ADDRESS, receiverAddress, CLICKABLE , "Receiver Address");
    }
    private void enterReceiverCity(String receiverCity) {
        sendKeys(TXT_RECEIVER_CITY,  receiverCity, CLICKABLE , "Receiver City");
    }
    private void selectReceiverCountry(String receiverCountry) {
        selectDropdownWithRetry(DRP_RECEIVER_COUNTRY, receiverCountry);
    }
    private void selectReceiverNationality(String receiverNationality) {
        selectDropdownWithRetry(DRP_RECEIVER_NATIONALITY, receiverNationality);
    }
    private void selectReceiverMobileCode(String receiverMobileCode) {
        selectDropdownWithRetry(DRP_RECEIVER_MOBILE_CODE, receiverMobileCode);
    }
    private void enterReceiverMobileNumber(String receiverMobileNumber) {
        sendKeys(TXT_RECEIVER_MOBILE_NUMBER, receiverMobileNumber, CLICKABLE , "Receiver Mobile Number");
    }
    private void selectIdType(String receiverIdType) {
        waitForSleep(1000);
        waitForNgxSpinner();
        selectDropdown(DRP_RECEIVER_IDTYPE, receiverIdType);
    }
    private void eneterReceiverIdNumber(String receiverIdNumber) {
        sendKeys(TXT_RECEIVER_IDNUMBER,  receiverIdNumber, CLICKABLE , "Receiver Id Number");
    }
    private void enterIssueDate(String receiverIssueDate) {
        sendKeys(TXT_ISSUE_DATE,  receiverIssueDate, CLICKABLE , "Issue Date");
    }
    private void enterExpiryDate(String receiverExpiryDate) {
        sendKeys(TXT_EXPIRY_DATE,  receiverExpiryDate, CLICKABLE, "Expiry Date");
    }
    private void selectReceiverRelationship(String receiverRelationship) {
        selectDropdownWithRetry(DRP_RECEIVER_RELATIONSHIP, receiverRelationship);
    }
    private void selectReceiverAirport(String receiverAirport) {
        selectDropdown(DRP_RECEIVER_AIRPORT, receiverAirport);
    }

    public void fillReceiverDetails(ReceiverInformationData data){
        selectReceiverType(data.getReceivertype());
        selectReceiverGender(data.getReceivergender());
        enterReceiverFirstName(data.getReceiverfirstname());
        if(isNotBlank(data.getReceivermiddlename())){
            enterReceiverMiddleName(data.getReceivermiddlename());
        }
        enterReceiverLastName(data.getReceiverlastname());
        if(isNotBlank(data.getReceiveraddress() )){
            enterReceiverAddress(data.getReceiveraddress());
        }
        if(isNotBlank(data.getReceivercity())){
            enterReceiverCity(data.getReceivercity());
        }
        if(isNotBlank(data.getReceivercountry())){
            selectReceiverCountry(data.getReceivercountry());
        }
        selectReceiverNationality(data.getReceivernationality());
        if(isNotBlank(data.getReceivermobilecode())){
            selectReceiverMobileCode(data.getReceivermobilecode());
        }
        if(isNotBlank(data.getReceivermobilenumber())){
            enterReceiverMobileNumber(data.getReceivermobilenumber());
        }
        if(isNotBlank(data.getReceiveridtype())){
            selectIdType(data.getReceiveridtype());
        }
        if(isNotBlank(data.getReceiveridnumber())){
            eneterReceiverIdNumber(data.getReceiveridnumber());
        }
        if(isNotBlank(data.getReceiveridissuedate())){
            enterIssueDate(data.getReceiveridissuedate());
        }
        if(isNotBlank(data.getReceiveridexpirydate())){
            enterExpiryDate(data.getReceiveridexpirydate());
        }
        selectReceiverRelationship(data.getReceiverrelationship());
        if(isNotBlank(data.getReceivernearbyairport())){
            selectReceiverAirport(data.getReceivernearbyairport());
        }
    }
}
