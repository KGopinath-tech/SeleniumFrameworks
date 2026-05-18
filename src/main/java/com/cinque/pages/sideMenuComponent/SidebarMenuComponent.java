package com.cinque.pages.sideMenuComponent;

import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.*;
import org.openqa.selenium.By;

public class SidebarMenuComponent {

    //Masters
    private static final By MENU_SIDEBAR = By.xpath("//i[contains(@class,'fa-cogs')]/parent::div");
    private static final By MENU_GENERAL = By.xpath("//div//span[contains(text(),'General')]");
    private static final By MENU_CUSTOMER_REGISTRATION = By
            .xpath("//span[@class='grand-child-label fs-medium'][normalize-space()='Customer Registration']");
    private static final By MENU_EMPLOYEE = By.xpath("//span[text()='Employee']");

    public void getSideMenu() {
        click(MENU_SIDEBAR, CLICKABLE, "Side Menu");
    }
    public void getGeneralMenu(){
        click(MENU_GENERAL, CLICKABLE,"General Menu");
    }
    public void getEmployee(){
        click(MENU_EMPLOYEE, CLICKABLE,"Employee Menu");
    }
    public void getCustomerRegistration(){click(MENU_CUSTOMER_REGISTRATION, CLICKABLE,"Customer Registration Menu");}

    //Transactions
    private static final By TRANSACTIONS_MENU = By.xpath("//div/i[contains(@class,'fa-credit-card')]");
    private static final By GEN_SPECIAL_RATE_MENU = By.xpath("//*[contains(text(),'Special Rate')]");

    private static final By TXN_OUTWARD_MENU = By.xpath("//div//span[contains(text(),'Outward')]");
    private static final By OUT_OUTWARD_REMITTANCE_MENU =
            By.xpath("//span[@class='grand-child-label fs-medium'][normalize-space()='Outward Remittance']");
    private static final By OUT_REFUND_MENU =
            By.xpath("//span[@class='grand-child-label fs-medium'][normalize-space()='Refund / Stop Payment']");
    private static final By OUT_AMENDMENT_MENU =
            By.xpath("//span[@class='grand-child-label fs-medium'][normalize-space()='Amendment']");

    private static final By TXN_INWARD_MENU = By.xpath("//div//span[contains(text(),'Inward')]");
    private static final By IN_INWARD_REMITTANCE_MENU =
            By.xpath("//span[@class='grand-child-label fs-medium'][normalize-space()='Inward Remittance']");
    private static final By IN_INWARD_PAYOUT_MENU =
            By.xpath("//span[@class='grand-child-label fs-medium'][normalize-space()='Payout']");

    private static final By TXN_FOREX_MENU = By.xpath("//div//span[contains(text(),'Forex')]");
    private static final By FOREX_PURCHASE_SALE_MENU = By.xpath("//*[normalize-space()='Purchase/Sale']");
    private static final By FOREX_PURCHASE_MENU = By.xpath("//*[normalize-space()='Purchase']");
    private static final By FOREX_SALE_MENU = By.xpath("//*[normalize-space()='Sale']");
    private static final By FOREX_WHOLESALE_MENU =  By.xpath("//*[normalize-space()='Wholesale']");
    private static final By FOREX_CANCENCELLATION_MENU = By.xpath("//*[normalize-space()='Cancellation']");
    private static final By FOREX_DELIVERY_INTERBRANCH_MENU = By.xpath("//*[normalize-space()='Delivery - Inter Branch']");
    private static final By FOREX_RECEIPT_INTERBRANCH_MENU = By.xpath("//*[normalize-space()='Receipt - Inter Branch']");

    //Cashiers
    private static final By CASHIER_MENU = By.xpath("//div/i[contains(@class,'fa-cash-register')]");
    private static final By CHR_CASHIER_RECEIPT_MENU= By.xpath("//*[normalize-space()='Cashier Receipt']");
    private static final By CHR_CASHIER_PAYMENT_MENU = By.xpath("//*[normalize-space()='Cashier Payment']");
    private static final By CHR_TILL_TRANSFER_MENU = By.xpath("//*[normalize-space()='Till Transfer']");
    private static final By CHR_TILL_RECEIPT_MENU = By.xpath("//*[normalize-space()='Till Receipt']");

    //Customer Service
    private static final By CUSTOMER_SERVICE_MENU = By.xpath("//div/i[contains(@class,'fa-headset')]");
    private static final By FX_HIGHER_APPROVAL_MENU = By.xpath("//*[normalize-space()='Forex Authorization']");
    private static final By FX_SPECIAL_RATE_APPROVAL = By.xpath("//*[normalize-space()='Special Rate Approval']");

    private void getTransactionMenu(){
        click(TRANSACTIONS_MENU, CLICKABLE);
    }
    private void getOutwardMenu(){
        click(TXN_OUTWARD_MENU,  CLICKABLE);
    }

    public void getSpecialRateScreenMenu(){
        getTransactionMenu();
        waitforSleep(350);
        getGeneralMenu();
        waitforSleep(350);
        click(GEN_SPECIAL_RATE_MENU,  CLICKABLE);
    }
    public void getOutwardRemittanceMenu(){
        getTransactionMenu();
        waitforSleep(350);
        getOutwardMenu();
        waitforSleep(450);
        click(OUT_OUTWARD_REMITTANCE_MENU,  CLICKABLE);
    }
    public void getRefundStopPaymentMenu(){
        getTransactionMenu();
        waitforSleep(350);
        getOutwardMenu();
        waitforSleep(450);
        click(OUT_REFUND_MENU,  CLICKABLE);
    }
    public void getAmendmentMenu(){
        getTransactionMenu();
        waitforSleep(350);
        getOutwardMenu();
        waitforSleep(450);
        click(OUT_AMENDMENT_MENU,  CLICKABLE);
    }

}
