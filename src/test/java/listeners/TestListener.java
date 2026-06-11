package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Page;

import base.BaseTest;
import utilities.ExtentManager;
import utilities.ExtentTestManager;
import utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test = ExtentManager
                .getInstance()
                .createTest(result.getMethod().getMethodName());

        ExtentTestManager.setTest(test);

        ExtentTestManager.getTest().info("Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTestManager.getTest().pass("Test Passed ✅");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTestManager.getTest().fail(result.getThrowable());

        try {
            // Get page from BaseTest
            Object testClass = result.getInstance();
            Page page = ((BaseTest) testClass).getPage();
            String path = ScreenshotUtil.takeScreenshot(page, result.getName());

            ExtentTestManager.getTest()
                    .addScreenCaptureFromPath(path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {

        ExtentManager.getInstance().flush(); // ✅ MUST
    }
}