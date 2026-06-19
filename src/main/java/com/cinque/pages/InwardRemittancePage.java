package com.cinque.pages;

import com.cinque.pages.commoninwardremittance.PaymentComponent;
import com.cinque.pages.commoninwardremittance.ReceiverComponent;
import com.cinque.pages.commoninwardremittance.SenderComponent;
import com.cinque.pages.sideMenuComponent.SidebarMenuComponent;
import com.cinque.testdata.DTO.inwardremittancedata.PaymentDetailsData;
import com.cinque.testdata.DTO.inwardremittancedata.ReceiverDetailsData;
import com.cinque.testdata.DTO.inwardremittancedata.SenderDetailsData;
import org.openqa.selenium.By;

import static com.cinque.enums.WaitType.CLICKABLE;
import static com.cinque.utils.MessageUtils.waitForNgxSpinner;
import static com.cinque.utils.SeleniumUtils.click;

public class InwardRemittancePage {

    private SidebarMenuComponent sidebarMenuComponent = new SidebarMenuComponent();
    public void getInwardRemittanceScreen(){sidebarMenuComponent.getInwardRemittanceMenu();}

    private PaymentComponent  paymentComponent = new PaymentComponent();
    private ReceiverComponent receiverComponent = new ReceiverComponent();
    private SenderComponent senderComponent = new SenderComponent();

    public void fillPaymentDetails(PaymentDetailsData data){paymentComponent.fillPaymentDetails(data);}
    public void fillReceiverDetails(ReceiverDetailsData data){receiverComponent.fillReceiverDetails(data);}
    public void fillSenderDetails(SenderDetailsData data){senderComponent.fillSenderDetails(data);}

    private static final By BTN_SAVE = By.xpath("//button[normalize-space()='Save']");
    private static final By BTN_CANCEL = By.xpath("//button[normalize-space()='Clear']");
    private static final By BTN_APPROVE = By.xpath("//button[normalize-space()='Approve']");
    private static final By BTN_PRINT = By.xpath("//button[normalize-space()='Print']");
    private static final By BTN_UPDATE = By.xpath("//button[normalize-space()='Update']");
    private static final By BTN_DELETE = By.xpath("//button[normalize-space()='Delete']");
    private static final By BTN_MORE_ACTIONS = By.xpath("//button[normalize-space()='More Actions']");
    private static final By BTN_ADD_DOCUMENT = By.xpath("//*[@class='dropdown-menu show']/*[normalize-space()='Add/View Document']");
    private static final By BTN_AUDIT_LOGS = By.xpath("//*[@class='dropdown-menu show']/*[normalize-space()='Audit Logs']");
    private static final By BTN_INITIATE_TRANSACTION = By.xpath("//button[normalize-space()='Initiate Transaction']");

    public void clickOnSave (){
        click(BTN_SAVE, CLICKABLE);
        waitForNgxSpinner();
    }
    public void clickOnCancel (){
        click(BTN_CANCEL, CLICKABLE);
    }
    public void clickOnApprove (){
        click(BTN_APPROVE, CLICKABLE);
    }
    public void clickOnPrint (){
        click(BTN_PRINT, CLICKABLE);
    }
    public void clickOnUpdate (){
        click(BTN_UPDATE, CLICKABLE);
    }
    public void clickOnDelete (){
        click(BTN_DELETE, CLICKABLE);
    }
    public void clickOnMore (){
        click(BTN_MORE_ACTIONS, CLICKABLE);
    }
    public void clickOnAddDocument (){
        click(BTN_ADD_DOCUMENT, CLICKABLE);
    }
    public void clickOnAuditLogs (){
        click(BTN_AUDIT_LOGS, CLICKABLE);
    }
    public void clickOnInitiateTransaction(){
        click(BTN_INITIATE_TRANSACTION, CLICKABLE);
    }
}
