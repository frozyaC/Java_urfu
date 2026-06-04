package com.example;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class NewsParser {
    public static void main(String[] args) {
        try {
        Document doc = Jsoup.connect("https://acm.timus.ru/news.aspx").get();
        Elements newsParent = doc.select("body > table > tbody > tr > td > table > tbody > tr > td > div.news_block ");

        for (int i = 0; i < 10; i++) {
            System.out.println("Новость: " + newsParent.select(".news_caption").get(i).text());
        }
        } catch (IOException e) {
            e.printStackTrace();
    }
    } 
}