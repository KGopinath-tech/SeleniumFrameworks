package com.cinque.testdata.mapper.inwardremittancemapper;

import com.cinque.testdata.DTO.inwardremittancedata.PaymentDetailsData;
import com.cinque.testdata.InwardRemittanceTestData;

public class PaymentDetailsMapper {

    public static PaymentDetailsData map (InwardRemittanceTestData data){
        return PaymentDetailsData.builder()
                .country(data.getCountry())
                .product(data.getProduct())
                .currency(data.getCurrency())
                .inwardtype(data.getInwardtype())
                .expirydate(data.getExpirydate())
                .commissiontype(data.getCommissiontype())
                .rcnno(data.getRcnno())
                .fcamount(data.getFcamount())
                .agentcommission(data.getAgentcommission())
                .receivercommission(data.getReceivercommission())
                .build();
    }

}
