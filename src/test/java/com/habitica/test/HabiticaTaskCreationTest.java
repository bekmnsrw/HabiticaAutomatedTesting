package com.habitica.test;

import com.habitica.base.TestBase;
import com.habitica.data.TaskData;
import com.habitica.data.UserData;
import com.habitica.data.jaxb.Tasks;
import com.habitica.generator.TaskGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@RunWith(Parameterized.class)
public class HabiticaTaskCreationTest extends TestBase {

    @Parameterized.Parameter
    public TaskData task;

    @Parameterized.Parameters(name = "Task")
    public static List<TaskData> postCreationTestCaseData() {
        try {
            JAXBContext context = JAXBContext.newInstance(Tasks.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Tasks tasks = (Tasks) unmarshaller.unmarshal(new File(TaskGenerator.SOURCE + "/tasks.xml"));
            return tasks.getTasks();
        } catch (JAXBException exception) {
            throw new RuntimeException(exception);
        }
    }

    private static final UserData userData = new UserData("bekmnsrw", "HmRdx6v2CZCZ*");
    private static final TaskData taskData = new TaskData("Do some gymnastics");

    @Test
    public void taskCreationTestCase() throws Exception {
        // Login
        applicationManager.getNavigationHelper().openHomePage();
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(userData);

        // Create new task
        applicationManager.getTaskHelper().createTask(task);

        // Assert title of last (created) task equals 'Do some gymnastics'
        String expectedTitle = taskData.title();
        String actualTitle = applicationManager.getTaskHelper().getLastTask().title();
        Assertions.assertEquals(expectedTitle, actualTitle);

        // Logout
        applicationManager.getLogoutHelper().logout();
    }
}
