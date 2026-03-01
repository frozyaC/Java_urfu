package lr1_package;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

            System.out.println("Введите имя");
            String name = in.nextLine();

            System.out.println("Введите год рождения");
            int year = in.nextInt();

            System.out.println("Пользователь: " + name + ", возраст: " + (2026 - year));
        }
    }
