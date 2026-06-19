package com.cinque.testdata.DTO.specialraterequest;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class SpecialRateRequestData {

    private String remid;
    private String valuedate;
    private String rmcurrency;
    private String correspondent;
    private String rmpaymode;
    private String rmfcamount;
    private String rmlcamount;
    private String rmremark;
    private String fctype;
    private String fctransactiontype;
    private String fccurrency;
    private String fcamount;
    private String lcamount;
    private String fcremark;
    private String searchreferenceno;
    private String searchfromdate;
    private String searchtodate;
    private String searchstatus;
    private String searchtransactiontype;

}
