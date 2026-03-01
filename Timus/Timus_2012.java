package Timus;

import java.util.Scanner;

public class Timus_2012 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int totalTasks = 12;
        int firstHourTasks = in.nextInt();
        int leftTasks = totalTasks - firstHourTasks;

        int leftTime = 60 * 4;

        if (leftTime - (leftTasks * 45) >=0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        } 
    }
}
