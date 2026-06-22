package com.cinque.testdata;

import io.github.sskorol.data.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InwardRemittanceTestData {

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

    @Column(name="country")
    private String country;
    @Column(name="product")
    private String product;
    @Column(name="currency")
    private String currency;
    @Column(name="inwardtype")
    private String inwardtype;
    @Column(name="expirydate")
    private String expirydate;
    @Column(name="commissiontype")
    private String commissiontype;
    @Column(name="rcnno")
    private String rcnno;
    @Column(name="fcamount")
    private String fcamount;
    @Column(name="agentcommission")
    private String agentcommission;
    @Column(name="receivercommission")
    private String receivercommission;

    @Column(name="sendertype")
    private String sendertype;
    @Column(name="firstname")
    private String firstname;
    @Column(name="middlename")
    private String middlename;
    @Column(name="lastname")
    private String lastname;
    @Column(name="mobilecode")
    private String mobilecode;
    @Column(name="mobile")
    private String mobile;
    @Column(name="address")
    private String address;
    @Column(name="city")
    private String city;
    @Column(name="sendercountry")
    private String sendercountry;
    @Column(name="nationality")
    private String nationality;
    @Column(name="idtype")
    private String idtype;
    @Column(name="idnumber")
    private String idnumber;
    @Column(name="idissueplace")
    private String idissueplace;
    @Column(name="idissuedate")
    private String idissuedate;
    @Column(name="idexpirydate")
    private String idexpirydate;
    @Column(name="emirate")
    private String emirate;
    @Column(name="nearbyairport")
    private String nearbyairport;

    @Column(name="remid")
    private String remid;
    @Column(name="relation")
    private String relation;
    @Column(name="bank")
    private String bank;
    @Column(name="branch")
    private String branch;
    @Column(name="accountno")
    private String accountno;
    @Column(name="economicactivity")
    private String economicactivity;
    @Column(name="purposeoftransfer")
    private String purposeoftransfer;

}
