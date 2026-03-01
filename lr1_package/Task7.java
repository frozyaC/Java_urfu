package lr1_package;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

            System.out.println("Введите возраст");
            int age = in.nextInt();

            System.out.println("Год рождения: " + (2026 - age));
    }
}
