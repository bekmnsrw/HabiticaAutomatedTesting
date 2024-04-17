package com.habitica.test;

import com.habitica.base.TestBase;
import com.habitica.data.TaskData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HabiticaTaskCreationTest extends TestBase {

    private static final TaskData taskData = new TaskData("Do some gymnastics");

    @Test
    public void taskCreationTestCase() throws InterruptedException {
        applicationManager.getTaskHelper().createTask(taskData);
        applicationManager.getHelperBase().sleep(5);

        Assertions.assertEquals(taskData.title(), applicationManager.getTaskHelper().getLastTask().title());
    }
}
