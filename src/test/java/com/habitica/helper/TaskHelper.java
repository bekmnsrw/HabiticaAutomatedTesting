package com.habitica.helper;

import com.habitica.ApplicationManager;
import com.habitica.base.HelperBase;
import com.habitica.data.TaskData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TaskHelper extends HelperBase {

    public TaskHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void createTask(TaskData taskData) throws InterruptedException {
        webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/textarea")).click();
        webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/textarea")).clear();
        webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/textarea")).sendKeys(taskData.title());
        sendKey(Keys.ENTER);
        sleep(SLEEP_DURATION);
    }

    public void editTask(TaskData taskData) throws InterruptedException {
        webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div/div/div/div")).click();
        webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div/div/div/div[2]/div/div")).click();
        webDriver.findElement(By.xpath("//header[@id='task-modal___BV_modal_header_']/div/div[2]/input")).click();
        webDriver.findElement(By.xpath("//header[@id='task-modal___BV_modal_header_']/div/div[2]/input")).sendKeys(taskData.title());
        webDriver.findElement(By.xpath("//header[@id='task-modal___BV_modal_header_']/div/div/div/button[2]/div")).click();
        sleep(SLEEP_DURATION);
    }

    public void deleteTask() throws InterruptedException {
        webDriver.findElement(By.cssSelector("div.svg-icon.dropdown-icon > svg > path")).click();
        acceptNextAlert = true;
        sleep(SLEEP_DURATION);
        webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div/div/div/div[2]/div/div[4]/span/span[2]")).click();
        sleep(SLEEP_DURATION);
        closeAlertAndGetItsResult();
        sleep(SLEEP_DURATION);
    }

    public TaskData getLastTask() {
        String taskTitle = webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div/div/h3/p")).getText();
        System.out.println(taskTitle);
        return new TaskData(taskTitle);
    }
}
