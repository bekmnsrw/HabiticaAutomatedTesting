package com.habitica.helper;

import com.habitica.ApplicationManager;
import com.habitica.base.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutHelper extends HelperBase {

    public LogoutHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void logout() throws InterruptedException {
        // Wait for profile icon present
        WebDriverWait wait = setUpWebDriverWait();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.form-inline.desktop-only > div.habitica-menu-dropdown.dropdown.item-user.item-with-icon > div.habitica-menu-dropdown-toggle > div > div > div.top-menu-icon.svg-icon.user > svg > path")));

        // Click on profile icon
        sleep();
        webDriver.findElement(By.cssSelector("div.form-inline.desktop-only > div.habitica-menu-dropdown.dropdown.item-user.item-with-icon > div.habitica-menu-dropdown-toggle > div > div > div.top-menu-icon.svg-icon.user > svg")).click();

        // Click on logout button
        sleep();
        webDriver.findElement(By.xpath("//div[@id='menu_collapse']/div[2]/div[2]/div[2]/div/a[9]")).click();

        // Sleep to verify logout (pause between tests)
        sleep();
    }

    public Boolean isLoginButtonPresent() {
        Boolean isLoginButtonPresent = webDriver.findElement(By.cssSelector("a[href*='/login']")).isDisplayed();
        System.out.println("Is login button present: " + isLoginButtonPresent);
        return isLoginButtonPresent;
    }
}
