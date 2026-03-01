package Timus;

import java.util.Scanner;

public class Timus_1293 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int A = in.nextInt();
        int B = in.nextInt();

        int panelSquare = A * B * 2;
        int totalSquare = N * panelSquare;
        System.out.println(totalSquare);
    }
}
