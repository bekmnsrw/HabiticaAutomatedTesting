package com.habitica.base;

import com.habitica.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    protected ApplicationManager applicationManager;

    @BeforeEach
    public void setUp() {
        applicationManager = ApplicationManager.getInstance();
    }
}
