package com.cinque.testdata.DTO.outwardremittancedata;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class ComplianceInformationData {

    private String suspiciousremarks;
    private String ISTRremarks;
    private String SARremarks;
}
