import java.util.Scanner;

public class timus1636 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T1 = in.nextInt();
        int T2 = in.nextInt();

        int ZZZ_shtraf_counter = 0;

        for (int i = 0; i < 10; i++) {
            ZZZ_shtraf_counter += in.nextInt();
        }

        int T2_clear_time = T2 - ZZZ_shtraf_counter * 20;
        if (T2_clear_time < T1 && T2 > T1) {
            System.out.println("Dirty debug :(");
        } else {
            System.out.println("No chance.");
        }
    }
}
