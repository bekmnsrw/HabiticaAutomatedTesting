package com.habitica.test;

import com.habitica.base.AuthBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HabiticaTaskDeletionTest extends AuthBase {

    @Test
    public void taskDeletionTestCase() throws Exception {
        // Delete last task
        String deletedTaskTitle = applicationManager.getTaskHelper().getLastTask().title();
        applicationManager.getTaskHelper().deleteTask();

        String lastTaskTitle = applicationManager.getTaskHelper().getLastTask().title();
        Assertions.assertNotEquals(deletedTaskTitle, lastTaskTitle);
    }
}
