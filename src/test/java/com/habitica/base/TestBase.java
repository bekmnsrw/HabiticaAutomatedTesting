package com.habitica.base;

import com.habitica.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    protected ApplicationManager applicationManager;

    @BeforeEach
    public void setUp() throws InterruptedException {
        applicationManager = ApplicationManager.getInstance();
        applicationManager.getNavigationHelper().openProfilePage();
        applicationManager.getHelperBase().sleep();
    }
}
