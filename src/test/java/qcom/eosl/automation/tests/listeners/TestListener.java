package qcom.eosl.automation.tests.listeners;

import java.io.File;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import qcom.eosl.automation.utility.TimeUtil;

public class TestListener extends TestListenerAdapter {
    // @Override
    // public void onTestFailure(ITestResult result) {
    // try {
    // markTime(result);
    // if (Driver.getSeleniumDriverProvider() != null) {
    // Driver.getSeleniumDriverProvider().takeScreenshot(getScreenshotImageName(result));
    // }
    // } catch (Throwable e) {
    // e.printStackTrace(System.out);
    // }
    // }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            markTime(result);
        } catch (Throwable e) {
            e.printStackTrace(System.out);
        }
    }

    protected long markTime(ITestResult result) {
        String msg = result.getTestClass().getRealClass().getName() + "::" + result.getName();
        long mark = result.getStartMillis();
        long end = System.currentTimeMillis();
        String timeString = TimeUtil.toTimeString(end - mark);
        Reporter.log(msg + " took " + timeString);
        return end;
    }

    protected String getScreenshotImageName(ITestResult result) {
        int number = 0;
        String fileName = generateScreenshotImageFileName(result, null);
        while (new File(fileName).exists()) {
            fileName = generateScreenshotImageFileName(result, ++number);
        }
        return fileName;
    }

    private String generateScreenshotImageFileName(ITestResult result, Integer number) {
        return "target/"
                + (result.isSuccess() ? "Success" : "Failure")
                + "-" + result.getTestClass().getRealClass().getName()
                + "-" + result.getName()
                + (number == null ? "" : number.toString())
                + ".png";
    }
}
