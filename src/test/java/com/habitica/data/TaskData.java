package com.habitica.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "task")
public class TaskData {

    @XmlElement(name = "title")
    private String title;

    public TaskData() {}

    public TaskData(String title) {
        this.title = title;
    }

    public String title() {
        return title;
    }
}
