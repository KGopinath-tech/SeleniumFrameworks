package com.cinque.testdata.DTO.outwardremittancedata;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class AmountAndRatesData {

    private String fcamount;
    private String lcamount;
    private String commission;
    private String othercharges;
    private String discount;
    private String paymode;
}
