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


    private void getCustomerRegistrationMenu(){
        click(MENU_CUSTOMER_REGISTRATION, CLICKABLE, "Register Button");
    }
    private void clickNewButton(){
        click(BTN_NEW, CLICKABLE, "New Button");
    }
    private void clickSaveButton(){
        click(BTN_SAVE, CLICKABLE, "Save Button");
    }
    private void clickApproveButton(){
        click(BTN_APPROVE, CLICKABLE, "Approve Button");
    }
    private void clickPrintButton(){
        click(BTN_PRINT, CLICKABLE, "Print Button");
    }
    private void clickDeactivateButton(){
        click(BTN_DEACTIVATE, CLICKABLE, "Deactivate Button");
    }
    private void clickKebabMenu(){
        click(KEBAB_MENU,VISIBLE, "Kebab Menu");
    }
    private void clickExpandButton(){
        click(BTN_EXPAND, CLICKABLE, "Expand");
    }
}

