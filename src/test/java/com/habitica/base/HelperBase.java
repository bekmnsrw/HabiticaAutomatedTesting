package com.habitica.base;

import com.habitica.ApplicationManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
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

    public WebDriverWait setUpWebDriverWait() {
        return new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public void waitForPageFullLoaded() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(
            (ExpectedCondition<Boolean>) wd -> {
                assert wd != null;
                return ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete");
            }
        );
    }

    public void sleep() throws InterruptedException {
        Thread.sleep(3 * 1000);
    }

    public void closeAlertAndGetItsResult() {
        try {
            Alert alert = webDriver.switchTo().alert();
            if (acceptNextAlert) { alert.accept(); }
            else { alert.dismiss(); }
        } finally { acceptNextAlert = true; }
    }

    public void sendKey(Keys key) {
        new Actions(webDriver).sendKeys(key).perform();
    }

    public String getCurrentUrl() {
        String currentUrl = webDriver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        return currentUrl;
    }
}
