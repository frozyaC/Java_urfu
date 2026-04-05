import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину массива: ");
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];
        fillArray(array, 0, scanner);

        returnArray(array, 0);
    }

        public static void fillArray(int[] array, int index, Scanner scanner) {
            if (index < array.length) {
                System.out.println("Введите элемент: ");
                array[index] = scanner.nextInt();
                fillArray(array, index + 1, scanner);
            }
        }

        public static void returnArray(int[] array, int index) {
            if (index < array.length) {
                System.out.println(array[index] + " ");
                returnArray(array, index + 1);
            }
        }

        





    }
