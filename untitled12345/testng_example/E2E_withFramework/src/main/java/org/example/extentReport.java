package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport {
    static ExtentReports extent;
    public static ExtentReports getExtentReports()
    {
        String path =System.getProperty("user.dir")+"\\target\\reports\\extentReports\\extentReport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        extent =new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Aviii");
        return extent;
    }
}
