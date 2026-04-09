import java.util.InputMismatchException;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите длину массива: ");
        try {
        int arrayLenth = in.nextInt();
        int sum = 0;
        System.out.println("Введите " + arrayLenth + " целых чисел через пробел");
        for (int i = 0; i < arrayLenth; i++) {
            sum+=in.nextInt();
        }
        System.out.println("Среднее значение: " + (float)sum/arrayLenth);
    }
        catch (InputMismatchException e) {
        System.out.println("Ошибка: Введите целое число");
        }
    }
}
