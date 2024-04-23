package com.habitica.test;

import com.habitica.base.TestBase;
import com.habitica.data.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

public class HabiticaLoginTest extends TestBase {

    private static final UserData userData = new UserData("bekmnsrw", "HmRdx6v2CZCZ*");

    @Test
    public void loginTestCase() throws InterruptedException {
        // Login
        applicationManager.getNavigationHelper().openHomePage();
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(userData);
        applicationManager.getHelperBase().sleep(5);

        // Assert profile username equals 'bekmnsrw'
        Assertions.assertEquals(applicationManager.getLoginHelper().getProfileUsername(), userData.username());

        // Assert url after login equals 'https://habitica.com/profile/69cc0757-ec99-4d0e-8ba2-f6ca1f1cfc82'
        Assertions.assertEquals(applicationManager.getLoginHelper().getCurrentUrl(), "https://habitica.com/profile/69cc0757-ec99-4d0e-8ba2-f6ca1f1cfc82");

        // Close window with profile data
        applicationManager.getHelperBase().sendKey(Keys.ESCAPE);
        applicationManager.getHelperBase().sleep(5);

        // Logout
        applicationManager.getLogoutHelper().logout();
    }
}
