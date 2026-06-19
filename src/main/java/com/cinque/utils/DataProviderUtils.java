package com.cinque.utils;

import com.cinque.testdata.InwardRemittanceTestData;
import com.cinque.testdata.OutwardRemittanceTestData;
import com.cinque.testdata.CustomerRegisterTestData;
import com.cinque.testdata.SpecialRateRequestTestData;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.TestDataReader;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;

import java.lang.reflect.Method;

public class DataProviderUtils {

    @DataSupplier
    public StreamEx<CustomerRegisterTestData> getData(Method method) {

        String testcaseName = method.getName();
        return TestDataReader.use(XlsxReader.class).withTarget(CustomerRegisterTestData.class)
                .withSource("testdata/testdata.xlsx")
                .read().filter(testdata -> testdata.getTestcasename().equalsIgnoreCase(testcaseName));
    }

    @DataSupplier
    public StreamEx<OutwardRemittanceTestData> getOutwardData(Method method) {

        String testcaseName = method.getName();
        return TestDataReader.use(XlsxReader.class).withTarget(OutwardRemittanceTestData.class)
                .withSource("testdata/outwardtestdata.xlsx")
                .read().filter(testdata -> testdata.getTestcasename().equalsIgnoreCase(testcaseName));
    }
    @DataSupplier
    public StreamEx<SpecialRateRequestTestData> getSpecialRateData(Method method) {

        String testcaseName = method.getName();
        return TestDataReader.use(XlsxReader.class).withTarget(SpecialRateRequestTestData.class)
                .withSource("testdata/specialratedata.xlsx")
                .read().filter(testdata -> testdata.getTestcasename().equalsIgnoreCase(testcaseName));
    }
    @DataSupplier
    public StreamEx<InwardRemittanceTestData> getInawardeData(Method method) {

        String testcaseName = method.getName();
        return TestDataReader.use(XlsxReader.class).withTarget(InwardRemittanceTestData.class)
                .withSource("testdata/inwardtestdata.xlsx")
                .read().filter(testdata -> testdata.getTestcasename().equalsIgnoreCase(testcaseName));
    }
}