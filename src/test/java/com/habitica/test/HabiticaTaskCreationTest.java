package com.habitica.test;

import com.habitica.base.TestBase;
import com.habitica.data.TaskData;
import com.habitica.generator.TaskGenerator;
import com.habitica.data.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HabiticaTaskCreationTest extends TestBase {

    private static final UserData userData = new UserData("bekmnsrw", "HmRdx6v2CZCZ*");

    public static List<TaskData> taskCreationTestCaseData() {
        try {
            List<TaskData> tasks = new ArrayList<>();
            JAXBContext context = JAXBContext.newInstance(TaskData.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            TaskData task = (TaskData) unmarshaller.unmarshal(new File(TaskGenerator.SOURCE + "/task.xml"));
            tasks.add(task);
            return tasks;
        } catch (JAXBException exception) {
            throw new RuntimeException(exception);
        }
    }

    @ParameterizedTest
    @MethodSource("com.habitica.test.HabiticaTaskCreationTest#taskCreationTestCaseData")
    public void taskCreationTestCase(TaskData taskData) throws Exception {
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
