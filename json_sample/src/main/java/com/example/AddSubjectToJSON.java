package com.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class AddSubjectToJSON {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject;
            try {
                Object obj = parser.parse(new FileReader("src/main/resources/subjects.json"));
                jsonObject = (JSONObject) obj;
            } catch (Exception e) {
                jsonObject = new JSONObject();
            }

            JSONArray jsonArray = (JSONArray) jsonObject.get("subjects");
            if (jsonArray == null) {
                jsonArray = new JSONArray();
                jsonObject.put("subjects", jsonArray);
            }

            JSONObject newSubject = new JSONObject();
            System.out.println("Введите название предмета: ");
            newSubject.put("name", in.nextLine());
            System.out.println("Введите имя преподавателя: ");
            newSubject.put("teacher", in.nextLine());
            jsonArray.add(newSubject);

            try (FileWriter file = new FileWriter("src/main/resources/subjects.json")) {
                file.write(jsonObject.toJSONString());
                file.flush();
                System.out.println("JSON-файл успешно обновлен!");
            } catch (Exception e) {
                System.err.println("Ошибка записи в файл: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
