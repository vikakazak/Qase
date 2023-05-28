package tests.base;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AllureUtils;

import java.util.concurrent.TimeUnit;

@Log4j2
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info(String.format("======================================== STARTING TEST {} ========================================", iTestResult.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info(String.format("======================================== FINISHED TEST {} Duration: {}s ========================================", iTestResult.getName(),
                getExecutionTime(iTestResult)));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info(String.format("======================================== FAILED TEST {} Duration: {}s ========================================", iTestResult.getName(),
                getExecutionTime(iTestResult)));
        WebDriver driver = (WebDriver) iTestResult.getTestContext().getAttribute("driver");
        AllureUtils.takeScreenshot(driver);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info(String.format("======================================== SKIPPING TEST {} ========================================", iTestResult.getName()));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }

}
