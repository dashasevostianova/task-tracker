package com.example.demo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;

public class DataManager {
    private static final String FILE_NAME = "user.json";
    private final ObjectMapper mapper;
    public DataManager() {
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public User load() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new User();
        }
        try {
            return mapper.readValue(file, User.class);
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла данных: " + e.getMessage());
            return new User();
        }
    }

    public void store(User user) {
        try {
            mapper.writeValue(new File(FILE_NAME), user);
        } catch (IOException e) {
            System.err.println("Ошибка сохранения данных: " + e.getMessage());
        }
    }
}
