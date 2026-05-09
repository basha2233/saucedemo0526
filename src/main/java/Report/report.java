package Report;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class report {
	public static ExtentReports extent;
	public static ExtentTest test;

    // Create report
    public void setupExtentReport() {

        String timestamp =
                new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
                        .format(new Date());

        String reportPath =
                System.getProperty("user.dir")
                        + "/reports/ExtentReport-"
                        + timestamp
                        + ".html";

        ExtentSparkReporter spark =
                new ExtentSparkReporter(reportPath);

        spark.config().setReportName("Automation Report");
        spark.config().setDocumentTitle("Selenium TestNG Report");

        extent = new ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("Tester", "Your Name");
        extent.setSystemInfo("Environment", "QA");
    }

}
