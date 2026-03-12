package lr2_tasks;

import java.util.Random;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.println("Введите размеры массива через пробел");
        int arrayLength = in.nextInt();
        int arrayWidth = in.nextInt();

        int[][] numArray = new int [arrayLength][arrayWidth];

        int Y = 0;

        Random random = new Random();
        while (Y < arrayWidth) {
        if (Y % 2 == 0) {
            for (int X = 0; X < arrayLength; X++) {
                numArray[X][Y] = random.nextInt(200);
                System.out.print(numArray[X][Y] + " ");
            }
            System.out.println();
            Y+=1;
    } else {
            for (int X = arrayLength - 1; X >= 0; X--) {
                numArray[X][Y] = random.nextInt(200);
                System.out.print(numArray[X][Y] + " ");
            }
            System.out.println();
            Y+=1;
    }
    
}
}
}
