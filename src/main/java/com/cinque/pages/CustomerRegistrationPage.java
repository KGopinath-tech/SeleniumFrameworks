package com.cinque.pages;

import com.cinque.enums.WaitType;
import org.openqa.selenium.By;
import static com.cinque.utils.SeleniumUtils.*;

public class CustomerRegistrationPage {

    private static final By MENU_CUSTOMER_REGISTRATION = By.xpath("//span[text()='Customer Registration']");


    public void getCustomerRegistrationMenu(){
        click(MENU_CUSTOMER_REGISTRATION, WaitType.CLICKABLE, "Customer Registration Menu");
    }
}
