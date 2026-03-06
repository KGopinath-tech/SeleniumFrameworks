package com.cinque.pages.commonregistration;

import org.openqa.selenium.By;
import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.*;

public class PromotionComponents {

    private static final By TXT_PROMOTION_EXPIRY_DATE = By.xpath("//label[normalize-space()='Promotion Expiry Date']/preceding-sibling::*//input");
    private static final By GDE_APPLY_PROMO = By.xpath("//label[normalize-space()='Apply Promo']/preceding-sibling::*[@id='flexCheckDefault']");
    private static final By TXT_PROMO_CODE = By.id("PromoCode");

    private PromotionComponents enterPromoExpireDate(String promoExpireDate) {
        sendKeys(TXT_PROMOTION_EXPIRY_DATE, promoExpireDate, CLICKABLE, "Promotion Expiry Date");
        return this;
    }
    private PromotionComponents applyPromoCode() {
        setToggle(GDE_APPLY_PROMO, true);
        return this;
    }
    private PromotionComponents enterPromoCode(String promoCode) {
        sendKeys(GDE_APPLY_PROMO, promoCode, CLICKABLE, "Promo Code");
        return this;
    }

    public PromotionComponents fillPromoDetails(String promoCode, String promoExpireDate) {
       return enterPromoCode(promoCode).enterPromoExpireDate(promoExpireDate).applyPromoCode();
    }
}
