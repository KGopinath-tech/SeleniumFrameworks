package com.cinque.pages;

import com.cinque.pages.commonoutwardremittance.*;
import com.cinque.pages.sideMenuComponent.SidebarMenuComponent;
import com.cinque.testdata.DTO.outwardremittancedata.*;
import org.openqa.selenium.By;
import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.MessageUtils.waitForNgxSpinner;
import static com.cinque.utils.SeleniumUtils.*;

public class OutwardRemittancePage {

    private SidebarMenuComponent sidebarMenuComponent = new SidebarMenuComponent();

    public void getOuwardemittanceScreen(){sidebarMenuComponent.getOutwardRemittanceMenu();}

    private AmountAndRates amountAndRates = new AmountAndRates();
    private ComplianceDetails complianceDetails = new ComplianceDetails();
    private ProductSection productSection = new ProductSection();
    private ReceiverInformation  receiverInformation = new ReceiverInformation();
    private RemitterInformation  remitterInformation = new RemitterInformation();

    public void fillProductSectionDetails(ProductSectionData data){
        productSection.fillProductSectionDetails(data);
    }
    public void fillComplianceDetails(ComplianceInformationData data){
        complianceDetails.fillComplianceDetails(data);
    }
    public void fillReceiverInformation(ReceiverInformationData data){
        receiverInformation.fillReceiverDetails(data);
    }
    public void fillRemitterInformation(RemitterInformationData data){
        remitterInformation.fillRemitterInformation(data);
    }
    public void fillAmountAndRates(AmountAndRatesData data){
        amountAndRates.fillOutwardAmountDetails(data);
    }

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
