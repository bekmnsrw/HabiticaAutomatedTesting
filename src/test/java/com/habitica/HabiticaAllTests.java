package com.habitica;

import com.habitica.base.TestBase;
import com.habitica.data.TaskData;
import com.habitica.data.UserData;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;

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

        Assertions.assertEquals(applicationManager.getLoginHelper().getProfileUsername(), userData.username());
        Assertions.assertEquals(applicationManager.getLoginHelper().getCurrentUrl(), "https://habitica.com/profile/69cc0757-ec99-4d0e-8ba2-f6ca1f1cfc82");

        applicationManager.getHelperBase().sendKey(Keys.ESCAPE);
        applicationManager.getHelperBase().sleep(5);
    }

    @Test
    @Order(2)
    public void taskCreationTestCase() throws InterruptedException {
        applicationManager.getTaskHelper().createTask(newTaskData);
        applicationManager.getHelperBase().sleep(5);

        Assertions.assertEquals(newTaskData.title(), applicationManager.getTaskHelper().getLastTask().title());
    }

    @Test
    @Order(3)
    public void taskEditingTestCase() throws InterruptedException {
        applicationManager.getTaskHelper().editTask(updatedTaskData);
        applicationManager.getHelperBase().sleep(5);

        Assertions.assertEquals(newTaskData.title() + updatedTaskData.title(), applicationManager.getTaskHelper().getLastTask().title());
    }

    @Test
    @Order(4)
    public void taskDeletionTestCase() throws InterruptedException {
        applicationManager.getTaskHelper().deleteTask();
        applicationManager.getHelperBase().sleep(5);

        Assertions.assertNotEquals(newTaskData.title() + updatedTaskData.title(), applicationManager.getTaskHelper().getLastTask().title());
    }

    @Test
    @Order(5)
    public void logoutTestCase() throws InterruptedException {
        applicationManager.getLogoutHelper().logout();
        applicationManager.getHelperBase().sleep(5);

        Assertions.assertEquals(applicationManager.getHelperBase().getCurrentUrl(), "https://habitica.com/static/home");
        Assertions.assertTrue(applicationManager.getLogoutHelper().isLoginButtonExists());
    }
}
