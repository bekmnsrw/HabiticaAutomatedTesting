package com.habitica;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static org.junit.Assert.fail;

public class HabiticaLoginTest {
    private WebDriver driver;
    private String baseUrl = "";
    private final StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\ilyab\\TestingCourse\\geckodriver.exe");
        baseUrl = "https://habitica.com/static/home";

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new FirefoxDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void testHabiticaLogin() {
        openHomePage();
        openLoginPage();
        login();
    }

    @After
    public void tearDown() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private void openHomePage() {
        driver.get(baseUrl);
    }

    private void openLoginPage() {
        driver.findElement(By.cssSelector("a[href*='/login']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/login"));
    }

    private void login() {
        driver.findElement(By.id("usernameInput")).click();
        driver.findElement(By.id("usernameInput")).clear();
        driver.findElement(By.id("usernameInput")).sendKeys("bekmnsrw");
        driver.findElement(By.id("passwordInput")).click();
        driver.findElement(By.id("passwordInput")).clear();
        driver.findElement(By.id("passwordInput")).sendKeys("HmRdx6v2CZCZ*");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
