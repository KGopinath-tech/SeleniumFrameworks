package com.cinque.pages;

import org.openqa.selenium.By;

import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.MessageUtils.waitForNgxSpinner;
import static com.cinque.utils.SeleniumUtils.*;

public class SpecialRateRequestPage {

    private static final By BTN_REMITTANCE = By.xpath("//button[contains(.,'Remittance')]");
    private static final By BTN_FOREX = By.xpath("//button[contains(.,'Forex')]");
    private static final By BTN_SAVE = By.xpath("//button[contains(.,'Save')]");
    private static final By BTN_CLEAR = By.xpath("//button[contains(.,'Clear')]");
    private static final By BTN_APPROVE = By.xpath("//button[normalize-space()='Approve']");
    private static final By BTN_UPDATE = By.xpath("//button[normalize-space()='Update']");
    private static final By BTN_DELETE = By.xpath("//button[normalize-space()='Delete']");
    private static final By BTN_DISAPPROVE = By.xpath("//button[normalize-space()='DisApprove']");
    private static final By BTN_AUDITLOG = By.xpath("//a[normalize-space()='Audit Log']");

    private static final By TXT_SEARCHBOX = By.xpath("//input[@placeholder='Search By UID']");
    private static final By BTN_SEARCH = By.xpath("//button[@class='modern-search-button']");
    private static final By BTN_ADVANCED_SEARCH = By.xpath("//button[@class='advanced-btn ms-2']");
    private static final By DATE_VALUE_DATE = By.id("icondisplay");
    private static final By DRP_RMCURRENCY = By.id("rmcurrency");
    private static final By DRP_CORRESPONDENT = By.id("correspondent");
    private static final By DRP_PAYMODE = By.id("paymode");
    private static final By TXT_FCAMOUNT = By.id("fcAmount");
    private static final By TXT_LCAMOUNT = By.id("lcAmount");
    private static final By TXT_RMREMARK = By.id("fcRemark");
    private static final By TXT_APPROVALNO = By.id("approvalno");
    private static final By TXT_APPROVED_DATE = By.id("approvalDate");
    private static final By TXT_TRANSFER_RATE = By.xpath("//p-inputnumber[@inputid='transferrate']");
    private static final By TXT_SPECIAL_RATE = By.xpath("//p-inputnumber[@inputid='specialrate']");
    private static final By BTN_CONFIRMATION_LEAVEPAGE = By.xpath("//button[contains(.,'Leave Page')]");
    private static final By DRP_FCTYPE = By.id("fcType");
    private static final By DRP_TRANSACTIONTYPE = By.id("transactionType");
    private static final By DRP_FCCURRENCY = By.id("fccurrency");
    private static final By TXT_FCREMARK = By.id("rtRemark");

    private void naviateRemittanceRequestScreen(){click(BTN_REMITTANCE, CLICKABLE);}
    private void naviateForexRequestScreen(){click(BTN_FOREX, CLICKABLE);}
    private void clickOnSaveButton(){click(BTN_SAVE, CLICKABLE);}
    private void clickOnClearButton(){click(BTN_CLEAR, CLICKABLE);}
    private void clickOnApproveButton(){click(BTN_APPROVE, CLICKABLE);}
    private void clickOnUpdateButton(){click(BTN_UPDATE, CLICKABLE);}
    private void clickOnDeleteButton(){click(BTN_DELETE, CLICKABLE);}
    private void clickOnDisapproveButton(){click(BTN_DISAPPROVE, CLICKABLE);}
    private void clickOnAuditLogButton(){click(BTN_AUDITLOG, CLICKABLE);}
    private void enterRemIdInSearchBox(String remId){sendKeys(TXT_SEARCHBOX, remId, CLICKABLE, "Rem Search");}
    private void clickOnSearchButton(){click(BTN_SEARCH, CLICKABLE);}
    private void enterValueDate(String date){enterDate(DATE_VALUE_DATE, date, CLICKABLE);}
    private void selectCurrency(String currency){selectDropdownWithRetry(DRP_RMCURRENCY,  currency);}
    private void selectCorrespondent(String correspondent){selectDropdownWithRetry(DRP_CORRESPONDENT, correspondent);}
    private void selectPaymode(String payMode){selectDropdownWithRetry(DRP_PAYMODE, payMode);}
    private void enterFCAmount(String fcAmount){sendKeys(TXT_FCAMOUNT, fcAmount, CLICKABLE, "FC Amount");}
}
