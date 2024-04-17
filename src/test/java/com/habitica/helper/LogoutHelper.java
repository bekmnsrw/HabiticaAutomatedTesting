package com.habitica.helper;

import com.habitica.ApplicationManager;
import com.habitica.base.HelperBase;
import org.openqa.selenium.By;

public class LogoutHelper extends HelperBase {

    public LogoutHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void logout() throws InterruptedException {
        webDriver.findElement(By.cssSelector("div.form-inline.desktop-only > div.habitica-menu-dropdown.dropdown.item-user.item-with-icon > div.habitica-menu-dropdown-toggle > div > div > div.top-menu-icon.svg-icon.user > svg")).click();
        webDriver.findElement(By.xpath("//div[@id='menu_collapse']/div[2]/div[2]/div[2]/div/a[9]")).click();
        sleep(SLEEP_DURATION);
    }
}
