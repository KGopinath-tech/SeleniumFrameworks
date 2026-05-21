package com.cinque.pages.commonoutwardremittance;

import static com.cinque.enums.WaitType.*;

import com.cinque.testdata.DTO.outwardremittancedata.RemitterInformationData;
import org.openqa.selenium.By;

import static com.cinque.utils.MessageUtils.waitForNgxSpinner;
import static com.cinque.utils.SeleniumUtils.*;

public class RemitterInformation {

    private static final By TXT_REM_SEARCH = By.xpath("//input[@placeholder='Search by UID']");
    private static final By BTN_SEARCH = By.xpath("//button[@class='modern-search-button']");
    private static final By BTN_POPUP_CLOSE = By.xpath("//button[contains(@class,'p-element p-ripple')]");
    private static final By BTN_ADVANCED_SEARCH = By.xpath("//button/*[contains(@class,'fa-solid fa-sliders slider-icon')]");
    private static final By BTN_REPRESENTATIVE = By.xpath("//div[normalize-space()='Select Representative']");
    private static final By DRP_PURPOSE = By.id("purposeOfTransfer");
    private static final By DRP_SOURCE = By.id("sourceOfIncome");
    private static final By BTN_THIRD_PARTY = By.xpath("//label[contains(normalize-space(),'Is ThirdParty')]/parent::*//*[@id='flexCheckDefault']");


    private void enterRemSearch(String search) {
        sendKeys(TXT_REM_SEARCH, search, CLICKABLE, "Rem Search");
    }
    private void clickSearchButton() {
        click(BTN_SEARCH, CLICKABLE);
    }
    private void clickonCloseButton() { click(BTN_POPUP_CLOSE, CLICKABLE);}
    private void selectRepresentative(String repName){
        By representativeLocator = By.xpath("//td[normalize-space()='" + repName + "']");
        click(representativeLocator, CLICKABLE, "Representative");
    }
    private void clickRepresentativeButton(){
        click(BTN_REPRESENTATIVE, CLICKABLE);
    }
    private void selectPurposeOfTransfer(String purpose){
        selectDropdownWithRetry(DRP_PURPOSE, purpose);
    }
    private void selectSourceOfIncome(String source){
        selectDropdownWithRetry(DRP_SOURCE , source);
    }
    private void selectThirdParty(){
        setToggle(BTN_THIRD_PARTY, false);
    }

    public void fillRemitterInformation(RemitterInformationData data){
        enterRemSearch(data.getRemitterid());
        waitForSleep(350);
        clickSearchButton();
        waitForSleep(350);
        waitForNgxSpinner();
        if(isDisplayed(BTN_POPUP_CLOSE)){
            clickonCloseButton();
        }
        if(isNotBlank(data.getRepresentativename())){
            clickRepresentativeButton();
        }
        if(isNotBlank(data.getRepresentativename())){
            selectRepresentative(data.getRepresentativename());
        }
        selectPurposeOfTransfer(data.getPurposeoftransfer());
        selectSourceOfIncome(data.getSourceofincome());
        selectThirdParty();
    }
}
