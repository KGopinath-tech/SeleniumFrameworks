package com.cinque.pages.commonregistration;

import org.openqa.selenium.By;

import static com.cinque.enums.WaitType.*;
import static com.cinque.utils.SeleniumUtils.selectDropdown;
import static com.cinque.utils.SeleniumUtils.sendKeys;

public class EmploymentComponents {

    private static final By TXT_EMPLOYER = By.id("Employer");
    private static final By DRP_OCCUPATION = By.id("Occupation");

    private EmploymentComponents enterEmployerName(String employerName) {
        sendKeys(TXT_EMPLOYER, employerName, CLICKABLE, "Employer Name");
        return this;
    }
    private EmploymentComponents selectOccupation(String occupation) {
        selectDropdown(DRP_OCCUPATION, occupation);
        return this;
    }

    public EmploymentComponents fillEmploymentDetails(String employerName, String occupation) {
        return enterEmployerName(employerName).selectOccupation(occupation);
    }
}
