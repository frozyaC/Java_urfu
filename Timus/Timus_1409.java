package Timus;

import java.util.Scanner;

public class Timus_1409 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int GarryCans = in.nextInt();
        int LarryCans = in.nextInt();
        int totalCans = GarryCans + LarryCans - 1;

        System.out.println(totalCans - GarryCans);
        System.err.println(totalCans - LarryCans);
    }
}
