package lr1_package;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

            System.out.println("Введите число");
            int number = in.nextInt();

            int first = number - 1;
            int second = number;
            int third = number + 1;
            int fourth = (first + second + third) * (first + second + third);

            System.out.println("Последовательность: " + first + " " + second + " " + third + " " + fourth);
        }
    }
