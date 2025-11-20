package com.cinque.pages;

import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.*;


import com.cinque.driver.DriverManager;
import com.cinque.enums.SelectionType;
import com.cinque.utils.DropDownUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage {

    private static final By TXT_BOX_USERNAME = By.id("exampleInputEmail1");
    private static final By TXT_BOX_PASSWORD = By.id("exampleInputPassword1");
    private static final By BTN_LOGIN = By.xpath("//button[@type='submit']");
    private static final By DRP_BRANCH = By.xpath("//div[contains(@class, 'select')]/select");
    private static final By BTN_CONTINUE = By.xpath("//button[@type='button']");

    private LoginPage setUsername(String username){
        sendKeys(TXT_BOX_USERNAME, username,"Username");
        return this;
    }
    private LoginPage setPassword(String password){
        sendKeys(TXT_BOX_PASSWORD, password, "Password");
        return this;
    }
    private HomePage setLogin(){
        click(BTN_LOGIN, CLICKABLE, "LoginButton");
        return new HomePage();
    }
    public void selectBranch(String value){
        DropDownUtils.select(DRP_BRANCH,value, SelectionType.VISIBLE_TEXT);
    }
    public void clickContinue(){
        DriverManager.getDriver().findElement(BTN_CONTINUE).click();
    }
    public HomePage loginToSymexApplication(String username, String password){  //Method Chaining
       return setUsername(username).setPassword(password).setLogin();
    }
}
