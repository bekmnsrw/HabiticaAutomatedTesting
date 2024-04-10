package com.habitica.helper;

import com.habitica.ApplicationManager;
import com.habitica.base.HelperBase;
import com.habitica.data.TaskData;
import org.openqa.selenium.By;

public class TaskHelper extends HelperBase {

    public TaskHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void openTaskCreationDialog() throws InterruptedException {
        webDriver.findElement(By.xpath("//div[@id='create-task-btn']/div[2]")).click();
        sleep(5);
        webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div/div[2]/div[2]/div")).click();
        sleep(5);
    }

    public void enterTaskData(TaskData taskData) throws InterruptedException {
        webDriver.findElement(By.xpath("//header[@id='task-modal___BV_modal_header_']/div/div[2]/input")).clear();
        webDriver.findElement(By.xpath("//header[@id='task-modal___BV_modal_header_']/div/div[2]/input")).sendKeys(taskData.title());
        sleep(3);
    }

    public void createTask() throws InterruptedException {
        webDriver.findElement(By.xpath("//header[@id='task-modal___BV_modal_header_']/div/div/div/button[2]/div")).click();
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
}
