package com.cinque.testdata.DTO.outwardremittancedata;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class RemitterInformationData {

    private String remitterid;
    private String representativename;
    private String purposeoftransfer;
    private String sourceofincome;
}
