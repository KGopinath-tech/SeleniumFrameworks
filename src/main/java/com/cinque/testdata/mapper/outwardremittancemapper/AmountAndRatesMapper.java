package com.cinque.testdata.mapper.outwardremittancemapper;

import com.cinque.testdata.DTO.outwardremittancedata.AmountAndRatesData;
import com.cinque.testdata.OutwardRemittanceTestData;

public class AmountAndRatesMapper {

    public static AmountAndRatesData map (OutwardRemittanceTestData data){
        return AmountAndRatesData.builder().fcamount(data.getFcamount()).
                lcamount(data.getLcamount()).
                commission(data.getCommission()).
                othercharges(data.getOthercharges()).
                discount(data.getDiscount()).
                paymode(data.getPaymode()).
                build();
    }
}
