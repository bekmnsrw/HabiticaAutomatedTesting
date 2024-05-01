package com.habitica.test;

import com.habitica.base.TestBase;
import com.habitica.config.Settings;
import com.habitica.data.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HabiticaLoginTest extends TestBase {

    private static final UserData userData = new UserData(
            Settings.getLogin(),
            Settings.getPassword()
    );

    @Test
    public void loginTestCase() {
        applicationManager.getLoginHelper().login(userData, true);

        // Wait for user avatar present
        WebDriverWait wait = applicationManager.getHelperBase().setUpWebDriverWait();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='app-header']/div[2]/div/div/div/span[19]")));

        // Assert URL after login equals 'https://habitica.com/'
        String actualUrl = applicationManager.getLoginHelper().getCurrentUrl();
        String expectedUrl = "https://habitica.com/";
        Assertions.assertEquals(expectedUrl, actualUrl);
    }
}
