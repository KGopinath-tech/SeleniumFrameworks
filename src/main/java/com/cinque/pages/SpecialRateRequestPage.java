package com.cinque.pages;

import com.cinque.pages.sideMenuComponent.SidebarMenuComponent;
import com.cinque.testdata.DTO.specialraterequest.SpecialRateRequestData;
import org.openqa.selenium.By;

import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.MessageUtils.waitForNgxSpinner;
import static com.cinque.utils.SeleniumUtils.*;

public class SpecialRateRequestPage {

    private SidebarMenuComponent sidebarMenuComponent = new SidebarMenuComponent();

    public void getSpecialRateRequestScreen(){sidebarMenuComponent.getSpecialRateScreenMenu();}

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
    private static final By BTN_SEARCH_BUTTON = By.xpath("//button[@class='modern-search-button']");
    private static final By BTN_ADVANCED_SEARCH = By.xpath("//button[@class='advanced-btn ms-2']");
    private static final By DATE_VALUE_DATE = By.id("valueDate");
    private static final By DRP_RMCURRENCY = By.cssSelector("p-dropdown[inputid='rmcurrency']");
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
    private static final By DRP_FCTYPE = By.id("fcTypes");
    private static final By DRP_TRANSACTIONTYPE = By.id("pn_id_10");
    private static final By DRP_FCCURRENCY = By.id("pn_id_12");
    private static final By TXT_FCREMARK = By.id("rtRemark");

    private static final By BTN_SEARCH_TRANSACTION = By.xpath("//button[normalize-space()='Search Transaction']");
    private static final By TXT_REFERENCE_NO = By.id("refno");
    private static final By TXT_FROM_DATE = By.xpath("//label[text()='From Date']/preceding-sibling::*//input");
    private static final By TXT_TO_DATE = By.xpath("//label[text()='To Date']/preceding-sibling::*//input");
    private static final By DRP_STATUS = By.id("status");
    private static final By DRP_TRANSACTION_TYPE = By.id("searchtxntype");
    private static final By BTN_SEARCH = By.xpath("//button[normalize-space()='Search']");

    private void naviateRemittanceRequestScreen(){click(BTN_REMITTANCE, CLICKABLE);}
    private void naviateForexRequestScreen(){click(BTN_FOREX, CLICKABLE);}
    private void enterRemIdInSearchBox(String remId){sendKeys(TXT_SEARCHBOX, remId, CLICKABLE, "Rem Search");}
    private void clickOnSearchButton(){click(BTN_SEARCH_BUTTON, CLICKABLE);}
    private void enterValueDate(String date){enterDate(DATE_VALUE_DATE, date, CLICKABLE);}
    private void selectRMCurrency(String currency){selectDropdownWithRetry(DRP_RMCURRENCY,  currency);}
    private void selectCorrespondent(String correspondent){selectDropdownWithRetry(DRP_CORRESPONDENT, correspondent);}
    private void selectPaymode(String payMode){selectDropdownWithRetry(DRP_PAYMODE, payMode);}
    private void enterFCAmount(String fcAmount){sendKeys(TXT_FCAMOUNT, fcAmount, CLICKABLE, "FC Amount");}
    private void enterLCAmount(String lcAmount){sendKeys(TXT_LCAMOUNT, lcAmount, CLICKABLE, "LC Amount");}
    private void enterRMRemark(String remark){sendKeys(TXT_RMREMARK,  remark, CLICKABLE, "RM Remark");}
    private void selectFCType(String type){selectDropdownWithRetry(DRP_FCTYPE, type);}
    private void selectFCTransactionType(String type){selectDropdownWithRetry(DRP_TRANSACTIONTYPE, type);}
    private void selectCurrency(String currency){selectDropdownWithRetry(DRP_FCCURRENCY, currency);}
    private void enterFCRemark(String remark){sendKeys(TXT_FCREMARK, remark,CLICKABLE, "FC Remark");}
    private void clickConfirmationLeave(){click(BTN_CONFIRMATION_LEAVEPAGE, CLICKABLE);}

