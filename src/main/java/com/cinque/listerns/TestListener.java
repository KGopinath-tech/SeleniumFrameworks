package com.cinque.listerns;

import com.cinque.Reports.ExtentLogger;
import com.cinque.Reports.ExtentReport;
import com.cinque.Reports.Extentmanager;
import com.cinque.Reports.TestContext;
import com.cinque.annotations.FrameworkAnnotation;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getName();

        TestContext.setTestName(testName);
        ExtentReport.createTest(testName);

        FrameworkAnnotation annotation = result.getMethod()
                .getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotation.class);
        if (annotation != null) {
            ExtentReport.assignAuthor(testName, annotation.author());
            ExtentReport.assignCategory(testName, annotation.category());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getName();

        ExtentLogger.pass(testName + " is passed");
        Extentmanager.removeExtentTest(testName);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        ExtentLogger.fail(testName + " is failed");
        if (result.getThrowable() != null) {
            ExtentLogger.fail(result.getThrowable().getMessage());
        }
        Extentmanager.removeExtentTest(testName);
    }

    @Override
    public void onStart(ITestContext context) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.flushReports();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getName();
        TestContext.setTestName(testName);
        if (Extentmanager.getExtentTest(testName) == null) {
            ExtentReport.createTest(testName);
        }
        ExtentLogger.info(testName + " is skipped");
        Extentmanager.removeExtentTest(testName);
    }
}
