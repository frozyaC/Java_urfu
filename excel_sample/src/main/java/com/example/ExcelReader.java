package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
    private static final Scanner scanner = new Scanner(System.in);

    private static boolean shouldContinue() {
        while (true) {
            System.out.println("\n1 - завершить выполнение программы\n2 - изменить значение (название листа/файла)");
            String choice = scanner.nextLine().trim();

            if ("1".equals(choice)) {
                return false;
            }

            if ("2".equals(choice)) {
                return true;
            }

            System.out.println("Введите 1 или 2.");
        }
    }

    public static void main(String[] args) throws IOException {
        String sheetName = "Товар1ы";
        String fileName = "products.xlsx";
        String resourcesPath = "src/main/resources/";

        while (true) {
            try (FileInputStream inputStream = new FileInputStream(resourcesPath + fileName);
                 XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {

                XSSFSheet sheet = workbook.getSheet(sheetName);
                if (sheet == null) {
                    throw new IllegalArgumentException("Лист " + sheetName + " не найден в файле. Проверьте название листа и его наличие.");
                }

                for (Row row: sheet) {
                    for (Cell cell: row) {
                        System.out.print(cell.toString() + "\t");
                    }
                    System.out.println();
                }
                break;
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден: " + e.getMessage() + "\nПроверьте путь к файлу и его наличие.");
                if (!shouldContinue()) {
                    break;
                }

                System.out.print("Введите другое имя файла: ");
                fileName = scanner.nextLine().trim();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                if (!shouldContinue()) {
                    break;
                }

                System.out.print("Введите название листа заново: ");
                sheetName = scanner.nextLine().trim();
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла: " + e.getMessage());
                break;
            }
        }
    }
}
