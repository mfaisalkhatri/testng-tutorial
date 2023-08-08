package io.github.mfaisalkhatri;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoTests {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        this.driver = new ChromeDriver();
    }

    @Test(expectedExceptions = TimeoutException.class)
    public void testTimeOutException() {
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        this.driver.get("https://juice-shop.herokuapp.com/");

        System.out.println(this.driver.getTitle());
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void testNoSuchElementException() {
        this.driver.get("https://pcloudy.com");
        final String pageHeader= this.driver.findElement(By.cssSelector("#page > .hero_sec-bg > div > div > h3")).getText();
        System.out.println(this.driver.getTitle());
    }

    @AfterMethod(alwaysRun = true)
        public void tearDown() {
        this.driver.quit();
        }

}
