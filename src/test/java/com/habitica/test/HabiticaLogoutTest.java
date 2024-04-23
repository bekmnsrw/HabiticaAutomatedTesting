package com.habitica.test;

import com.habitica.base.TestBase;
import com.habitica.data.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HabiticaLogoutTest extends TestBase {

    private static final UserData userData = new UserData("bekmnsrw", "HmRdx6v2CZCZ*");

    @Test
    public void logoutTestCase() throws InterruptedException {
        // Login
        applicationManager.getNavigationHelper().openHomePage();
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(userData);
        applicationManager.getHelperBase().sleep(5);

        // Logout
        applicationManager.getLogoutHelper().logout();
        applicationManager.getHelperBase().sleep(5);

        // Assert current url equals 'https://habitica.com/static/home'
        Assertions.assertEquals(applicationManager.getHelperBase().getCurrentUrl(), "https://habitica.com/static/home");

        // Assert login button exists
        Assertions.assertTrue(applicationManager.getLogoutHelper().isLoginButtonExists());
    }
}
