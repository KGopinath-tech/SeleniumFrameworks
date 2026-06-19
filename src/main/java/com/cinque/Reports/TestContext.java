package com.cinque.Reports;

public class TestContext {
    private static final ThreadLocal<String> TEST_NAME = new ThreadLocal<>();

    public static void setTestName(String name) { TEST_NAME.set(name); }
    public static String getTestName() { return TEST_NAME.get(); }
    public static void clear() { TEST_NAME.remove(); }
}
