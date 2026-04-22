package com.cinque.utils;

import com.cinque.testdata.TestData;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.TestDataReader;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class DataProviderUtils {

    @DataSupplier
    public StreamEx<TestData> getData(Method method) {

        String testcaseName = method.getName();
        return TestDataReader.use(XlsxReader.class).withTarget(TestData.class)
                .withSource("testdata/testdata.xlsx")
                .read().filter(testdata -> testdata.getTestcasename().equalsIgnoreCase(testcaseName));
    }
}