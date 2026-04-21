import java.util.Arrays;
import java.util.Random;

public class task8 {
    public static void main(String[] args) {
        int[] inputArray = new int[20];
        Random random = new Random();
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = random.nextInt(100);
        }
        System.out.println("Исходный массив : " + Arrays.toString(inputArray));

        int moreThanValue = 80;

        int[] outputArray = filterGreaterThen(inputArray, moreThanValue);

        System.out.println("Числа, которые больше " + moreThanValue + " : " + Arrays.toString(outputArray));
    }

    public static int[] filterGreaterThen(int[] arr, int moreThanValue) {
        return Arrays.stream(arr).filter(x -> x > moreThanValue).toArray();
    }
}