    private void clickSearchTransaction(){click(BTN_SEARCH_TRANSACTION, CLICKABLE);}
    private void enterReferenceNo(String refNo){sendKeys(TXT_REFERENCE_NO, refNo, CLICKABLE, "Ref No");}
    private void enterFromDate(String fromDate){enterDate(TXT_FROM_DATE, fromDate, CLICKABLE);}
    private void enterToDate(String toDate){enterDate(TXT_TO_DATE, toDate, CLICKABLE);}
    private void selectStatus(String status){selectDropdownWithRetry(DRP_STATUS, status);}
    private void selectTransactionType(String type){selectDropdownWithRetry(DRP_TRANSACTION_TYPE, type);}
    private void clickSearchToGetSpecialRateEntries(){click(BTN_SEARCH,  CLICKABLE);}

    public void clickOnSaveButton(){
        click(BTN_SAVE, CLICKABLE);
        waitForNgxSpinner();
    }
    public void clickOnClearButton(){click(BTN_CLEAR, CLICKABLE);}
    public void clickOnApproveButton(){click(BTN_APPROVE, CLICKABLE);}
    public void clickOnUpdateButton(){click(BTN_UPDATE, CLICKABLE);}
    public void clickOnDeleteButton(){click(BTN_DELETE, CLICKABLE);}
    public void clickOnDisapproveButton(){click(BTN_DISAPPROVE, CLICKABLE);}
    public void clickOnAuditLogButton(){click(BTN_AUDITLOG, CLICKABLE);}
    public void getApprovalNo(){getCurrentAreaValue(TXT_APPROVALNO);}
    public void getSpecialRate(){getCurrentAreaValue(TXT_SPECIAL_RATE);}

    public void searchTransaction(SpecialRateRequestData data){
        clickSearchTransaction();
        waitForSleep(250);
        if(isNotBlank(data.getSearchreferenceno())){
            enterReferenceNo(data.getSearchreferenceno());
        }
        if(isNotBlank(data.getSearchfromdate())){
            enterFromDate(data.getSearchfromdate());
        }
        if(isNotBlank(data.getSearchtodate())){
            enterToDate(data.getSearchtodate());
        }
        if(isNotBlank(data.getSearchstatus())){
            selectStatus(data.getSearchstatus());
        }
        if(isNotBlank(data.getSearchtransactiontype())){
            selectTransactionType(data.getSearchtransactiontype());
        }
        clickSearchToGetSpecialRateEntries();
    }


    public void initiateRMSpecialRateRequest(SpecialRateRequestData data) {
        naviateRemittanceRequestScreen();
        waitForSleep(200);
//        if(isDisplayed(BTN_CONFIRMATION_LEAVEPAGE)){
//            clickConfirmationLeave();
//        }
        enterRemIdInSearchBox(data.getRemid());
        waitForSleep(250);
        clickOnSearchButton();
        waitForNgxSpinner();
        if(isNotBlank(data.getValuedate())){
            enterValueDate(data.getValuedate());
        }
        selectRMCurrency(data.getRmcurrency());
        selectCorrespondent(data.getCorrespondent());
        selectPaymode(data.getRmpaymode());
        if(isNotBlank(data.getRmfcamount())) {
            enterFCAmount(data.getRmfcamount());
        }
        if(isNotBlank(data.getRmlcamount())) {
            enterLCAmount(data.getRmlcamount());
        }
        if(isNotBlank(data.getRmremark())){
            enterRMRemark(data.getRmremark());
        }
    }
    public void initiateFCSpecialRateRequest(SpecialRateRequestData data) {
        naviateForexRequestScreen();
        waitForSleep(200);
        if(isDisplayed(BTN_CONFIRMATION_LEAVEPAGE)){
            clickConfirmationLeave();
        }
        selectFCType(data.getFctype());
        selectFCTransactionType(data.getFctransactiontype());
        selectCurrency(data.getFccurrency());
        if(isNotBlank(data.getFcamount())){
            enterFCAmount(data.getFcamount());
        }
        if(isNotBlank(data.getLcamount())){
            enterLCAmount(data.getLcamount());
        }
        if(isNotBlank(data.getValuedate())){
            enterValueDate(data.getValuedate());
        }
        if(isNotBlank(data.getFcremark())){
            enterFCRemark(data.getFcremark());
        }
    }
}
