package com.habitica.test;

import com.habitica.base.TestBase;
import com.habitica.data.UserData;
import org.junit.Test;

public class HabiticaTaskDeletionTest extends TestBase {

    private static final UserData userData = new UserData("bekmnsrw", "HmRdx6v2CZCZ*");

    @Test
    public void taskDeletionTestCase() throws InterruptedException {
        applicationManager.getNavigationHelper().openHomePage();
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(userData);
        applicationManager.getHelperBase().sleep(5);

        applicationManager.getTaskHelper().deleteTask();
        applicationManager.getHelperBase().sleep(5);
    }
}
