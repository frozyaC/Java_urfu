package com.example;

import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FindInJSON {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/main/resources/subjects.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("subjects");

            System.out.println("Введите название предмета для поиска:");
            String searchName = in.nextLine().trim();

            @SuppressWarnings("unchecked")
            List<JSONObject> subjects = (List<JSONObject>) (List<?>) jsonArray;

            long matches = subjects.stream()
                .filter(subject -> {
                    Object name = subject.get("name");
                    return name instanceof String && ((String) name).equalsIgnoreCase(searchName);
                })
                .peek(subject -> {
                    System.out.println("Предмет: " + subject.get("name"));
                    System.out.println("Преподаватель: " + subject.get("teacher"));
                })
                .count();

            if (matches == 0) {
                System.out.println("Предмет с названием '" + searchName + "' не найден.");
            }
        } catch (Exception e) {
            System.err.println("Ошибка при чтении или поиске в JSON: " + e.getMessage());
        }
    }
}
