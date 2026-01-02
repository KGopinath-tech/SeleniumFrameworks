package com.cinque.pages;

import org.openqa.selenium.By;

import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.*;

public class CustomerRegistrationPage {

    private static final By MENU_CUSTOMER_REGISTRATION = By.xpath("//span[text()='Customer Registration']");
    private static final By BTN_NEW = By.xpath("//button[text()=' New ']");
    private static final By BTN_SAVE = By.xpath("//button[normalize-space()='Save']");
    private static final By BTN_APPROVE = By.xpath("//button[normalize-space()='Approve']");
    private static final By BTN_PRINT = By.xpath("//button[normalize-space()='Print']");
    private static final By BTN_DEACTIVATE = By.xpath("//button[normalize-space()='Deactivate']");
    private static final By KEBAB_MENU = By.id("moreOptionsDropdown");
    private static final By BTN_EXPAND = By.xpath("//i[@class='fa-solid fa-angles-up']");
    private static final By DRPDWN_CUSTOMER_CATEGORY = By.xpath("//div[@id='Category']");
    private static final By DRPDWN_RISK_CATEGORY = By.xpath("//div[@id='RiskCategory']");
    private static final By DRPDWN_RESIDENT_TYPE = By.xpath("//div[@id='ResidentType']");
    private static final By DRPDWN_GENDER = By.xpath("//div[@id='Gender']");






    private By dropDownOptions(String value){
        return By.xpath("///li[normalize-space()='" + value + "']");
    }

    private void selectDropdown(By dropdown, String value){
        click(dropdown, CLICKABLE);
        click(dropDownOptions(value), CLICKABLE);
    }

    public void getCustomerRegistrationMenu(){click(MENU_CUSTOMER_REGISTRATION, CLICKABLE, "Register Button");}
    public void clickNewButton(){click(BTN_NEW, CLICKABLE, "New Button");}
    public void clickSaveButton(){click(BTN_SAVE, CLICKABLE, "Save Button");}
    public void clickApproveButton(){click(BTN_APPROVE, CLICKABLE, "Approve Button");}
    public void clickPrintButton(){click(BTN_PRINT, CLICKABLE, "Print Button");}
    public void clickDeactivateButton(){click(BTN_DEACTIVATE, CLICKABLE, "Deactivate Button");}
    public void clickKebabMenu(){click(KEBAB_MENU,VISIBLE, "Kebab Menu");}
    public void clickExpandButton(){click(BTN_EXPAND, CLICKABLE, "Expand");}
    public void clickCuatomerCategory(String value){selectDropdown(DRPDWN_CUSTOMER_CATEGORY, value);}
    public void clickRiskCategory(String value){selectDropdown(DRPDWN_RISK_CATEGORY, value);}
    public void clickResidentType(String value){selectDropdown(DRPDWN_RESIDENT_TYPE, value);}
    public void clickGender(String value){selectDropdown(DRPDWN_GENDER, value);}
}

