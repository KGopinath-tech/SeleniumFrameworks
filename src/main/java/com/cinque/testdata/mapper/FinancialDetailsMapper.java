package com.cinque.testdata.mapper;

import com.cinque.testdata.DTO.FinancialDetailsData;
import com.cinque.testdata.TestData;

public class FinancialDetailsMapper {

    public static FinancialDetailsData map (TestData data) {
        return FinancialDetailsData.builder().serviceType(data.getServiceType())
                .economicActivity(data.getEconomicActivity())
                .annualIncome(data.getAnnualIncome())
                .expectedAnnualActivityRemittance(data.getExpectedAnnualActivityRemittance())
                .numberOfTransactionsRemittance(data.getNumberOfTransactionsRemittance())
                .expectedAnnualActivityFC(data.getExpectedAnnualActivityFC())
                .numberOfTransactionsFC(data.getNumberOfTransactionsFC())
                .blockedCountries(data.getBlockedCountries())
                .coreActivities(data.getCoreActivities())
                .annualTurnover(data.getAnnualTurnover())
                .build();
    }
}
