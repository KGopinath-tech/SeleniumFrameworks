package com.cinque.pages.commoninwardremittance;

import com.cinque.testdata.DTO.inwardremittancedata.PaymentDetailsData;
import org.openqa.selenium.By;
import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.*;

public class PaymentComponent {

    private static final By DRP_COUNTRY = By.id("country");
    private static final By DRP_PRODUCT = By.id("product");
    private static final By DRP_CURRENCY = By.id("currency");
    private static final By DRP_INWARD_TYPE = By.id("inwardType");
    private static final By CLD_EXPIRY_DATE = By.xpath("//label[text()='Expiry Date']/preceding-sibling::*//input");
    private static final By DRP_COMMISSION = By.id("commissionPayee");
    private static final By TXT_RCN = By.id("rcn");
    private static final By TXT_FC_AMOUNT = By.xpath("//label[text()=' FC Amount ']/preceding-sibling::*//input");
    private static final By TXT_AGENT_COMMISSION = By.xpath("//input[@name='correspondentCommission']");
    private static final By TXT_RECEIVER_COMMISSION = By.xpath("//input[@name='receiverCommission']");

    private void selectCountry(String country) {selectDropdownWithRetry(DRP_COUNTRY, country);}
    private void selectProduct(String product) {selectDropdownWithRetry(DRP_PRODUCT, product);}
    private void selectCurrency(String currency) {selectDropdownWithRetry(DRP_CURRENCY, currency);}
    private void selectInwardType(String inwardType) {selectDropdownWithRetry(DRP_INWARD_TYPE, inwardType);}
    private void enterExpiryDate(String date){enterDate(CLD_EXPIRY_DATE, date , CLICKABLE);}
    private void selectCommission(String commisionType) {selectDropdownWithRetry(DRP_COMMISSION, commisionType);}
    private void enterRCN(String rcn) {selectDropdownWithRetry(TXT_RCN, rcn);}
    private void enterFCAmount(String amount){sendKeys(TXT_FC_AMOUNT, amount, CLICKABLE, "FC Amount");}
    private void enterAgentCommission(String commission){sendKeys(TXT_AGENT_COMMISSION, commission, CLICKABLE, "AgentCommission");}
    private void enterReceiverCommission(String commission){sendKeys(TXT_RECEIVER_COMMISSION, commission, CLICKABLE, "ReceiverCommission");}

    public void fillPaymentDetails(PaymentDetailsData data){
        selectCountry(data.getCountry());
        selectProduct(data.getProduct());
        selectCurrency(data.getCurrency());
        selectInwardType(data.getInwardtype());
        enterExpiryDate(data.getExpirydate());
        selectCommission(data.getCommissiontype());
        enterRCN(data.getRcnno());
        enterFCAmount(data.getFcamount());
        enterAgentCommission(data.getAgentcommission());
        enterReceiverCommission(data.getReceivercommission());
    }
}
