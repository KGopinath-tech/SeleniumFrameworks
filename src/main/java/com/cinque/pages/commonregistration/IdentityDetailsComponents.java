package com.cinque.pages.commonregistration;

import com.cinque.pages.CustomerRegistrationPage;
import com.cinque.testdata.DTO.IdentityDetailsData;
import org.openqa.selenium.By;
import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.*;

public class IdentityDetailsComponents {

    private static final By BTN_ADD = By.xpath("//*[@class='p-element identification-table']/preceding::div[@class='add-button']/button");
    private static final By DRP_ID_TYPE = By.xpath("//div[@id='IDType']");
    private static final By TXT_ID_NUMBER = By.xpath("//input[@id='IDNo']");
    private static final By DRP_ID_ISSUECOUNTRY = By.xpath("//div[@id='IDIssueCountry']");
    private static final By TXT_ID_ISSUEPLACE = By.xpath("//input[@id='IDIssuePlace']");
    private static final By CLD_ID_ISSUEDATE = By.xpath("//label[text()='ID Issue Date']");
    private static final By CLD_ID_EXPIRYDATE = By.xpath("//label[text()='ID Expiry Date']");
    private static final By TXT_VISANUMBER = By.id("IDVisaNo");
    private static final By CLD_VISAEXPIRYDATE = By.xpath("//label[text()='Visa Expiry']");
    private static final By DGE_STATUS = By.xpath("//label[normalize-space()='Status']/parent::*//*[@id='flexCheckDefault']");
    private static final By DGE_DEFAULT = By.xpath("//label[normalize-space()=' Is Default']/parent::*//*[@id='flexCheckDefault']");
    private static final By BTN_UPLOAD = By.xpath("//p-fileupload//input[@type='file']");
    private static final By BTN_CANCEL = By.xpath("//button[normalize-space()='Cancel']");
    private static final By BTN_SAVE = By.xpath("//button[normalize-space()='Save']");


    private void clickAddButton() {
        click(BTN_ADD, CLICKABLE, "Add Button");
    }

    public void selectIdType(String IdType) {
        selectDropdown(DRP_ID_TYPE, IdType);
    }

    public void  enterIdNumber(String IdNumber) {
        sendKeys(TXT_ID_NUMBER, IdNumber, PRESENT, "ID Number");
    }
    public void  selectIdIssueCountry(String issueCountry) {
        selectDropdown(DRP_ID_ISSUECOUNTRY, issueCountry);
    }

    public void enterIdIssuePlace(String issuePlace) {
        sendKeys(TXT_ID_ISSUEPLACE, issuePlace, PRESENT, "ID Issue Place");
    }

    public void selectIdIssueDate(String issueDate) {
        sendKeys(CLD_ID_ISSUEDATE, issueDate, PRESENT, "ID Issue Date");
    }

    public void selectIdExpiryDate(String expiryDate) {
        sendKeys(CLD_ID_EXPIRYDATE, expiryDate, PRESENT, "Id Expiry Date");
    }

    public void enterVisaNumber(String visaNumber) {
        sendKeys(TXT_VISANUMBER, visaNumber, CLICKABLE, "Visa Number");
    }

    public void selectVisaExpDate(String visaExpDate) {
        sendKeys(CLD_VISAEXPIRYDATE, visaExpDate, PRESENT, "Visa Expiry Date");
    }

    public void enableStatus() {
        setToggle(DGE_STATUS, true);
    }

    public void enableDefault() {
        setToggle(DGE_DEFAULT, true);
    }

    public void uploadIdImages(String IdImagePath) {
        sendKeys(BTN_UPLOAD, IdImagePath, CLICKABLE, "Id Image Upload");
    }

    public void clickCancelButton() {
        click(BTN_CANCEL, CLICKABLE, "Cancel Button");
    }

    public void clickSaveButton() {
        click(BTN_SAVE, CLICKABLE, "Save Button");
    }

    public void fillIdentityDetials(IdentityDetailsData data){
        clickAddButton();
        selectIdType(data.getIdType());
        enterIdNumber(data.getIdNumber());
        selectIdIssueCountry(data.getIssueCountry());
        enterIdIssuePlace(data.getIssuePlace());
        selectIdIssueDate(data.getIssueDate());
        selectIdExpiryDate(data.getIdExpiryDate());
        enterVisaNumber(data.getVisaNumber());
        selectVisaExpDate(data.getVisaExpiryDate());
        enableStatus();
        uploadIdImages(data.getImagePath());
        clickSaveButton();
    }
}


