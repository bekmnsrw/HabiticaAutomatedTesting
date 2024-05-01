package com.habitica.test;

import com.habitica.base.TestBase;
import com.habitica.data.user.UserData;
import com.habitica.generator.TaskGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HabiticaFailureLoginTest extends TestBase {

    public static List<UserData> createUserData() {
        try {
            List<UserData> users = new ArrayList<>();
            JAXBContext context = JAXBContext.newInstance(UserData.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            UserData user = (UserData) unmarshaller.unmarshal(new File(TaskGenerator.SOURCE + "/user.xml"));
            users.add(user);
            return users;
        } catch (JAXBException exception) {
            throw new RuntimeException(exception);
        }
    }

    @ParameterizedTest
    @MethodSource("com.habitica.test.HabiticaFailureLoginTest#createUserData")
    public void failureLoginTestCase(UserData userData) {
        applicationManager.getLoginHelper().login(userData, true);

        // Assert URL after login equals 'https://habitica.com/'
        String actualUrl = applicationManager.getLoginHelper().getCurrentUrl();
        String expectedUrl = "https://habitica.com/";
        Assertions.assertNotEquals(expectedUrl, actualUrl);
    }
}
