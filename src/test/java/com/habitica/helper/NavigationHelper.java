package com.habitica.helper;

import com.habitica.ApplicationManager;
import com.habitica.base.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationHelper extends HelperBase {

    private final String baseUrl;

    public NavigationHelper(ApplicationManager applicationManager, String baseUrl) {
        super(applicationManager);
        this.baseUrl = baseUrl;
    }

    public void openHomePage() throws InterruptedException {
        webDriver.get(baseUrl);
        sleep(SLEEP_DURATION);
    }

    public void openLoginPage() {
        webDriver.findElement(By.cssSelector("a[href*='/login']")).click();
        WebDriverWait wait = applicationManager.getHelperBase().setUpWebDriverWait(Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("/login"));
    }
}
