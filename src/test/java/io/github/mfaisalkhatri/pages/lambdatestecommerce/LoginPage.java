package io.github.mfaisalkhatri.pages.lambdatestecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(final WebDriver driver) {
        this.driver = driver;
    }

    private WebElement emailAddressField() {
        return this.driver.findElement(By.id("input-email"));
    }

    private WebElement passwordField() {
        return this.driver.findElement(By.id("input-password"));
    }

    private WebElement loginBtn() {
        return this.driver.findElement(By.cssSelector("input[type=\"submit\"]"));
    }

    public void loginInToWebSite(final String email, final String password) {
        emailAddressField().clear();
        emailAddressField().sendKeys(email);
        passwordField().clear();
        passwordField().sendKeys(password);
        loginBtn().click();
    }
}
