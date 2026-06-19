package com.cinque.testdata.DTO.inwardremittancedata;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class PaymentDetailsData {

    private String country;
    private String product;
    private String currency;
    private String inwardtype;
    private String expirydate;
    private String commissiontype;
    private String rcnno;
    private String fcamount;
    private String agentcommission;
    private String receivercommission;

}
