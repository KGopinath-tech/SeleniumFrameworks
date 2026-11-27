package com.cinque.pages.commonfcpurchasesale;

import org.openqa.selenium.By;

public class OtherDetails {

    private static final By DRP_PURPOSE = By.id("PurposeOfExchange");
    private static final By DRP_SOURCE_OF_INCOME = By.id("SourceOfIncome");
    private static final By TXT_VESSEL_NAME = By.id("VesselName");
    private static final By TXT_UIR_NO = By.id("UIRRef");
    private static final By TXT_CDF_REFERENCE_NO = By.id("CDFREFNO");
    private static final By TXT_REMARKS = By.id("Remarks");
    private static final By DGE_SUSPICIOUS = By.xpath("//label[normalize-space()='Suspicious']/preceding-sibling::*[@id='flexCheckDefault']");
    private static final By TXT_SUSPICIOUS_REMARKS = By.id("SuspiciousRemarks");
    private static final By DGE_SAR = By.xpath("//label[normalize-space()='SAR']/preceding-sibling::*[@id='flexCheckDefault']");
    private static final By TXT_SAR_REMARKS = By.id("SARRemarks");
    private static final By DGE_ISTR = By.xpath("//label[normalize-space()='ISTR']/preceding-sibling::*[@id='flexCheckDefault']");
    private static final By TXT_ISTR_REMARKS = By.id("ISTRRemarks");

}
