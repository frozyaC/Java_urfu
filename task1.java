package lr2_tasks;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner id = new Scanner(System.in);
        System.out.println("\nВведите длину массива");
        int N = id.nextInt();
        int [] nums = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            nums[i] = random.nextInt(200);
        }
        
        System.out.println("\nПолученный массив: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        int[] numsSorted = nums.clone();
        Arrays.sort(numsSorted);

        int minValue = numsSorted[0];
        System.out.println("\nМинимальное значение в массиве: " + minValue);
        System.out.println("Индексы массива с этим значением: ");

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minValue) {
                System.out.print(i);
            }
        }
        }
    }
