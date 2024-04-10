package com.habitica.base;

import com.habitica.ApplicationManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperBase {

    protected WebDriver webDriver;
    protected ApplicationManager applicationManager;

    public HelperBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.webDriver = applicationManager.getWebDriver();
    }

    public void sleep(long seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    public WebDriverWait setUpWebDriverWait(Duration timeout) {
        return new WebDriverWait(webDriver, timeout);
    }
}
