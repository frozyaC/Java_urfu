import java.util.InputMismatchException;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите длину массива: ");
        try {
            int arrayLenth = in.nextInt();
            byte sum = 0;
            System.out.println("Введите " + arrayLenth + " чисел типа byte через пробел");
            for (int i = 0; i < arrayLenth; i++) {
                sum += in.nextByte();
            }
            System.out.println("Сумма элементов массива: " + sum);
    } catch (InputMismatchException e) {
        System.out.println("Ошибка: Введите число типа byte (от -128 до 127)");
    }
}
}
