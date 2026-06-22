package com.cinque.pages.commoninwardremittance;

import com.cinque.testdata.DTO.inwardremittancedata.SenderDetailsData;
import org.openqa.selenium.By;
import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.*;

public class SenderComponent {

    private static final By DRP_SENDER_TYPE = By.id("senderType");
    private static final By TXT_SENDER_FIRSTNAME = By.id("senderFirstName");
    private static final By TXT_SENDER_MIDDLENAME = By.id("senderMiddleName");
    private static final By TXT_SENDER_LASTNAME = By.id("senderLastName");
    private static final By DRP_MOBILECODE = By.id("senderMobileCode");
    private static final By TXT_MOBILENO = By.id("senderMobile");
    private static final By TXT_ADDRESS = By.id("senderAddress");
    private static final By TXT_CITY = By.id("senderCity");
    private static final By DRP_COUNTRY = By.id("senderCountry");
    private static final By DRP_NATIONALITY = By.id("senderNationality");
    private static final By DRP_IDTYPE = By.id("senderIdType");
    private static final By TXT_IDNUMBER = By.id("senderIdNumber");
    private static final By TXT_ISSUE_PLACE = By.id("senderIssuePlace");
    private static final By CLD_ISSUE_DATE = By.xpath("//label[text()='Issue Date']/preceding-sibling::*//input");
    private static final By CLD_EXPIRY_DATE = By.xpath("(//label[text()='Expiry Date']/preceding-sibling::*//input)[2]");
    private static final By DRP_EMIRATE = By.id("senderEmirate");
    private static final By DRP_NEARBYAIRPORT = By.id("senderNearbyAirport");

    private void selectSenderType(String senderType) {selectDropdownWithRetry(DRP_SENDER_TYPE, senderType);}
    private void enterFirstName(String senderFirstName) {sendKeys(TXT_SENDER_FIRSTNAME, senderFirstName, CLICKABLE,"Sender First Name");}
    private void enterMiddleName(String senderMiddleName){sendKeys(TXT_SENDER_MIDDLENAME, senderMiddleName, CLICKABLE,"Sender Middle Name");}
    private void enterLastName(String senderLastName){sendKeys(TXT_SENDER_LASTNAME, senderLastName, CLICKABLE,"Sender Last Name");}
    private void selectMobileCode(String mobileCode){selectDropdownWithRetry(DRP_MOBILECODE, mobileCode);}
    private void enterMobileNumber(String mobileNumber){sendKeys(TXT_MOBILENO,  mobileNumber, CLICKABLE,"Mobile Number");}
    private void enterAddress(String address){sendKeys(TXT_ADDRESS, address, CLICKABLE,"Address");}
    private void enterCity(String city){sendKeys(TXT_CITY, city, CLICKABLE,"City");}
    private void selectCountry(String country){selectDropdownWithRetry(DRP_COUNTRY, country);}
    private void selectNationality(String country){selectDropdownWithRetry(DRP_NATIONALITY, country);}
    private void selectIdType(String idType){selectDropdownWithRetry(DRP_IDTYPE, idType);}
    private void enterIdNumber(String idNumber){sendKeys(TXT_IDNUMBER, idNumber, CLICKABLE,"ID Number");}
    private void enterIssuePlace(String issuePlace){sendKeys(TXT_ISSUE_PLACE,  issuePlace, CLICKABLE,"Issue Place");}
    private void enterIssueDate(String issueDate){sendKeys(CLD_ISSUE_DATE, issueDate, CLICKABLE,"Issue Date");}
    private void enterExpiryDate(String expiryDate){sendKeys(CLD_EXPIRY_DATE, expiryDate, CLICKABLE,"Expiry Date");}
    private void selectEmirate(String emirate){selectDropdownWithRetry(DRP_EMIRATE, emirate);}
    private void selectNearByAirport(String airport){selectDropdownWithRetry(DRP_NEARBYAIRPORT, airport);}

    public void fillSenderDetails(SenderDetailsData data){
        selectSenderType(data.getSendertype());
        enterFirstName(data.getFirstname());
        if(isNotBlank(data.getMiddlename())){enterMiddleName(data.getMiddlename());}
        enterLastName(data.getLastname());
        selectMobileCode(data.getMobilecode());
        enterMobileNumber(data.getMobile());
        enterAddress(data.getAddress());
        enterCity(data.getCity());
        selectCountry(data.getCountry());
        selectNationality(data.getNationality());
        selectIdType(data.getIdtype());
        enterIdNumber(data.getIdnumber());
        enterIssuePlace(data.getIdissueplace());
        enterIssueDate(data.getIdissuedate());
        enterExpiryDate(data.getIdexpirydate());
        if(isNotBlank(data.getEmirate()) && isDisplayed(DRP_EMIRATE)){
            selectEmirate(data.getEmirate());
        }
        selectNearByAirport(data.getNearbyairport());
    }
}
