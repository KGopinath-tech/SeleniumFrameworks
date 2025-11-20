package com.cinque.Reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.cinque.config.Configfactory;
import com.cinque.utils.ScreenshotUtils;

public final class ExtentLogger {

    private ExtentLogger(){}

    public static void pass(String message){
        if(Configfactory.getConfig().screenshotForPassedSteps().equalsIgnoreCase("yes")) {
            Extentmanager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshot()).build());
        }else{
            Extentmanager.getExtentTest().pass(message);
        }
    }
    public static void fail(String message){
        Extentmanager.getExtentTest().fail(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshot()).build());
    }
    public static void info(String message){
        Extentmanager.getExtentTest().info(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshot()).build());
    }
}
