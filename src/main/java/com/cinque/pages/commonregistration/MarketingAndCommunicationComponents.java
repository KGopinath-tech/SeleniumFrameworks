package com.cinque.pages.commonregistration;

import org.openqa.selenium.By;
import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.*;

public class MarketingAndCommunicationComponents {
    private static final By DGE_EMAIL = By.xpath("//label[normalize-space()='Email']/preceding-sibling::*[@id='flexCheckDefault']");
    private static final By DGE_SMS = By.xpath("//label[normalize-space()='SMS']/preceding-sibling::*[@id='flexCheckDefault']");
    private static final By DGE_WHATSAPP = By.xpath("//label[normalize-space()='Whatsapp']/preceding-sibling::*[@id='flexCheckDefault']");

    private void clickEmailNotification(){
      setToggle(DGE_EMAIL, true);
    }
    private void clickSMSNotification(){
        setToggle(DGE_SMS, true);
    }
    private void clickWhatsappNotification(){
        setToggle(DGE_WHATSAPP, true);
    }
    public void setEmailNotification(){
        clickEmailNotification();
    }
    public void setSMSNotification(){
        clickSMSNotification();
    }
    public void setWhatsappNotification(){
        clickWhatsappNotification();
    }
}
