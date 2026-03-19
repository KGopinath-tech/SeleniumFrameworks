package com.cinque.pages.commonregistration;

import com.cinque.testdata.DTO.OtherDetailsData;
import org.openqa.selenium.By;
import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.*;

public class OtherDetailsComponents {
    private static final By TXT_REMARKS = By.id("Remarks");
    private static final By TXT_LOCATION = By.id("Location");
    private static final By DGE_RELATED_PARTY = By.xpath("//label[normalize-space()='Related Party']/preceding-sibling::*[@id='flexCheckDefault']");
    private static final By GGE_WATCHLIST = By.xpath("//label[normalize-space()='Watchlist']/preceding-sibling::*[@id='flexCheckDefault']");
    private static final By TXT_WATCHLIST_REMARKS = By.id("WatchlistRemarks");
    private static final By DGE_HIGHRISK = By.xpath("//label[normalize-space()='High Risk']/preceding-sibling::*[@id='flexCheckDefault']");
    private static final By TXT_HIGHRISK_REMARKS = By.id("HighRiskRemarks");
    private static final By TXT_CB_LICENCE = By.id("CBLicenseNo");
    private static final By DGE_PEP = By.xpath("//label[normalize-space()='Is Pep']/preceding-sibling::*[@id='flexCheckDefault']");
    private static final By TXT_CAD_IBAN = By.id("CADIban");
    private static final By DRP_REFERRED_BY = By.id("ReferredBy");

    private void enterRemarks(String remarks) {
        sendKeys(TXT_REMARKS, remarks,CLICKABLE, "Customer Remarks");
    }
    private void enterLocation(String location) {
        sendKeys(TXT_LOCATION, location,CLICKABLE, "Location");
    }
    private void clickRelatedParty() {
        setToggle(DGE_RELATED_PARTY, false );
    }
    private void clickWatchlist() {
        setToggle(GGE_WATCHLIST, false );
    }
    private void enterWatchlistRemarks(String remarks) {
        sendKeys(TXT_WATCHLIST_REMARKS,  remarks,CLICKABLE, "Watchlist Remarks");
    }
    private void clickHighRisk() {
        setToggle(DGE_HIGHRISK, false );
    }
    private void enterHighRiskRemarks(String remarks) {
        sendKeys(TXT_HIGHRISK_REMARKS, remarks,CLICKABLE, "High Risk Remarks");
    }
    private void enterCBLicenseNo(String CBLicenseNo) {
        sendKeys(TXT_CB_LICENCE,  CBLicenseNo,CLICKABLE, "CBLical No");
    }
    private void clickPep() {
        setToggle(DGE_PEP, false );
    }
    private void enterCadIban(String CADIban) {
        sendKeys(TXT_CAD_IBAN, CADIban,CLICKABLE, "Cad Iban");
    }
    private void selectReferredBy(String referredBy) {
        selectDropdown(DRP_REFERRED_BY, referredBy);
    }
    public void fillOtherDetails(OtherDetailsData data){
        enterRemarks(data.getRemarks());
        enterLocation(data.getLocation());
        clickRelatedParty();
        clickWatchlist();
        enterWatchlistRemarks(data.getWatchlistRemarks());
        clickHighRisk();
        enterHighRiskRemarks(data.getHighRiskRemarks());
        enterCBLicenseNo(data.getCADIban());
        clickPep();
        //enterCadIban(data.getCADIban());
        selectReferredBy(data.getReferredBy());
    }

}
