package com.habitica.test;

import com.habitica.base.TestBase;
import com.habitica.data.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HabiticaTaskDeletionTest extends TestBase {

    private static final UserData userData = new UserData("bekmnsrw", "HmRdx6v2CZCZ*");

    @Test
    public void taskDeletionTestCase() throws Exception {
        // Login
        applicationManager.getNavigationHelper().openHomePage();
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(userData);

        // Delete last task
        String deletedTaskTitle = applicationManager.getTaskHelper().getLastTask().title();
        applicationManager.getTaskHelper().deleteTask();

        String lastTaskTitle = applicationManager.getTaskHelper().getLastTask().title();
        Assertions.assertNotEquals(deletedTaskTitle, lastTaskTitle);

        // Logout
        applicationManager.getLogoutHelper().logout();
    }
}
