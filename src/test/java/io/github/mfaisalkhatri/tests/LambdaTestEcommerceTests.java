package io.github.mfaisalkhatri.tests;

import io.github.mfaisalkhatri.pages.lambdatestecommerce.LoginPage;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class LambdaTestEcommerceTests extends BaseTest {

    @Test
    public void testLoginPage() {
        driverManager.getDriver().navigate().to("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        final LoginPage loginPage = new LoginPage(driverManager.getDriver());
        loginPage.loginInToWebSite("john+1@gmail.com", "Password989");
            assertEquals(driverManager.getDriver().getTitle(), "Faisal Khatri");
    }


}
