package com.cinque.pages.commonfcpurchasesale;

import org.openqa.selenium.By;

public class AmountAndRates {

    private static final By DRP_EXCHANGE_TYPE = By.xpath("//div[normalize-space()='Type']");
    private static final By DRP_CURRENCY = By.xpath("//div[normalize-space()='Currency']");
    private static final By TXT_FC_AMOUNT = By.id("FCAmount");
    private static final By TXT_RATE = By.id("Rate");
    private static final By TXT_LC_AMOUNT = By.id("LCAmount");
    private static final By BTN_ADD = By.xpath("//button[@class='btn btn-sm rounded-circle p-0 add-icon-btn btn-animation']");
    private static final By BTN_ERASER = By.xpath("//button[contains(@class,'erase-icon-btn btn-animation')]");
}
