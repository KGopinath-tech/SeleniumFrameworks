package com.cinque.components.commonregistration;

import com.cinque.testdata.model.AddressData;
import org.openqa.selenium.By;
import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.*;

public class AddressComponents {


    private static final By TXT_ADDRESS_IN_UAE = By.xpath("//input[@id='AddressInUAE']");
    private static final By TXT_POBOX = By.xpath("//input[@id='POBoxorZipCode']");
    private static final By TXT_CITY = By.xpath("//input[@id='City']");
    private static final By DRP_EMIRATE = By.xpath("//input[@id='Emirate']");
    private static final By DRP_NEAR_AIRPORT = By.xpath("//input[@id='CustomerNearestAirport']");
    private static final By TXT_DISTRICT = By.xpath("//input[@id='District']");
    private static final By DRP_COUNTRY = By.xpath("//input[@id='Country']");
    private static final By TXT_HOME_ADDRESS = By.xpath("//input[@id='HomeAddressInCountry']");
    private static final By TXT_TEMP_ADDRESS = By.xpath("//input[@id='TemporaryAddress']");


    private By dropDownOptions(String value){
        return By.xpath("///li[normalize-space()='" + value + "']");
    }

    private void selectDropdown(By dropdown, String value){
        click(dropdown, CLICKABLE);
        click(dropDownOptions(value), CLICKABLE);
    }
    public boolean isDisplayed(By by) {
        return isDisplayed(TXT_TEMP_ADDRESS);
    }

    public void enterAddress(AddressData data){
        sendKeys(TXT_ADDRESS_IN_UAE, data.getAddressInUAE(), CLICKABLE, "Address in UAE" );
        if(data.getPOBox() != null){
            sendKeys(TXT_POBOX, data.getPOBox(), CLICKABLE, "POBox");
        }
        if (data.getCity() != null){
            sendKeys(TXT_CITY, data.getCity(), CLICKABLE, "City");
        }
        if (data.getDistrict() != null){
            sendKeys(TXT_DISTRICT, data.getDistrict(), CLICKABLE, "District");
        }
        selectDropdown(DRP_EMIRATE, data.getEmirate());
        selectDropdown(DRP_NEAR_AIRPORT, data.getNearestAirport());
        selectDropdown(DRP_COUNTRY, data.getCountry());
        if(data.getHomeAddressInCountry() != null) {
            sendKeys(TXT_HOME_ADDRESS, data.getHomeAddressInCountry(), CLICKABLE, "HomeAddress");
        }
        if (data.getTemporaryAddress() != null&& isDisplayed(TXT_TEMP_ADDRESS)) {
            sendKeys(TXT_TEMP_ADDRESS, data.getTemporaryAddress(), CLICKABLE, "TemporaryAddress");
        }
    }
}
