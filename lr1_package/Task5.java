package lr1_package;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);

        System.out.println("Введите год рождения");
        int year = in.nextInt();

        System.out.println("Возраст пользователя: " + (2026-year));
    }
}
