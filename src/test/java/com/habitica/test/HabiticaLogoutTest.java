package com.habitica.test;

import com.habitica.base.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HabiticaLogoutTest extends TestBase {

    @Test
    public void logoutTestCase() throws InterruptedException {
        applicationManager.getLogoutHelper().logout();
        applicationManager.getHelperBase().sleep(5);

        Assertions.assertEquals(applicationManager.getHelperBase().getCurrentUrl(), "https://habitica.com/static/home");
    }
}
