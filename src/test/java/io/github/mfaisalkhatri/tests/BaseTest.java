package io.github.mfaisalkhatri.tests;

import io.github.mfaisalkhatri.drivermanager.Browsers;
import io.github.mfaisalkhatri.drivermanager.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {

    protected static DriverManager driverManager;

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void startBrowser(final String browserName) {
        driverManager = new DriverManager();
        driverManager.createDriver(Browsers.valueOf(browserName));
    }

    public void takeScreenshot() {
        final File scrFile = ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyyHHmm");
            final Date date = new Date();
            FileUtils.copyFile(scrFile, new File("./image" + simpleDateFormat.format(date) + ".png"));
        } catch (final IOException e) {
            throw new Error("Error getting screenshot", e);
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
//        if(!result.isSuccess()) {
//            takeScreenshot();
//        }
        driverManager.quitDriver();
    }
}
