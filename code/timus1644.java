import java.util.Scanner;

public class timus1644 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число экспериментов: ");
        int experimentsCount = in.nextInt();
        int enough = 10;
        int hungry = 2;
        for (int i = 0; i < experimentsCount; i++) {
            int nuts = in.nextInt();
            String status = in.next();
            if (status.equals("satisfied")) {
                if (nuts < enough) enough = nuts;
                if (nuts <= 2 || nuts <= hungry) {
                    System.out.println("Inconsistent");
                    return;
                }
            }
            if (status.equals("hungry")) {
                if (nuts > hungry) hungry = nuts;
                if (nuts <=2 || nuts >= enough) {
                    System.out.println("Inconsistent");
                    return;
                }
            } 
        }
        System.out.println(enough);
    }
}
