package com.habitica.helper;

import com.habitica.ApplicationManager;
import com.habitica.base.HelperBase;
import com.habitica.data.UserData;
import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void login(UserData userData) throws InterruptedException {
        webDriver.findElement(By.id("usernameInput")).click();
        webDriver.findElement(By.id("usernameInput")).clear();
        webDriver.findElement(By.id("usernameInput")).sendKeys(userData.username());
        webDriver.findElement(By.id("passwordInput")).click();
        webDriver.findElement(By.id("passwordInput")).clear();
        webDriver.findElement(By.id("passwordInput")).sendKeys(userData.password());
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        sleep(SLEEP_DURATION);
    }

    public String getProfileUsername() {
        webDriver.findElement(By.xpath("//div[@id='app-header']/div[2]/div[2]/div/div[2]/h3/div/span")).click();
        String profileUsername = webDriver.findElement(By.xpath("//div[@id='profile___BV_modal_body_']/div/div/div/div/div/div[2]/div/div/h3/div")).getText();
        System.out.println(profileUsername);
        return profileUsername;
    }
}
