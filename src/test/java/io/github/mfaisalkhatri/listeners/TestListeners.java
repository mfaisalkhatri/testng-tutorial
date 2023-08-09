package io.github.mfaisalkhatri.listeners;

import io.github.mfaisalkhatri.tests.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(final ITestResult result) {
        takeScreenshot();
    }
}
