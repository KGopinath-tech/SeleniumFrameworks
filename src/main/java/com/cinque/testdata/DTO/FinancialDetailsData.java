package com.cinque.testdata.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class FinancialDetailsData {
    private String serviceType;
    private String economicActivity;
    private String annualIncome;
    private String expectedAnnualActivityRemittance;
    private String numberOfTransactionsRemittance;
    private String expectedAnnualActivityFC;
    private String numberOfTransactionsFC;
    private String blockedCountries;
    private String coreActivities;
    private String annualTurnover;
}
