package com.habitica.test;

import com.habitica.base.TestBase;
import com.habitica.data.TaskData;
import com.habitica.data.UserData;
import org.junit.Test;

public class HabiticaTaskCreationTest extends TestBase {

    private static final UserData userData = new UserData("bekmnsrw", "HmRdx6v2CZCZ*");
    private static final TaskData taskData = new TaskData("Do some gymnastics");

    @Test
    public void taskCreationTestCase() throws InterruptedException {
        applicationManager.getNavigationHelper().openHomePage();
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(userData);
        applicationManager.getHelperBase().sleep(5);

        applicationManager.getTaskHelper().openTaskCreationDialog();
        applicationManager.getTaskHelper().enterTaskData(taskData);
        applicationManager.getTaskHelper().createTask();
        applicationManager.getHelperBase().sleep(5);
    }
}
