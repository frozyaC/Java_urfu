package com.example;

import java.io.IOException;

import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("Товары");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Товар");
        headerRow.createCell(1).setCellValue("Харакеристика");
        headerRow.createCell(2).setCellValue("Стоимость");

        Row dataRow1 = sheet.createRow(1);
        dataRow1.createCell(0).setCellValue("Книга");
        dataRow1.createCell(1).setCellValue("Жанр: Фантастика");
        dataRow1.createCell(2).setCellValue(500);

        Row dataRow2 = sheet.createRow(2);
        dataRow2.createCell(0).setCellValue("Телефон");
        dataRow2.createCell(1).setCellValue("Модель: Samsung Galaxy S21");
        dataRow2.createCell(2).setCellValue(15000);

        String filePath = "src/main/resources/products.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("Excel файл успешно создан: " + filePath);
    }
}