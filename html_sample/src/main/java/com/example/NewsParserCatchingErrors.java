package com.example;

import java.io.IOException;
import java.net.UnknownHostException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class NewsParserCatchingErrors {
    public static void main(String[] args) {
        int maxAttempts = 3;
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try {
                Document doc = Jsoup.connect("https://acm.timus.ru1/news.aspx").get();
                Elements newsParent = doc.select("div.news_block");
                int available = newsParent.select(".news_caption").size();
                int toPrint = Math.min(10, available);
                for (int j = 0; j < toPrint; j++) {
                    System.out.println("Новость: " + newsParent.select(".news_caption").get(j).text());
                }
                break;
            } catch (UnknownHostException e) {
                System.out.println("Не удалось подключиться к сайту: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Ошибка при получении страницы: " + e.getMessage());
            }

            if (attempt < maxAttempts) {
                System.out.println("Повторная попытка соединения через 10 секунд (попытка " + (attempt + 1) + ")...");
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    System.out.println("Ожидание прервано, выходим.");
                    break;
                }
            } else {
                System.out.println("Все попытки подключения исчерпаны. Проверьте URL-адрес и интернет-соединение.");
            }
        }
    }
}