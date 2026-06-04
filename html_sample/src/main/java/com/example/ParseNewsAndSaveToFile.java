package com.example;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ParseNewsAndSaveToFile {
    public static void main(String[] args) {
        try {
        Document doc = Jsoup.connect("https://acm.timus.ru/news.aspx").get();
        Elements newsParent = doc.select("body > table > tbody > tr > td > table > tbody > tr > td > div.news_block ");

        String path = "src/main/resources/news.txt";
        OutputStream outputStream = new FileOutputStream(path);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < 10; i++) {
            bufferedWriter.write("Новость: " + newsParent.select(".news_caption").get(i).text());
            bufferedWriter.newLine();
            System.out.println("Новость: " + newsParent.select(".news_caption").get(i).text());
        }

        System.out.println("Данные записаны в файл: " + path.toString());
        bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
    }
    } 
}
