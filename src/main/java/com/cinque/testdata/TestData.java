package com.cinque.testdata;


import io.github.sskorol.data.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TestData {

    @Column(name ="testcasename")
    private String testcasename;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="expectedTitle")
    private String expectedTitle;
    //    @Column(name="number", converter = IntegerConverter.class)   //if want to read intefer value then need to provide this line
//    public int number;

    //Customer Registration - Personal Details

    @Column(name ="customerCategory")
    private String customercategory;
    @Column(name ="riskCategory")
    private String riskcategory;
    @Column(name ="residentType")
    private String residenttype;
    @Column(name = "gender")
    private String gender;
    @Column(name ="materialStatus")
    private String materialstatus;
    @Column(name ="firstName")
    private String firstname;
    @Column(name ="middleName")
    private String middlename;
    @Column(name ="lastName")
    private String lastname;
    @Column(name ="firstUnicodeName")
    private String firstunicodename;
    @Column(name ="middleUnicodeName")
    private String middleunicodename;
    @Column(name ="lastUnicodeName")
    private String lastunicodename;
    @Column(name ="dob")
    private String dob;
    @Column(name ="nationality")
    private String nationality;
    @Column(name ="dualNationality")
    private String dualnationality;
    @Column(name ="countryOfBirth")
    private String countryofbirth;
    @Column(name ="placeOfBirth")
    private String placeofbirth;
    @Column(name ="phoneCode")
    private String phonecode;
    @Column(name = "mobileNumber")
    private String mobilenumber;
    @Column(name = "phoneNumber")
    private String phonenumber;
    @Column(name ="email")
    private String email;
    @Column(name="companyType")
    private String companytype;
    @Column(name="dateOfEstablishment")
    private String dateofestablishment;
    @Column(name="countryOfIncorporation")
    private String countryofincorporation;
    @Column(name="placeOfIncorporation")
    private String placeofincorporation;

    //Address Details
    @Column(name = "addressInUAE")
    private String AddressInUAE;
    @Column(name= "poBox")
    private String POBox;
    @Column(name ="city")
    private String City;
    @Column(name = "nearestAirport")
    private String NearestAirport;
    @Column(name ="emirate")
    private String Emirate;
    @Column(name="district")
    private String District;
    @Column(name="country")
    private String Country;
    @Column(name="homeAddressInCountry")
    private String HomeAddressInCountry;
    @Column(name="temporaryAddress")
    private String TemporaryAddress;

    //Employment Details
    @Column(name="employer")
    private String Employer;
    @Column(name="occupation")
    private String Occupation;

    //Financial Details
    @Column(name="serviceType")
    private String serviceType;
    @Column(name="economicActivity")
    private String economicActivity;
    @Column(name="annualIncome")
    private String annualIncome;
    @Column(name="expectedAnnualActivityRemittance")
    private String expectedAnnualActivityRemittance;
    @Column(name="numberOfTransactionsRemittance")
    private String numberOfTransactionsRemittance;
    @Column(name="expectedAnnualActivityFC")
    private String expectedAnnualActivityFC;
    @Column(name="numberOfTransactionsFC")
    private String numberOfTransactionsFC;
    @Column(name="blockedCountries")
    private String blockedCountries;
    @Column(name="coreActivities")
    private String coreActivities;
    @Column(name="annualTurnover")
    private String annualTurnover;

    //Other Details
    @Column(name="remarks")
    private String remarks;
    @Column(name="location")
    private String location;
    @Column(name="watchlistRemarks")
    private String watchlistRemarks;
    @Column(name="highRiskRemarks")
    private String highRiskRemarks;
    @Column(name="CBLicence")
    private String CBLicence;
    @Column(name="CADIban")
    private String CADIban;
    @Column(name="referredBy")
    private String referredBy;

}
