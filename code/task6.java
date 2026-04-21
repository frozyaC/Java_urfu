import java.util.Arrays;
import java.util.Random;

public class task6 {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.println("Исходный массив : ");
        System.out.println(Arrays.toString(arr));

        int divider = 5;
        int[] arrResult = filterByDivisor(arr, divider);

        System.out.println("Числа, которые делятся на " + divider + " :" + Arrays.toString(arrResult));
    }

    public static int[] filterByDivisor(int[] arr, int divisor) {
        return Arrays.stream(arr).filter(x -> x % divisor == 0).toArray();
    }
}