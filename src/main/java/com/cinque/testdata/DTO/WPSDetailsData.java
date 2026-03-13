package com.cinque.testdata.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class WPSDetailsData {

    private String MOLId;
    private String VATGiban;
    private String GPSSAPenssionGiban;
    private String corporateTaxGiban;
    private String companyType;
    private String accountNumber;
    private String accountName;
    private String bankName;
    private String registeredBranch;
    private String annualCharges;
    private String annualChargeDate;
    private String serviceCharges;
    private String SIFCharge;
    private String ATMCharge;
}
