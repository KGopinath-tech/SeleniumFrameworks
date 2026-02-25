package com.cinque.components.commonregistration;

import org.openqa.selenium.By;
import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.*;

public class FinancialDetailsComponents {

    private By dropDownOptions(String value) {
        return By.xpath("///li[normalize-space()='" + value + "']");
    }

    private void selectDropdown(By dropdown, String value) {
        click(dropdown, CLICKABLE);
        click(dropDownOptions(value), CLICKABLE);
    }

    private static final By BTN_ADD = By.xpath("//div[@class='add-button']/button");
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


    public void clickAddButton() {
        click(BTN_ADD, CLICKABLE, "Add Button");
    }

    public FinancialDetailsComponents selectIdType(String IdType) {
        selectDropdown(DRP_ID_TYPE, IdType);
        return this;
    }

    public FinancialDetailsComponents enterIdNumber(String IdNumber) {
        sendKeys(TXT_ID_NUMBER, IdNumber, PRESENT, "ID Number");
        return this;
    }

    public FinancialDetailsComponents selectIdIssueCountry(String issueCountry) {
        selectDropdown(DRP_ID_ISSUECOUNTRY, issueCountry);
        return this;
    }

    public FinancialDetailsComponents enterIdIssuePlace(String issuePlace) {
        sendKeys(TXT_ID_ISSUEPLACE, issuePlace, PRESENT, "ID Issue Place");
        return this;
    }

    public FinancialDetailsComponents selectIdIssueDate(String issueDate) {
        sendKeys(CLD_ID_ISSUEDATE, issueDate, PRESENT, "ID Issue Date");
        return this;
    }

    public FinancialDetailsComponents selectIdExpiryDate(String expiryDate) {
        sendKeys(CLD_ID_EXPIRYDATE, expiryDate, PRESENT, "Id Expiry Date");
        return this;
    }

    public FinancialDetailsComponents enterVisaNumber(String visaNumber) {
        sendKeys(TXT_VISANUMBER, visaNumber, CLICKABLE, "Visa Number");
        return this;
    }

    public FinancialDetailsComponents selectVisaExpDate(String visaExpDate) {
        sendKeys(CLD_VISAEXPIRYDATE, visaExpDate, PRESENT, "Visa Expiry Date");
        return this;
    }

    public FinancialDetailsComponents enbaleStatus() {
        setToggle(DGE_STATUS, true);
        return this;
    }

    public FinancialDetailsComponents enbaleDefault() {
        setToggle(DGE_DEFAULT, true);
        return this;
    }

    public FinancialDetailsComponents uploadIdImages(String IdImagePath) {
        sendKeys(BTN_UPLOAD, IdImagePath, CLICKABLE, "Id Image Upload");
        return this;
    }

    public FinancialDetailsComponents clickCancelButton() {
        click(BTN_CANCEL, CLICKABLE, "Cancel Button");
        return this;
    }

    public FinancialDetailsComponents clickSaveButton() {
        click(BTN_SAVE, CLICKABLE, "Save Button");
        return this;
    }

}


