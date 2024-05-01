package com.habitica.test;

import com.habitica.base.AuthBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HabiticaLogoutTest extends AuthBase {

    @Test
    public void logoutTestCase() throws Exception {
        // Logout
        applicationManager.getLogoutHelper().logout();

        // Wait for login button presence
        WebDriverWait wait = applicationManager.getHelperBase().setUpWebDriverWait();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Login")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='/login']")));

        // Assert current url equals 'https://habitica.com/static/home'
        String actualUrl = applicationManager.getHelperBase().getCurrentUrl();
        String expectedUrl = "https://habitica.com/static/home";
        Assertions.assertEquals(expectedUrl, actualUrl);

        // Assert login button exists
        Assertions.assertTrue(applicationManager.getLogoutHelper().isLoginButtonPresent());
    }
}
