package com.cinque.pages;

import com.cinque.pages.commonregistration.*;
import com.cinque.testdata.DTO.*;
import org.openqa.selenium.By;

import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.*;

public class CustomerRegistrationPage {


    private PersonalDetailsComponents personalDetails = new PersonalDetailsComponents();
    private AddressComponents address = new AddressComponents();
    private EmploymentComponents employmentDetails = new EmploymentComponents();
    private FinancialDetailsComponents financialDetails = new FinancialDetailsComponents();
    private OtherDetailsComponents otherDetails = new OtherDetailsComponents();
    private PromotionComponents promotionDetails = new PromotionComponents();
    private IdentityDetailsComponents identityDetails = new IdentityDetailsComponents();

    public void fillIndividualPersonalDetails(PersonalDetailsData data){
        personalDetails.fillIndividualPersonalDetails(data);
    }
    public void fillAddressDetails(AddressDetailsData data){address.fillAddress(data);}
    public void fillEmploymentDetails(String employerName, String occupation){
        employmentDetails.fillEmploymentDetails(employerName,occupation);}
    public void fillFinancialDetails(FinancialDetailsData data){financialDetails.fillIndividualFinancialDetails(data);}
    public void fillIndividualOtherDetails(OtherDetailsData data){otherDetails.fillIndividualOtherDetails(data);}
    public void fillPromoDetails(String promoCode, String promoExpireDate){promotionDetails.fillPromoDetails(promoCode,promoExpireDate);}
    public void fillIdentityDetails(IdentityDetailsData data){identityDetails.fillIdentityDetials(data);}



    private static final By MENU_CUSTOMER_REGISTRATION = By.xpath("//span[text()='Customer Registration']");
    private static final By BTN_NEW = By.xpath("//button[text()=' New ']");
    private static final By BTN_SAVE = By.xpath("//button[normalize-space()='Save']");
    private static final By BTN_APPROVE = By.xpath("//button[normalize-space()='Approve']");
    private static final By BTN_PRINT = By.xpath("//button[normalize-space()='Print']");
    private static final By BTN_DEACTIVATE = By.xpath("//button[normalize-space()='Deactivate']");
    private static final By KEBAB_MENU = By.id("moreOptionsDropdown");
    private static final By BTN_EXPAND = By.xpath("//a[normalize-space()='Expand All']");
    private static final By BTN_CONFIRMATION_SAVE = By.xpath("//button[@class='btn btn-filled fs-medium']");
    private static final By BTN_CONFIRMATION_CANCEL = By.xpath("//button[@class='btn btn-outline fs-medium']");


    public void getCustomerRegistrationMenu(){
        click(MENU_CUSTOMER_REGISTRATION, CLICKABLE, "Register Button");
    }
    public void clickNewButton(){
        click(BTN_NEW, CLICKABLE, "New Button");
    }
    public void clickSaveButton(){
        click(BTN_SAVE, CLICKABLE, "Save Button");
    }
    public void clickApproveButton(){
        click(BTN_APPROVE, CLICKABLE, "Approve Button");
    }
    public void clickPrintButton(){
        click(BTN_PRINT, CLICKABLE, "Print Button");
    }
    public void clickDeactivateButton(){
        click(BTN_DEACTIVATE, CLICKABLE, "Deactivate Button");
    }
    public void clickKebabMenu(){
        click(KEBAB_MENU,VISIBLE, "Kebab Menu");
    }
    public void clickExpandButton(){
        click(BTN_EXPAND, CLICKABLE, "Expand");
    }
    public void clickConfirmationSaveButton(){click(BTN_CONFIRMATION_SAVE, CLICKABLE);}
    public void clickConfirmationCancelButton(){click(BTN_CONFIRMATION_CANCEL, CLICKABLE);}
}

