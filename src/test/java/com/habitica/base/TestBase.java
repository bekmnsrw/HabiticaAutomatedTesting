package com.habitica.base;

import com.habitica.data.TaskData;
import com.habitica.data.UserData;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase {

    private static final String DRIVER_PROPERTY = "webdriver.gecko.driver";
    private static final String DRIVER_PATH = "C:\\Users\\ilyab\\TestingCourse\\geckodriver.exe";
    private static final String BASE_URL = "https://habitica.com/static/home";
    private static final String FIREFOX_PATH = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
    private static final Duration TIMEOUT = Duration.ofSeconds(30);

    protected WebDriver webDriver;

    @Before
    public void setUp() {
        System.setProperty(DRIVER_PROPERTY, DRIVER_PATH);
        FirefoxOptions firefoxOptions = setUpFirefoxOptions();
        webDriver = new FirefoxDriver(firefoxOptions);
        setUpTimeout();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    private FirefoxOptions setUpFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(FIREFOX_PATH);
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return firefoxOptions;
    }

    private void setUpTimeout() {
        webDriver.manage().timeouts().implicitlyWait(TIMEOUT);
    }

    protected void sleep(long seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    private WebDriverWait setUpWebDriverWait() {
        return new WebDriverWait(webDriver, TIMEOUT);
    }

    protected void openHomePage() throws InterruptedException {
        webDriver.get(BASE_URL);
        sleep(3);
    }

    protected void openLoginPage() throws InterruptedException {
        webDriver.findElement(By.cssSelector("a[href*='/login']")).click();
        WebDriverWait wait = setUpWebDriverWait();
        wait.until(ExpectedConditions.urlContains("/login"));
        sleep(3);
    }

    protected void login(UserData userData) throws InterruptedException {
        webDriver.findElement(By.id("usernameInput")).click();
        webDriver.findElement(By.id("usernameInput")).clear();
        webDriver.findElement(By.id("usernameInput")).sendKeys(userData.username());
        webDriver.findElement(By.id("passwordInput")).click();
        webDriver.findElement(By.id("passwordInput")).clear();
        webDriver.findElement(By.id("passwordInput")).sendKeys(userData.password());
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        sleep(3);
    }

    protected void openTaskCreationDialog() throws InterruptedException {
        webDriver.findElement(By.xpath("//div[@id='create-task-btn']/div[2]")).click();
        sleep(3);
        webDriver.findElement(By.xpath("//div[@id='app']/div[4]/div[3]/div/div/div/div[2]/div[2]/div")).click();
        sleep(3);
    }

    protected void enterTaskData(TaskData taskData) throws InterruptedException {
        webDriver.findElement(By.xpath("//header[@id='task-modal___BV_modal_header_']/div/div[2]/input")).clear();
        webDriver.findElement(By.xpath("//header[@id='task-modal___BV_modal_header_']/div/div[2]/input")).sendKeys(taskData.title());
        sleep(3);
    }

    protected void createTask() throws InterruptedException {
        webDriver.findElement(By.xpath("//header[@id='task-modal___BV_modal_header_']/div/div/div/button[2]/div")).click();
        sleep(3);
    }
}
