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
    public void taskCreationTestCase() throws Exception {
        // Login
        applicationManager.getNavigationHelper().openHomePage();
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(userData);

        // Create new task
        applicationManager.getTaskHelper().createTask(taskData);

        // Assert title of last (created) task equals 'Do some gymnastics'
        String expectedTitle = taskData.title();
        String actualTitle = applicationManager.getTaskHelper().getLastTask().title();
        Assertions.assertEquals(expectedTitle, actualTitle);

        // Logout
        applicationManager.getLogoutHelper().logout();
    }
}
