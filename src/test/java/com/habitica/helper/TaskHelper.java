package com.habitica.helper;

import com.habitica.ApplicationManager;
import com.habitica.base.HelperBase;
import com.habitica.data.TaskData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TaskHelper extends HelperBase {

    public TaskHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void createTask(TaskData taskData) throws InterruptedException {
        webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/textarea")).click();
        webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/textarea")).clear();
        webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/textarea")).sendKeys(taskData.title());
        sendKey(Keys.ENTER);
        sleep(3);
    }

    public void editTask(TaskData taskData) throws InterruptedException {
        webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div/div/div/div")).click();
        webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div/div/div/div[2]/div/div")).click();
        webDriver.findElement(By.xpath("//header[@id='task-modal___BV_modal_header_']/div/div[2]/input")).click();
        webDriver.findElement(By.xpath("//header[@id='task-modal___BV_modal_header_']/div/div[2]/input")).sendKeys(taskData.title());
        webDriver.findElement(By.xpath("//header[@id='task-modal___BV_modal_header_']/div/div/div/button[2]/div")).click();
        sleep(3);
    }

    public void deleteTask() throws InterruptedException {
        webDriver.findElement(By.cssSelector("div.svg-icon.dropdown-icon > svg > path")).click();
        acceptNextAlert = true;
        sleep(3);
        webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div/div/div/div[2]/div/div[4]/span/span[2]")).click();
        sleep(3);
        closeAlertAndGetItsResult();
        sleep(3);
    }
}
