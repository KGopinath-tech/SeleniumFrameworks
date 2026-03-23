package com.cinque.pages.commonregistration;

import org.openqa.selenium.By;

import static com.cinque.utils.SeleniumUtils.*;

public class MarketingAndCommunication {

    private static final By DGL_EMAIL = By.xpath("//label[normalize-space()='Email']/preceding-sibling::*[@id='flexCheckDefault']");
    private static final By DGL_SMS = By.xpath("//label[normalize-space()='SMS']/preceding-sibling::*[@id='flexCheckDefault']");
    private static final By DGL_WHATSAPP = By.xpath("//label[normalize-space()='Whatsapp']/preceding-sibling::*[@id='flexCheckDefault']");

    private MarketingAndCommunication enableEmail(){
       setToggle(DGL_EMAIL, true);
       return this;
    }
    private MarketingAndCommunication enableWhatsapp(){
        setToggle(DGL_WHATSAPP, true);
        return this;
    }
    private MarketingAndCommunication enableSMS(){
        setToggle(DGL_SMS, true);
        return this;
    }

    public void enableCommunicationFromExchange(){
        enableEmail().enableSMS().enableWhatsapp();
    }
}
