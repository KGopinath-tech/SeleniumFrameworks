package com.cinque.pages;

import com.cinque.driver.DriverManager;
import com.cinque.pages.sideMenuComponent.SidebarMenuComponent;

public class HomePage {

    private SidebarMenuComponent sidebarMenuComponent;

    public HomePage(){
       sidebarMenuComponent = new SidebarMenuComponent();
    }

    public String getSymexTitle(){
        return DriverManager.getDriver().getTitle();
    }
    public void clickOnSidebar() {
        sidebarMenuComponent.getSideMenu();
    }
    public String  getMasterLabelText(){
        return sidebarMenuComponent.getLabelText();
    }
}
