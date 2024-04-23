package com.habitica.helper;

import com.habitica.ApplicationManager;
import com.habitica.base.HelperBase;
import com.habitica.data.TaskData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskHelper extends HelperBase {

    public TaskHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void createTask(TaskData taskData) throws InterruptedException {
        // Wait for 'Add a habit' input field present
        WebDriverWait wait = applicationManager.getHelperBase().setUpWebDriverWait();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div")));
        waitForPageFullLoaded();

        // Enter new task title
        webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/textarea")).click();
        webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/textarea")).clear();
        webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/textarea")).sendKeys(taskData.title());

        // Sleep to verify that title text is inserted
        sleep();

        // Add task title
        sendKey(Keys.ENTER);

        // Sleep to verify that task is added
        sleep();
    }

    public void editTask(TaskData taskData) throws InterruptedException {
        // Wait for 'Add a habit' input field present
        WebDriverWait wait = applicationManager.getHelperBase().setUpWebDriverWait();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div")));
        waitForPageFullLoaded();

        // Edit last task
        webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div/div/div/div")).click();
        sleep();
        webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div/div/div/div[2]/div/div")).click();
        sleep();
        webDriver.findElement(By.xpath("//header[@id='task-modal___BV_modal_header_']/div/div[2]/input")).click();
        sleep();
        webDriver.findElement(By.xpath("//header[@id='task-modal___BV_modal_header_']/div/div[2]/input")).sendKeys(taskData.title());
        sleep();
        webDriver.findElement(By.xpath("//header[@id='task-modal___BV_modal_header_']/div/div/div/button[2]/div")).click();
        sleep();
    }

    public void deleteTask() throws InterruptedException {
        // Wait for 'Add a habit' input field present
        WebDriverWait wait = applicationManager.getHelperBase().setUpWebDriverWait();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div")));
        waitForPageFullLoaded();

        // Open drop down menu
        webDriver.findElement(By.cssSelector("div.svg-icon.dropdown-icon > svg > path")).click();
        acceptNextAlert = true;
        sleep();

        // Click delete button
        webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div/div/div/div[2]/div/div[4]/span/span[2]")).click();
        sleep();

        closeAlertAndGetItsResult();
    }

    public TaskData getLastTask() {
        String taskTitle = webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div/div/h3/p")).getText();
        System.out.println("Last task title: " + taskTitle);
        return new TaskData(taskTitle);
    }
}
