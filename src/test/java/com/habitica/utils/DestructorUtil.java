package com.habitica.utils;

import com.habitica.ApplicationManager;
import org.junit.jupiter.api.Assertions;

public final class DestructorUtil {

    public static void addDestructor(Runnable runnable) {
        Thread hook = new Thread(runnable);
        Runtime.getRuntime().addShutdownHook(hook);
    }

    public static void addManagerDestructor(ApplicationManager applicationManager) {
        addDestructor(() -> {
            try { if (applicationManager != null && applicationManager.getWebDriver() != null) applicationManager.getWebDriver().quit(); }
            catch (Exception e) { System.out.println(e.getMessage()); }
            finally {
                if (applicationManager != null) {
                    String verificationErrorString = applicationManager.getVerificationErrors().toString();
                    if (!verificationErrorString.equals("")) {
                        Assertions.fail(verificationErrorString);
                    }
                }
            }
        });
    }
}
