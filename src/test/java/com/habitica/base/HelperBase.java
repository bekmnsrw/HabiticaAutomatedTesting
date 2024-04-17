package com.habitica.base;

import com.habitica.ApplicationManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperBase {

    protected WebDriver webDriver;
    protected ApplicationManager applicationManager;
    protected boolean acceptNextAlert = true;

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

    public Boolean closeAlertAndGetItsResult() {
        try {
            Alert alert = webDriver.switchTo().alert();
            if (acceptNextAlert) {
                alert.accept();
                return true;
            } else {
                alert.dismiss();
                return false;
            }
        } finally { acceptNextAlert = true; }
    }

    public void sendKey(Keys key) {
        new Actions(webDriver).sendKeys(key).perform();
    }
}
