import java.util.Scanner;

public class timus1044 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество чисел в билете: ");
        int numLength = in.nextInt();
        if (numLength % 2 != 0 || numLength <= 0) {
            System.out.println("Количество чисел должно быть положительным четным числом");
            return;
        }
        int maxNumber = Integer.parseInt(String.valueOf(9).repeat(numLength / 2));
        int luckyCounter = 0;
        for (int i = maxNumber; i >=0; i--) {
            for (int j = maxNumber; j >=0; j--) {
                int sum1 = 0;
                int sum2 = 0;
                String num1 = String.format("%0" + (numLength / 2) + "d", i);
                String num2 = String.format("%0" + (numLength / 2) + "d", j);
                for (int k = 0; k < numLength / 2; k++) {
                    sum1 += Character.getNumericValue(num1.charAt(k));
                    sum2 += Character.getNumericValue(num2.charAt(k));
                }
                if (sum1 == sum2) {
                    luckyCounter++;
                }
            }
        }
        System.out.println("Количество счастливых билетов: " + luckyCounter);
    }
}