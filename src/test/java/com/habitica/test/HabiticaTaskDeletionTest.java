package com.habitica.test;

import com.habitica.base.TestBase;
import org.junit.jupiter.api.Test;

public class HabiticaTaskDeletionTest extends TestBase {

    @Test
    public void taskDeletionTestCase() throws InterruptedException {
        applicationManager.getTaskHelper().deleteTask();
        applicationManager.getHelperBase().sleep(5);
    }
}
