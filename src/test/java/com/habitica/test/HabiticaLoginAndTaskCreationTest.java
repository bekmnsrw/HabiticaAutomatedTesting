package com.habitica.test;

import com.habitica.base.TestBase;
import com.habitica.data.TaskData;
import com.habitica.data.UserData;
import org.junit.Test;

public class HabiticaLoginAndTaskCreationTest extends TestBase {

    private static final UserData userData = new UserData("bekmnsrw", "HmRdx6v2CZCZ*");
    private static final TaskData taskData = new TaskData("Do some gymnastics");

    @Test
    public void loginTestCase() throws InterruptedException {
        openHomePage();
        openLoginPage();
        login(userData);
    }

    @Test
    public void taskCreationTestCase() throws InterruptedException {
        openHomePage();
        openLoginPage();
        login(userData);

        openTaskCreationDialog();
        enterTaskData(taskData);
        createTask();
    }
}
