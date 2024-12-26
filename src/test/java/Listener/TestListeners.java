package Listener;

import UtilityObjects.SuiteBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;

public class TestListeners extends SuiteBase implements ITestListener{

    ExtentReports extentReport;
    ExtentSparkReporter reporter;
    ExtentTest test;
    Hashtable<String, String> data;
    @Override
    public void onStart(ITestContext context) {
        String time = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss").format(new Date());
        String path = System.getProperty("user.dir") + "//Outputs//Reports//extentReport" + time + ".html";

        reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("ORHRM Web Testing");
        reporter.config().setDocumentTitle("Test Report (Orange HRM Testing)");

        extentReport = new ExtentReports();
        extentReport.attachReporter(reporter);

        System.out.println("Report Initialization Successfully");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReport.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        try{
            data = (Hashtable<String, String>) result.getParameters()[1];
            test = extentReport.createTest("Test Case : " + data.get("Case_ID") + " : " + result.getName());
        }
        catch (Exception e){
            test = extentReport.createTest("Test Case : " + result.getName());
        }


    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Test is passed \n" + result.getParameters()[1]);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL,"Test is failed." + result.getThrowable());

    }


    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP,"Test is Skipped");
    }
}
