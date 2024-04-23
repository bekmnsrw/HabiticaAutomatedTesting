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
    public void taskEditingTestCase() throws InterruptedException {
        // Login
        applicationManager.getNavigationHelper().openHomePage();
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(userData);
        applicationManager.getHelperBase().sleep(5);

        // Edit last task
        String lastTitleTask = applicationManager.getTaskHelper().getLastTask().title();
        applicationManager.getTaskHelper().editTask(taskData);
        applicationManager.getHelperBase().sleep(5);

        // Assert title of last task equals updated title
        String updatedTaskTitle = applicationManager.getTaskHelper().getLastTask().title();
        Assertions.assertEquals(lastTitleTask + taskData.title(), updatedTaskTitle);

        // Logout
        applicationManager.getLogoutHelper().logout();
        applicationManager.getHelperBase().sleep(5);
    }
}
