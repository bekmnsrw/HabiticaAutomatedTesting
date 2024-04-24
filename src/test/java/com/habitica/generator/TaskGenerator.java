package com.habitica.generator;

public class TaskGenerator {
    public static final String SOURCE = "C:/Users/ilyab/Desktop";

    public static void main(String[] args) {
        System.out.println(SOURCE);
        String type = args[0];
        int count = Integer.parseInt(args[1]);
        String filename = args[2];
        String format = args[3];
        if (java.util.Objects.equals(type, "task")) GenerateForGroups(count, filename, format);
        else throw new IllegalArgumentException("Unrecognized type: " + type);
    }

    private static void GenerateForGroups(int count, String filename, String format) {
        java.util.List<com.habitica.data.TaskData> tasks = new java.util.LinkedList<>();

        for (int i = 0; i < count; i++) {
            tasks.add(new com.habitica.data.TaskData(com.habitica.utils.StringUtil.getRandomString(5, 18)));
        }

        if (java.util.Objects.equals(format, "xml")) {
            try (java.io.FileWriter fileWriter = new java.io.FileWriter(SOURCE + "/" + filename + "." + format)) { writePostsToXmlFile(tasks, fileWriter); }
            catch (java.io.IOException exception) { throw new RuntimeException(exception); }
        } else {
            throw new IllegalArgumentException("Unrecognized format: " + format);
        }
    }

    static void writePostsToXmlFile(java.util.List<com.habitica.data.TaskData> taskDataList, java.io.FileWriter fileWriter) {
        try {
            com.habitica.data.jaxb.Tasks tasks = new com.habitica.data.jaxb.Tasks();
            tasks.setTasks(taskDataList);
            javax.xml.bind.JAXBContext jaxbContext = javax.xml.bind.JAXBContext.newInstance(com.habitica.data.jaxb.Tasks.class);
            javax.xml.bind.Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(tasks, fileWriter);
        } catch (javax.xml.bind.JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
