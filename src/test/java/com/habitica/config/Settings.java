package com.habitica.config;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Properties;

public class Settings {

    public static String pathToSettingXml = "/C:/Users/ilyab/Repositories/IdeaProjects/HabiticaAutomatedTesting/src/test/resources/settings.xml";
    public static String entryTagName = "entry";
    public static String keyAttributeName = "key";

    private static final Properties properties = new Properties();
    private static String baseUrl;
    private static String login;
    private static String password;
    private static String path;

    static {
        try {
            File file = new File(pathToSettingXml);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName(entryTagName);

            properties.setProperty(((Element) nodeList.item(0)).getAttribute(keyAttributeName), nodeList.item(0).getTextContent());
            properties.setProperty(((Element) nodeList.item(1)).getAttribute(keyAttributeName), nodeList.item(1).getTextContent());
            properties.setProperty(((Element) nodeList.item(2)).getAttribute(keyAttributeName), nodeList.item(2).getTextContent());
            properties.setProperty(((Element) nodeList.item(3)).getAttribute(keyAttributeName), nodeList.item(3).getTextContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUrl() {
        if (baseUrl == null) {
            baseUrl = properties.getProperty("BaseUrl");
        }
        return baseUrl;
    }

    public static String getLogin() {
        if (login == null) {
            login = properties.getProperty("Login");
        }
        return login;
    }

    public static String getPassword() {
        if (password == null) {
            password = properties.getProperty("Password");
        }
        return password;
    }

    public static String getPath() {
        if (path == null) {
            path = properties.getProperty("Path");
        }
        return path;
    }
}
