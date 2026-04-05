import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Число: ");
        int number = scanner.nextInt();

        String binary = toBinary(number);
        System.out.println("В двоичной СС: " + binary);
    }

    public static String toBinary(int number) {
        if (number == 0) {
            return "0";
        }

        long value = number;

        return toBinaryRecursive(value);
    }

    private static String toBinaryRecursive(long n) {
        if (n < 2) {
            return String.valueOf(n);
        }

        return toBinaryRecursive(n / 2) + (n % 2);
    }
}
