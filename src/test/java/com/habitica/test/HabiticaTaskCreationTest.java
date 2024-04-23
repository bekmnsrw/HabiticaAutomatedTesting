package com.habitica.test;

import com.habitica.base.TestBase;
import com.habitica.data.TaskData;
import com.habitica.data.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HabiticaTaskCreationTest extends TestBase {

    private static final UserData userData = new UserData("bekmnsrw", "HmRdx6v2CZCZ*");
    private static final TaskData taskData = new TaskData("Do some gymnastics");

    @Test
    public void taskCreationTestCase() throws InterruptedException {
        // Login
        applicationManager.getNavigationHelper().openHomePage();
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(userData);
        applicationManager.getHelperBase().sleep(5);

        // Create new task
        applicationManager.getTaskHelper().createTask(taskData);
        applicationManager.getHelperBase().sleep(5);

        // Assert title of last (created) task equals 'Do some gymnastics'
        Assertions.assertEquals(taskData.title(), applicationManager.getTaskHelper().getLastTask().title());

        // Logout
        applicationManager.getLogoutHelper().logout();
        applicationManager.getHelperBase().sleep(5);
    }
}
