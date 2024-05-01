package com.habitica.base;

import com.habitica.ApplicationManager;
import com.habitica.config.Settings;
import com.habitica.data.user.UserData;
import org.junit.jupiter.api.BeforeEach;

public class AuthBase extends TestBase {

    protected static final UserData userData = new UserData(Settings.getLogin(), Settings.getPassword());

    @BeforeEach
    public void setUp() throws InterruptedException {
        // Login
        applicationManager = ApplicationManager.getInstance();
        applicationManager.getLoginHelper().login(userData, false);
        applicationManager.getHelperBase().sleep();
    }
}
