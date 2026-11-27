package com.cinque.pages.commonfcpurchasesale;

import org.openqa.selenium.By;

public class PaymentDetails {

    private static final By DRP_MODE_OF_PAY = By.id("ModeOfPay");
    private static final By TXT_COMMISSION = By.id("Commission");
    private static final By TXT_DISCOUNT = By.id("Discount");
    private static final By TXT_VAT_PERCENTAGE = By.xpath("//label[normalize-space()='VAT Rate(%)']/preceding-sibling::*");
    private static final By TXT_VAT_AMOUNT = By.xpath("//label[normalize-space()='VAT Amount']/preceding-sibling::*");
    private static final By TXT_NET_AMOUNT = By.xpath("//label[normalize-space()='Net Amount']/preceding-sibling::*");
    private static final By TXT_CASH_AMOUNT_PAID = By.xpath("//label[normalize-space()='Cash Amount Paid']/preceding-sibling::*");
    private static final By TXT_CASH_AMOUNT_RECEIVED = By.xpath("//label[normalize-space()='Amount Received']/preceding-sibling::*");

    //Purchase - Cheque Paymode
    private static final By DRP_CHEQUE_BANK = By.id("PBank");
    private static final By DRP_CHEQUE_NO = By.id("PChequeNo");
    private static final By TXT_CHEQUE_BOOK = By.id("PChequeBookNo");
    private static final By CLD_CHEQUE_DATE = By.xpath("//label[normalize-space()='Cheque Date']/preceding-sibling::*//input");
    private static final By TXT_CHEQUE_AMOUNT = By.xpath("//label[normalize-space()='Cheque Amount']/preceding-sibling::*");

    //Purchase/Sale - Bank Transfer/Credit
    private static final By DRP_BANK = By.id("AccountNumber");
    private static final By TXT_BANK_AMOUNT = By.id("Amount");

    //Sale - Cheque Paymode
    private static final By TXT_CHEQUE_BANK1 = By.id("RBank1");
    private static final By TXT_CHEQUE_NO1 = By.id("RChequeNo1");
    private static final By CLD_RECEIVE_CHEQUE_DATE1 = By.xpath("//label[normalize-space()='Receive Cheque Due Date1']/preceding-sibling::*//input");
    private static final By TXT_CHEQUE_RECEIVE_AMOUNT1 = By.id("RAmount1");
    private static final By TXT_CHEQUE_BANK2 = By.id("RBank2");
    private static final By TXT_CHEQUE_NO2 = By.id("RChequeNo2");
    private static final By CLD_RECEIVE_CHEQUE_DATE2 = By.xpath("//label[normalize-space()='Receive Cheque Due Date2']/preceding-sibling::*//input");
    private static final By TXT_CHEQUE_RECEIVE_AMOUNT2 = By.id("RAmount2");
    private static final By TXT_CHEQUE_BANK3 = By.id("RBank3");
    private static final By TXT_CHEQUE_NO3 = By.id("RChequeNo3");
    private static final By CLD_RECEIVE_CHEQUE_DATE3 = By.xpath("//label[normalize-space()='Receive Cheque Due Date3']/preceding-sibling::*//input");
    private static final By TXT_CHEQUE_RECEIVE_AMOUNT3 = By.id("RAmount3");

}
