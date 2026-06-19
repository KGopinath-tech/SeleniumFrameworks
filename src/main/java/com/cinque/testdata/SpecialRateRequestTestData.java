package com.cinque.testdata;

import io.github.sskorol.data.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SpecialRateRequestTestData {

    @Column(name ="testcasename")
    private String testcasename;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name= "toastType")
    private String toastType;
    @Column(name ="expectedMessages")
    private String expectedMessage;

    //Remittance Special Rate Request
    @Column(name="remid")
    private String remid;
    @Column(name="valuedate")
    private String valuedate;
    @Column(name="rmcurrency")
    private String rmcurrency;
    @Column(name="correspondent")
    private String correspondent;
    @Column(name="rmpaymode")
    private String rmpaymode;
    @Column(name="rmfcamount")
    private String rmfcamount;
    @Column(name="rmlcamount")
    private String rmlcamount;
    @Column(name="rmremark")
    private String rmremark;

    //FC Special rate Request
    @Column(name="fctype")
    private String fctype;
    @Column(name="fctransactiontype")
    private String fctransactiontype;
    @Column(name="fccurrency")
    private String fccurrency;
    @Column(name="fcamount")
    private String fcamount;
    @Column(name="lcamount")
    private String lcamount;
    @Column(name="fcremark")
    private String fcremark;

    //Special rate search
    @Column(name="searchreferenceno")
    private String searchreferenceno;
    @Column(name="searchfromdate")
    private String searchfromdate;
    @Column(name="searchtodate")
    private String searchtodate;
    @Column(name="searchstatus")
    private String searchstatus;
    @Column(name="searchtransactiontype")
    private String searchtransactiontype;
}
