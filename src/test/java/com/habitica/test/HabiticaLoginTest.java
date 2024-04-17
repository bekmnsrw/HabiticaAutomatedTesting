package com.habitica.test;

import com.habitica.base.TestBase;
import com.habitica.data.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HabiticaLoginTest extends TestBase {

    private static final UserData userData = new UserData("bekmnsrw", "HmRdx6v2CZCZ*");

    @Test
    public void loginTestCase() throws InterruptedException {
        applicationManager.getNavigationHelper().openHomePage();
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(userData);
        applicationManager.getHelperBase().sleep(5);

        Assertions.assertEquals(applicationManager.getLoginHelper().getProfileUsername(), userData.username());
        Assertions.assertEquals(applicationManager.getLoginHelper().getCurrentUrl(), "https://habitica.com/profile/69cc0757-ec99-4d0e-8ba2-f6ca1f1cfc82");
    }
}
