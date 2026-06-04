package com.example;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonParser {
    public static void main(String[] args) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/main/resources/library.json"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("Коревой элемент: " + jsonObject.keySet().iterator().next());
            JSONArray jsonArray = (JSONArray) jsonObject.get("library");

            for (Object o: jsonArray) {
                JSONObject book = (JSONObject) o;
                String title = (String) book.get("title");
                String author = (String) book.get("author");
                long year = (long) book.get("year");
                System.out.println("Название: " + title);
                System.out.println("Автор: " + author);
                System.out.println("Год издания: " + year);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
    }
}
}
