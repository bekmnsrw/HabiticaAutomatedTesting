package com.habitica.helper;

import com.habitica.ApplicationManager;
import com.habitica.base.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationHelper extends HelperBase {

    private final String baseUrl;

    public NavigationHelper(ApplicationManager applicationManager, String baseUrl) {
        super(applicationManager);
        this.baseUrl = baseUrl;
    }

    public void openHomePage() {
        webDriver.get(baseUrl);
    }

    public void openLoginPage() {
        waitForPageFullLoaded();
        // Wait for login button presence
        WebDriverWait wait = applicationManager.getHelperBase().setUpWebDriverWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='/login']")));

        // Click login button
        webDriver.findElement(By.cssSelector("a[href*='/login']")).click();
    }
}
