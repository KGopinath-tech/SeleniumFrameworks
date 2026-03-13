package com.cinque.pages;

import com.cinque.pages.commonregistration.AddressComponents;
import com.cinque.pages.commonregistration.EmploymentComponents;
import com.cinque.pages.commonregistration.PersonalDetailsComponents;
import com.cinque.testdata.DTO.AddressDetailsData;
import com.cinque.testdata.DTO.PersonalDetailsData;
import org.openqa.selenium.By;

import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.*;

public class CustomerRegistrationPage {


    private PersonalDetailsComponents personalDetails = new PersonalDetailsComponents();
    private AddressComponents address = new AddressComponents();
    private EmploymentComponents employmentDetails = new EmploymentComponents();


    public void fillIndividualIdentityDetails(PersonalDetailsData data){
        personalDetails.fillIndividualPersonalDetails(data);
    }
    public void fillAddressDetails(AddressDetailsData data){address.fillAddress(data);}
    public void fillEmploymentDetails(String employerName, String occupation){employmentDetails.fillEmploymentDetails(employerName,occupation);}


    private static final By MENU_CUSTOMER_REGISTRATION = By.xpath("//span[text()='Customer Registration']");
    private static final By BTN_NEW = By.xpath("//button[text()=' New ']");
    private static final By BTN_SAVE = By.xpath("//button[normalize-space()='Save']");
    private static final By BTN_APPROVE = By.xpath("//button[normalize-space()='Approve']");
    private static final By BTN_PRINT = By.xpath("//button[normalize-space()='Print']");
    private static final By BTN_DEACTIVATE = By.xpath("//button[normalize-space()='Deactivate']");
    private static final By KEBAB_MENU = By.id("moreOptionsDropdown");
    private static final By BTN_EXPAND = By.xpath("//i[@class='fa-solid fa-angles-up']");


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
}

