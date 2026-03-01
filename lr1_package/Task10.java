package lr1_package;

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

            System.out.println("Введите первое число");
            int a = in.nextInt();

            System.out.println("Введите второе число");
            int b = in.nextInt();

            System.out.println("Сумма: " + (a + b));
            System.out.println("Разность: " + (a - b));
        }
    }
