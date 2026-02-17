package com.cinque.pages.sideMenuComponent;

import com.cinque.driver.DriverManager;

import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.*;
import org.openqa.selenium.By;

public class SidebarMenuComponent {

    private static final By MENU_SIDEBAR = By.xpath("//i[@class='bi bi-text-left']");
    private static final By LABEL_MASTER = By.xpath("//p[@class='menu-label fs-medium']");
    private static final By MENU_GENERAL = By.xpath("//span[text()='General']");
    private static final By MENU_CUSTOMER_REGISTRATION = By
            .xpath("//span[@class='grand-child-label fs-medium'][normalize-space()='Customer Registration']");
    private static final By MENU_EMPLOYEE = By.xpath("//span[text()='Employee']");

    public void getSideMenu() {
        click(MENU_SIDEBAR, CLICKABLE, "Side Menu");
    }
    public String getLabelText(){
        return DriverManager.getDriver().findElement(LABEL_MASTER).getText();
    }
    public void getGeneralMenu(){
        click(MENU_GENERAL, CLICKABLE,"General Menu");
    }
    public void getEmployee(){
        click(MENU_EMPLOYEE, CLICKABLE,"Employee Menu");
    }
    public void getCustomerRegistration(){click(MENU_CUSTOMER_REGISTRATION, CLICKABLE,"Customer Registration Menu");}
}
