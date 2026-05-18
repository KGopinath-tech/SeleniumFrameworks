package com.cinque.testdata.DTO.outwardremittancedata;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class ProductSectionData {

    private String country;
    private String currency;
    private String producttype;
    private String product;
    private String deliverymode;
}
