package com.habitica.test;

import com.habitica.base.AuthBase;
import com.habitica.data.task.TaskData;
import com.habitica.generator.TaskGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HabiticaTaskCreationTest extends AuthBase {

    public static List<TaskData> createTestData() {
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
    @MethodSource("com.habitica.test.HabiticaTaskCreationTest#createTestData")
    public void taskCreationTestCase(TaskData taskData) throws Exception {
        // Create new task
        applicationManager.getTaskHelper().createTask(taskData);

        // Assert title of last (created) task equals 'Do some gymnastics'
        String expectedTitle = taskData.title();
        String actualTitle = applicationManager.getTaskHelper().getLastTask().title();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }
}
