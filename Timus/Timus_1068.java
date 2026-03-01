package Timus;

import java.util.Scanner;

public class Timus_1068 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

            System.out.println("Введите число");
            int number = in.nextInt();
            int summ;

            if (number >= 1) {
                summ = (1+number) * number / 2;
            } else if (number < 0) {
                summ = 0 - ((1+Math.abs(number)) * Math.abs(number) / 2 - 1);
            } else {
                summ = 0;
            }
            System.out.println("Сумма всех чисел: " + summ);
        }
    }

            