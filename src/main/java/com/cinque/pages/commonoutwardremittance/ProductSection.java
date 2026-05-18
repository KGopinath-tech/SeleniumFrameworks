package com.cinque.pages.commonoutwardremittance;

import static com.cinque.enums.WaitType.*;

import com.cinque.testdata.DTO.outwardremittancedata.ProductSectionData;
import org.openqa.selenium.By;

import static com.cinque.utils.MessageUtils.waitForNgxSpinner;
import static com.cinque.utils.SeleniumUtils.*;

public class ProductSection {

    private static final By DRP_COUNTRY = By.id("country");
    private static final By DRP_CURRENCY = By.id("currency");
    private static final By BTN_BANK = By.xpath("//button[normalize-space()='Bank/Agent']");
    private static final By BTN_EXPRESS_PRODUCT = By.xpath("//button[normalize-space()='Express Product']");
    private static final By BTN_INTER_BRANCH = By.xpath("//button[normalize-space()='Inter Branch']");
    private static final By DRP_DELIVERY_MODE = By.id("deliveryMode");


    private void selectCountry(String country) { selectDropdownWithRetry(DRP_COUNTRY, country); }
    private void selectCurrency(String currency) { selectDropdownWithRetry(DRP_CURRENCY, currency); }
    private void clickBank(){click(BTN_BANK, CLICKABLE, "Bank/Agent");}
    private void clickExpressProduct(){click(BTN_EXPRESS_PRODUCT, CLICKABLE, "Express Product");}
    private void clickInterBranch() { click(BTN_INTER_BRANCH, CLICKABLE, "Inter Branch");}
    private void selectProduct(String productName) {
        By productLocator = By.xpath(
                "//button[normalize-space()='" + productName + "']");
        click(productLocator, CLICKABLE, "Product");
    }
    private void selectDeliveryMode(String deliveryMode) { selectDropdown(DRP_DELIVERY_MODE, deliveryMode); }

    public void fillProductSectionDetails(ProductSectionData data){
        selectCountry(data.getCountry());
        waitForNgxSpinner();
        selectCurrency(data.getCurrency());
        if(data.getProducttype().equalsIgnoreCase("Bank/Agent")) {
            clickBank();
        }
        else if(data.getProducttype().equalsIgnoreCase("Express Product")) {
            clickExpressProduct();
        } else { clickInterBranch(); }

        waitForNgxSpinner();
        selectProduct(data.getProduct());
        waitForNgxSpinner();
        selectDeliveryMode(data.getDeliverymode());
    }

}
