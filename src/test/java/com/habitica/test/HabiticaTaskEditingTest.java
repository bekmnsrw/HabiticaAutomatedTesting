package com.habitica.test;

import com.habitica.base.TestBase;
import com.habitica.data.TaskData;
import com.habitica.data.UserData;
import org.junit.Test;

public class HabiticaTaskEditingTest extends TestBase {

    private static final UserData userData = new UserData("bekmnsrw", "HmRdx6v2CZCZ*");
    private static final TaskData taskData = new TaskData(" This is edited task test");

    @Test
    public void takEditingTestCase() throws InterruptedException {
        applicationManager.getNavigationHelper().openHomePage();
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(userData);
        applicationManager.getHelperBase().sleep(5);

        applicationManager.getTaskHelper().editTask(taskData);
        applicationManager.getHelperBase().sleep(5);
    }
}
