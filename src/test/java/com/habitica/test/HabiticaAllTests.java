package com.habitica.test;

import com.habitica.base.TestBase;
import com.habitica.data.TaskData;
import com.habitica.data.UserData;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HabiticaAllTests extends TestBase {

    private static final UserData userData = new UserData("bekmnsrw", "HmRdx6v2CZCZ*");
    private static final TaskData newTaskData = new TaskData("Do some gymnastics");
    private static final TaskData updatedTaskData = new TaskData(" This is edited task test");

    @Test
    @Order(1)
    public void loginTestCase() throws InterruptedException {
        applicationManager.getNavigationHelper().openHomePage();
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(userData);
        applicationManager.getHelperBase().sleep(5);
    }

    @Test
    @Order(2)
    public void taskCreationTestCase() throws InterruptedException {
        applicationManager.getTaskHelper().createTask(newTaskData);
        applicationManager.getHelperBase().sleep(5);
    }

    @Test
    @Order(3)
    public void taskEditingTestCase() throws InterruptedException {
        applicationManager.getTaskHelper().editTask(updatedTaskData);
        applicationManager.getHelperBase().sleep(5);
    }

    @Test
    @Order(4)
    public void taskDeletionTestCase() throws InterruptedException {
        applicationManager.getTaskHelper().deleteTask();
        applicationManager.getHelperBase().sleep(5);
    }

    @Test
    @Order(5)
    public void logoutTestCase() throws InterruptedException {
        applicationManager.getLogoutHelper().logout();
        applicationManager.getHelperBase().sleep(5);
    }
}
