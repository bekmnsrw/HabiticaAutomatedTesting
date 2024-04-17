package com.habitica.test;

import com.habitica.base.TestBase;
import com.habitica.data.UserData;
import org.junit.jupiter.api.Test;

public class HabiticaLoginTest extends TestBase {

    private static final UserData userData = new UserData("bekmnsrw", "HmRdx6v2CZCZ*");

    @Test
    public void loginTestCase() throws InterruptedException {
        applicationManager.getNavigationHelper().openHomePage();
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(userData);
        applicationManager.getHelperBase().sleep(5);
    }
}
