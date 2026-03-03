package com.cinque.pages;

import com.cinque.pages.commonregistration.IndividualPersonalDetailsComponents;
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

    private By dropDownOptions(String value){
        return By.xpath("///li[normalize-space()='" + value + "']");
    }

    private void selectDropdown(By dropdown, String value){
        click(dropdown, CLICKABLE);
        click(dropDownOptions(value), CLICKABLE);
    }

    private IndividualPersonalDetailsComponents getCustomerRegistrationMenu(){
        click(MENU_CUSTOMER_REGISTRATION, CLICKABLE, "Register Button");
        return this;
    }
    private IndividualPersonalDetailsComponents clickNewButton(){
        click(BTN_NEW, CLICKABLE, "New Button");
        return this;
    }
    private IndividualPersonalDetailsComponents clickSaveButton(){
        click(BTN_SAVE, CLICKABLE, "Save Button");
        return this;
    }
    private IndividualPersonalDetailsComponents clickApproveButton(){
        click(BTN_APPROVE, CLICKABLE, "Approve Button");
        return this;
    }
    private IndividualPersonalDetailsComponents clickPrintButton(){
        click(BTN_PRINT, CLICKABLE, "Print Button");
        return this;
    }
    private IndividualPersonalDetailsComponents clickDeactivateButton(){
        click(BTN_DEACTIVATE, CLICKABLE, "Deactivate Button");
        return this;
    }
    private IndividualPersonalDetailsComponents clickKebabMenu(){
        click(KEBAB_MENU,VISIBLE, "Kebab Menu");
        return this;
    }
    private IndividualPersonalDetailsComponents clickExpandButton(){
        click(BTN_EXPAND, CLICKABLE, "Expand");
        return this;
    }
}

