package com.cinque.pages.commonoutwardremittance;

import static com.cinque.enums.WaitType.*;

import com.cinque.testdata.DTO.outwardremittancedata.ComplianceInformationData;
import org.openqa.selenium.By;
import static com.cinque.utils.SeleniumUtils.*;

public class ComplianceDetails {

    private static final By BTN_SUSPICIOUS = By.xpath("//label[contains(normalize-space(),'Suspicious')]/parent::*//*[@id='flexCheckDefault']");
    private static final By TXT_SUSPICIOUS = By.id("suspiciousRemarks");
    private static final By BTN_ISTR = By.xpath("//label[contains(normalize-space(),'ISTR')]/parent::*//*[@id='flexCheckDefault']");
    private static final By TXT_ISTR = By.xpath("istrRemarks");
    private static final By BTN_SAR = By.xpath("//label[contains(normalize-space(),'SAR')]/parent::*//*[@id='flexCheckDefault']");
    private static final By TXT_SAR = By.id("sarRemarks");

    private void enableSuspiciousbutton(){
        setToggle(BTN_SUSPICIOUS, false);
    }
    private void enterSuspiciousRemarks(String remarks){
        sendKeys(TXT_SUSPICIOUS, remarks, CLICKABLE, "Suspicious Remarks");
    }
    private void enableISTRbutton(){
        setToggle(BTN_ISTR, false);
    }
    private void enterISTRRemarks(String remarks){
        sendKeys(TXT_ISTR, remarks, CLICKABLE, "ISTR Remarks");
    }
    private void enableSARbutton(){
        setToggle(BTN_SAR, false);
    }
    private void enterSARRemarks(String remarks){
        sendKeys(TXT_SAR, remarks, CLICKABLE, "SAR Remarks");
    }

    public void fillComplianceDetails(ComplianceInformationData data){
        enableSuspiciousbutton();
        if(isNotBlank(data.getSuspiciousremarks())) {
            enterSuspiciousRemarks(data.getSuspiciousremarks());
        }
        enableISTRbutton();
        if(isNotBlank(data.getISTRremarks())) {
            enterISTRRemarks(data.getISTRremarks());
        }
        enableSARbutton();
        if(isNotBlank(data.getSARremarks())) {
            enterSARRemarks(data.getSARremarks());
        }
    }
}
