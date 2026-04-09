import java.util.InputMismatchException;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        int[][] array = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = j;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Какой столбец требуется вывести: ");
        Scanner in = new Scanner(System.in);
        try {
            int column = in.nextInt() - 1;
            System.out.println();
            for (int i = 0; i < 3; i++) {
                System.out.println(array[i][column]);
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введите целое число"); 
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Введите число от 1 до 3");
        }
    }
}
