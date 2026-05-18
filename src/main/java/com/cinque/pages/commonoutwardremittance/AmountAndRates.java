package com.cinque.pages.commonoutwardremittance;

import static com.cinque.enums.WaitType.*;

import com.cinque.testdata.DTO.outwardremittancedata.AmountAndRatesData;
import org.openqa.selenium.By;

import static com.cinque.utils.MessageUtils.waitForNgxSpinner;
import static com.cinque.utils.SeleniumUtils.*;

public class AmountAndRates {

    private static final By TXT_FC_AMOUNT = By.id("fcAmount");
    private static final By TXT_LC_AMOUNT = By.id("lcAmount");
    private static final By DRP_PAY_MODE = By.xpath("//div/preceding::*[@formcontrolname='payMode']");
    private static final By TXT_COMMISSION = By.id("commission");
    private static final By TXT_OTHER_CHARGE = By.id("otherCharges");
    private static final By TXT_DISCOUNT = By.id("discount");

    private void enterFCAmount(String FCAmount) {
        sendKeys(TXT_FC_AMOUNT, FCAmount, CLICKABLE, "FC Amount");
    }
    private void enterLCAmount(String LCAmount) {
        sendKeys(TXT_LC_AMOUNT, LCAmount, CLICKABLE, "LC Amount");
    }
    private void selectPayMode(String payMode) {
        selectDropdown(DRP_PAY_MODE, payMode);
    }
    private void enterCommission(String commission) {
        sendKeys(TXT_COMMISSION, commission, CLICKABLE, "Commission");
    }
    private void enterOtherCharges(String otherCharges) {
        sendKeys(TXT_OTHER_CHARGE, otherCharges, CLICKABLE, "OtherCharges");
    }
    private void enterDiscount(String discount) {
        sendKeys(TXT_DISCOUNT, discount, CLICKABLE, "Discount");
    }

    public void fillOutwardAmountDetails(AmountAndRatesData data){
        enterFCAmount(data.getFcamount());
        waitForNgxSpinner();
        if(isNotBlank(data.getLcamount())){
            enterLCAmount(data.getLcamount());
        }
        if(isNotBlank(data.getCommission())){
            enterCommission(data.getCommission());
        }
        if(isNotBlank(data.getOthercharges())) {
            enterOtherCharges(data.getOthercharges());
        }
        if(isNotBlank(data.getDiscount())) {
            enterDiscount(data.getDiscount());
        }
        waitforSleep(250);
        selectPayMode(data.getPaymode());
    }
}
