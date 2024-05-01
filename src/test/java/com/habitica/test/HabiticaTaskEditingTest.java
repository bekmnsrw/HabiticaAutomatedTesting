package com.habitica.test;

import com.habitica.base.AuthBase;
import com.habitica.data.task.TaskData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HabiticaTaskEditingTest extends AuthBase {

    private static final TaskData taskData = new TaskData(" This is edited task test");

    @Test
    public void taskEditingTestCase() throws Exception {
        // Edit last task
        String lastTitleTask = applicationManager.getTaskHelper().getLastTask().title();
        applicationManager.getTaskHelper().editTask(taskData);

        // Assert title of last task equals updated title
        String actualTaskTitle = applicationManager.getTaskHelper().getLastTask().title();
        String expectedTaskTitle = lastTitleTask + taskData.title();
        Assertions.assertEquals(expectedTaskTitle, actualTaskTitle);
    }
}
