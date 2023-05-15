package io.github.mfaisalkhatri;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class DemoTests {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test(expectedExceptions = TimeoutException.class)
    public void testTimeOutException() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        driver.get("https://juice-shop.herokuapp.com/");

        System.out.println(driver.getTitle());
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void testNoSuchElementException() {
        driver.get("https://pcloudy.com");
        String pageHeader= driver.findElement(By.cssSelector("#page > .hero_sec-bg > div > div > h3")).getText();
        System.out.println(driver.getTitle());
    }

    @AfterMethod(alwaysRun = true)
        public void tearDown() {
        driver.quit();
        }

}
