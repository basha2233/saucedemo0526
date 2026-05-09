package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Report.report;

public class Listners implements ITestListener {

    report rep= new report();
    Utils util=new Utils();
    
    
    

 
    public void onStart(ITestContext context) {

        rep.setupExtentReport();
    }

 
    public void onTestStart(ITestResult result) {

        System.out.println(result.getName()
                + " test case started");

        report.test = report.extent.createTest(result.getName());

        report.test.log(Status.INFO,
                result.getName()
                        + " test case started");
    }

 
    public void onTestSuccess(ITestResult result) {

        System.out.println(
                "The name of the testcase passed is : "
                        + result.getName());

        report.test.log(Status.PASS,
                "Test Passed : "
                        + result.getName());
    }

   
    public void onTestFailure(ITestResult result) {

        System.out.println(
                "The name of the testcase failed is : "
                        + result.getName());

        report.test.log(Status.FAIL,
                "Test Failed : "
                        + result.getName());

        report.test.log(Status.FAIL,
                result.getThrowable());
        String screenshotPath =
        		util.takeScreenshot(result.getName());

        report.test.addScreenCaptureFromPath(screenshotPath);
    }


    public void onTestSkipped(ITestResult result) {

    	report.test.log(Status.SKIP,
                "Test Skipped : "
                        + result.getName());
    }

 
    public void onFinish(ITestContext context) {

    	report.extent.flush();

        System.out.println(
                "Extent Report Generated");
    }
}