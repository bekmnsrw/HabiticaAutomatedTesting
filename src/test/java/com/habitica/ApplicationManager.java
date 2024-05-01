package com.habitica;

import com.habitica.base.HelperBase;
import com.habitica.config.Settings;
import com.habitica.helper.LoginHelper;
import com.habitica.helper.LogoutHelper;
import com.habitica.helper.NavigationHelper;
import com.habitica.helper.TaskHelper;
import com.habitica.utils.DestructorUtil;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class ApplicationManager {

    private static final String DRIVER_PROPERTY = "webdriver.gecko.driver";
    private static final String DRIVER_PATH = "C:\\Users\\ilyab\\TestingCourse\\geckodriver.exe";
    private static final String FIREFOX_PATH = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
    public static final Duration TIMEOUT = Duration.ofSeconds(30);

    private final WebDriver webDriver;
    private final StringBuffer verificationErrors;

    private HelperBase helperBase;
    private NavigationHelper navigationHelper;
    private LoginHelper loginHelper;
    private TaskHelper taskHelper;
    private LogoutHelper logoutHelper;

    private static final ThreadLocal<ApplicationManager> applicationManagerThreadLocal = new ThreadLocal<>();

    private ApplicationManager() {
        System.setProperty(DRIVER_PROPERTY, DRIVER_PATH);
        webDriver = new FirefoxDriver(setUpFirefoxOptions());
        webDriver.manage().window().maximize();
        verificationErrors = new StringBuffer();
        setUpTimeout();
        initHelpers();
        DestructorUtil.addManagerDestructor(this);
    }

    public static ApplicationManager getInstance() {
        if (applicationManagerThreadLocal.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            applicationManagerThreadLocal.set(newInstance);
        }
        return applicationManagerThreadLocal.get();
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

    private void initHelpers() {
        helperBase = new HelperBase(this);
        navigationHelper = new NavigationHelper(this, Settings.getBaseUrl());
        loginHelper = new LoginHelper(this);
        taskHelper = new TaskHelper(this);
        logoutHelper = new LogoutHelper(this);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public HelperBase getHelperBase() {
        return helperBase;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public LogoutHelper getLogoutHelper() {
        return logoutHelper;
    }

    public TaskHelper getTaskHelper() {
        return taskHelper;
    }

    public StringBuffer getVerificationErrors() {
        return verificationErrors;
    }
}
