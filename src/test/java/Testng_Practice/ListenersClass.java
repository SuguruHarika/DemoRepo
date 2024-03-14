package Testng_Practice;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersClass implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("test excution is started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("test excuted successfully");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("test excution got failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("test got skipped");
    }

    /*@Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }*/
}
