package com.cinque.testdata.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class OtherDetailsData {

    private String remarks;
    private String location;
    private String watchlistRemarks;
    private String highRiskRemarks;
    private String CBLicence;
    private String CADIban;
    private String referredBy;
}
