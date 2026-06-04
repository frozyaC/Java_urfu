package com.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@SuppressWarnings("unchecked")
public class DeleteSubjectFromJSON {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/main/resources/subjects.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("subjects");

            System.out.println("Введите название предмета для удаления:");
            String searchName = in.nextLine().trim();

            Iterator<JSONObject> iterator = jsonArray.iterator();
            boolean found = false;
            while (iterator.hasNext()) {
                JSONObject subject = iterator.next();
                Object name = subject.get("name");
                if (name instanceof String && ((String) name).equalsIgnoreCase(searchName)) {
                    iterator.remove();
                    System.out.println("Предмет '" + searchName + "' удален.");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Предмет с названием '" + searchName + "' не найден.");
            } else {
                try (FileWriter file = new FileWriter("src/main/resources/subjects.json")) {
                    file.write(jsonObject.toJSONString());
                    file.flush();
                }
            }
        } catch (Exception e) {
            System.err.println("Ошибка при чтении или поиске в JSON: " + e.getMessage());
        }
    }
}
