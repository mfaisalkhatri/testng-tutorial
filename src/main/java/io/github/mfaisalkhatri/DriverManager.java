package io.github.mfaisalkhatri;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Objects;

public class DriverManager {

    private WebDriver driver;

    public void createDriver(final Browsers browsers) {

        if (Objects.requireNonNull(browsers) == Browsers.FIREFOX) {
            setupFirefox();
        } else {
            setupChromeDriver();
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    private void setupChromeDriver() {
        this.driver = new ChromeDriver();
    }

    private void setupFirefox() {
        this.driver = new FirefoxDriver();
    }

    public void quitDriver() {
        this.driver.quit();
    }

    private void manageTimeOut() {
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
}
