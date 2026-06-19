package com.cinque.testdata.DTO.inwardremittancedata;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class ReceiverDetailsData {
    private String remid;
    private String relation;
    private String bank;
    private String branch;
    private String accountno;
    private String economicactivity;
    private String purposeoftransfer;
}
