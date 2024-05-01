package com.habitica.generator;

import com.habitica.data.task.TaskData;
import com.habitica.data.user.UserData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import static com.habitica.utils.StringUtil.getRandomString;

public class TaskGenerator {

    public static final String SOURCE = "C:/Users/ilyab/Desktop";

    public static void main(String[] args) {
        String type = args[0];
        String filename = args[1];
        String format = args[2];
        if (Objects.equals(type, "task")) GenerateTask(filename, format);
        if (Objects.equals(type, "user")) GenerateUser(filename, format);
        else throw new IllegalArgumentException("Unrecognized type: " + type);
    }

    private static void GenerateTask(String filename, String format) {
        TaskData task = new TaskData(getRandomString(5, 18));

        if (Objects.equals(format, "xml")) {
            try (FileWriter fileWriter = new FileWriter(SOURCE + "/" + filename + "." + format)) { writeTaskToXmlFile(task, fileWriter); }
            catch (IOException exception) { throw new RuntimeException(exception); }
        } else {
            throw new IllegalArgumentException("Unrecognized format: " + format);
        }
    }

    private static void GenerateUser(String filename, String format) {
        UserData user = new UserData(getRandomString(5, 18), getRandomString(5, 18));

        if (Objects.equals(format, "xml")) {
            try (FileWriter fileWriter = new FileWriter(SOURCE + "/" + filename + "." + format)) { writeUserXmlFile(user, fileWriter); }
            catch (IOException exception) { throw new RuntimeException(exception); }
        } else {
            throw new IllegalArgumentException("Unrecognized format: " + format);
        }
    }

    static void writeTaskToXmlFile(TaskData taskData, FileWriter fileWriter) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TaskData.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(taskData, fileWriter);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    static void writeUserXmlFile(UserData userData, FileWriter fileWriter) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(UserData.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(userData, fileWriter);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
