package com.habitica.test;

import com.habitica.base.TestBase;
import com.habitica.data.TaskData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HabiticaTaskEditingTest extends TestBase {

    private static final TaskData taskData = new TaskData(" This is edited task test");

    @Test
    public void taskEditingTestCase() throws InterruptedException {
        applicationManager.getTaskHelper().editTask(taskData);
        applicationManager.getHelperBase().sleep(5);

        Assertions.assertEquals(taskData.title(), applicationManager.getTaskHelper().getLastTask().title());
    }
}
