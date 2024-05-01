package com.habitica.data.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class UserData {

    @XmlElement(name = "login")
    private String login;

    @XmlElement(name = "password")
    private String password;

    public UserData() {}

    public UserData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String login() {
        return login;
    }

    public String password() {
        return password;
    }
}
