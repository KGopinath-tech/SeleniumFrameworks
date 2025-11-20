package com.cinque.utils;

import com.cinque.testdata.TestData;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.TestDataReader;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;

import java.lang.reflect.Method;

public class DataProviderUtils {

    @DataSupplier
    public StreamEx<TestData> getData(Method method){
        return TestDataReader.use(XlsxReader.class).withTarget(TestData.class)
                .withSource("testdata/testdata.xlsx")
                .read().filter(testdata -> testdata.getTestcasename().equalsIgnoreCase(method.getName()));
    }
}
