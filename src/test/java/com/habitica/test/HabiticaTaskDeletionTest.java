package com.habitica.test;

import com.habitica.base.TestBase;
import com.habitica.data.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HabiticaTaskDeletionTest extends TestBase {

    private static final UserData userData = new UserData("bekmnsrw", "HmRdx6v2CZCZ*");

    @Test
    public void taskDeletionTestCase() throws InterruptedException {
        // Login
        applicationManager.getNavigationHelper().openHomePage();
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(userData);
        applicationManager.getHelperBase().sleep(5);

        // Delete last task
        String deletedTaskTitle = applicationManager.getTaskHelper().getLastTask().title();
        applicationManager.getTaskHelper().deleteTask();
        applicationManager.getHelperBase().sleep(5);

        // Assert title of last task not equals title of deleted one
        String lastTaskTitle = applicationManager.getTaskHelper().getLastTask().title();
        Assertions.assertNotEquals(deletedTaskTitle, lastTaskTitle);

        // Logout
        applicationManager.getLogoutHelper().logout();
        applicationManager.getHelperBase().sleep(5);
    }
}
