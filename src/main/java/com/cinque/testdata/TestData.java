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

}
