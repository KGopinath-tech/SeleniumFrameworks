package com.cinque.pages.commoninwardremittance;

import com.cinque.testdata.DTO.inwardremittancedata.ReceiverDetailsData;
import org.openqa.selenium.By;

import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.MessageUtils.waitForNgxSpinner;
import static com.cinque.utils.SeleniumUtils.*;

public class ReceiverComponent {

    private static final By TXT_SEARCHBOX = By.xpath("//input[contains(@class,'modern-search-input')]");
    private static final By BTN_SEARCH = By.xpath("//button[@class='modern-search-button']");
    private static final By BTN_ADVANCED_SEARCH = By.xpath("//*[contains(@class,'slider-icon')]/parent::button");
    private static final By BTN_VIEW_IDS = By.xpath("//*[contains(@class,'fa-eye')]/parent::button");
    private static final By DRP_RELATION = By.id("receiverRelation");
    private static final By TXT_BANK = By.id("receiverBank");
    private static final By TXT_BRANCH = By.id("receiverBranch");
    private static final By TXT_ACCOUNT_NO = By.id("receiverAccountNo");
    private static final By DRP_ECONOMIC_ACTIVITY = By.id("receiverEconomicActivity");
    private static final By DRP_PURPOSE_OF_TRANSFER = By.id("paymentPurposeOfTransfer");

    private void enterRemIdInSearchBox(String remId){sendKeys(TXT_SEARCHBOX, remId, CLICKABLE, "RemId");}
    private void clickOnSearchButton(){click(BTN_SEARCH, CLICKABLE);}
    private void selectRelation(String relation){selectDropdownWithRetry(DRP_RELATION, relation);}
    private void enterBank(String bank){sendKeys(TXT_BANK, bank, CLICKABLE, "Bank");}
    private void enterBranch(String branch){sendKeys(TXT_BRANCH, branch, CLICKABLE, "Branch");}
    private void enterAccountNo(String accountNo){sendKeys(TXT_ACCOUNT_NO, accountNo, CLICKABLE, "AccountNo");}
    private void selectEconomicActivity(String economicActivity){selectDropdownWithRetry(DRP_ECONOMIC_ACTIVITY, economicActivity);}
    private void selectPurpose(String purpose){selectDropdownWithRetry(DRP_PURPOSE_OF_TRANSFER, purpose);}

    public void fillReceiverDetails(ReceiverDetailsData data){
        enterRemIdInSearchBox(data.getRemid());
        clickOnSearchButton();
        waitForNgxSpinner();
        selectRelation(data.getRelation());
        if(isNotBlank(data.getBank())){ enterBank(data.getBank());}
        if(isNotBlank(data.getBranch())){ enterBranch(data.getBranch());}
        if(isNotBlank(data.getAccountno())){ enterAccountNo(data.getAccountno());}
        selectEconomicActivity(data.getEconomicactivity());
        selectPurpose(data.getPurposeoftransfer());
    }
}
