package com.cinque.testdata.mapper.customerregistermapper;

import com.cinque.testdata.DTO.customerregisterdata.FinancialDetailsData;
import com.cinque.testdata.CustomerRegisterTestData;

public class FinancialDetailsMapper {

    public static FinancialDetailsData map (CustomerRegisterTestData data) {
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
