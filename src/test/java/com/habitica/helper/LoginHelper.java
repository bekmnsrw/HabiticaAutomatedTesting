package com.habitica.helper;

import com.habitica.ApplicationManager;
import com.habitica.base.HelperBase;
import com.habitica.config.Settings;
import com.habitica.data.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void login(UserData userData, boolean shouldLogoutFirst) {
        // Try catch because on some tests login page being skipped
        try {
            if (!shouldLogoutFirst) {
                if (isAuthorized(Settings.getPath())) {
                    return;
                }
            }

            if (shouldLogoutFirst) {
                if (isAuthorized(Settings.getPath())) {
                    applicationManager.getLogoutHelper().logout();
                } else {
                    return;
                }

            }

            applicationManager.getNavigationHelper().openHomePage();
            applicationManager.getNavigationHelper().openLoginPage();

            // Wait for username input field presence
            sleep();
            WebDriverWait wait = applicationManager.getHelperBase().setUpWebDriverWait();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("usernameInput")));
            webDriver.findElement(By.id("usernameInput")).click();
            webDriver.findElement(By.id("usernameInput")).clear();
            webDriver.findElement(By.id("usernameInput")).sendKeys(userData.username());
            webDriver.findElement(By.id("passwordInput")).click();
            webDriver.findElement(By.id("passwordInput")).clear();
            webDriver.findElement(By.id("passwordInput")).sendKeys(userData.password());
            webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        } catch (Exception ignored) {}
    }

    public boolean isAuthorized() {
        boolean isAuth = applicationManager.getLoginHelper().getCurrentUrl().equals("https://habitica.com/");
        System.out.println(isAuth);
        return isAuth;
    }

    public boolean isAuthorized(String path) {
        boolean isAuth = applicationManager.getLoginHelper().getCurrentUrl().equals(path);
        System.out.println(isAuth);
        return isAuth;
    }
}
