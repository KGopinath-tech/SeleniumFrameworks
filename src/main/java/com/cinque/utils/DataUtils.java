package com.cinque.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataUtils {

    public static List<String> getExpectedMessagesFromExcel(String data) {
        return Arrays.stream(data.split("\\|"))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
