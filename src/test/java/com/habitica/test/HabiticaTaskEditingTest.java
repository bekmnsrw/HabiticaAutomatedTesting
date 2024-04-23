package com.habitica.test;

import com.habitica.base.TestBase;
import com.habitica.data.TaskData;
import com.habitica.data.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HabiticaTaskEditingTest extends TestBase {

    private static final UserData userData = new UserData("bekmnsrw", "HmRdx6v2CZCZ*");
    private static final TaskData taskData = new TaskData(" This is edited task test");

    @Test
    public void taskEditingTestCase() throws Exception {
        // Login
        applicationManager.getNavigationHelper().openHomePage();
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(userData);

        // Edit last task
        String lastTitleTask = applicationManager.getTaskHelper().getLastTask().title();
        applicationManager.getTaskHelper().editTask(taskData);

        // Assert title of last task equals updated title
        String actualTaskTitle = applicationManager.getTaskHelper().getLastTask().title();
        String expectedTaskTitle = lastTitleTask + taskData.title();
        Assertions.assertEquals(expectedTaskTitle, actualTaskTitle);

        // Logout
        applicationManager.getLogoutHelper().logout();
    }
}
