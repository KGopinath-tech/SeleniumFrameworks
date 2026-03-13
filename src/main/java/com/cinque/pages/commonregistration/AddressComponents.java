package com.cinque.pages.commonregistration;

import com.cinque.testdata.DTO.AddressDetailsData;
import org.openqa.selenium.By;
import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.*;

public class AddressComponents {


    private static final By TXT_ADDRESS_IN_UAE = By.id("AddressInUAE");
    private static final By TXT_POBOX = By.id("POBoxorZipCode");
    private static final By TXT_CITY = By.id("City");
    private static final By DRP_EMIRATE = By.id("Emirate");
    private static final By DRP_NEAR_AIRPORT = By.id("CustomerNearestAirport");
    private static final By TXT_DISTRICT = By.id("District");
    private static final By DRP_COUNTRY = By.id("Country");
    private static final By TXT_HOME_ADDRESS = By.id("HomeAddressInCountry");
    private static final By TXT_TEMP_ADDRESS = By.id("TemporaryAddress");


    public void fillAddress(AddressDetailsData data){
        sendKeys(TXT_ADDRESS_IN_UAE, data.getAddressInUAE(), CLICKABLE, "Address in UAE" );
        if(isNotBlank(data.getPOBox())){
            sendKeys(TXT_POBOX, data.getPOBox(), CLICKABLE, "POBox");
        }
        if (isNotBlank(data.getCity())){
            sendKeys(TXT_CITY, data.getCity(), CLICKABLE, "City");
        }
        if (isNotBlank(data.getDistrict())){
            sendKeys(TXT_DISTRICT, data.getDistrict(), CLICKABLE, "District");
        }
        selectDropDown(DRP_EMIRATE, data.getEmirate());
        selectDropDown(DRP_NEAR_AIRPORT, data.getNearestAirport());
        selectDropDown(DRP_COUNTRY, data.getCountry());
        if(isNotBlank(data.getHomeAddressInCountry()) && isDisplayed(TXT_HOME_ADDRESS)) {
            sendKeys(TXT_HOME_ADDRESS, data.getHomeAddressInCountry(), CLICKABLE, "HomeAddress");
        }
        if (isNotBlank(data.getTemporaryAddress()) && isDisplayed(TXT_TEMP_ADDRESS)) {
            sendKeys(TXT_TEMP_ADDRESS, data.getTemporaryAddress(), CLICKABLE, "TemporaryAddress");
        }
    }
}
