import java.util.Scanner;

public class timus1502 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int sum = 0;
        for (int i = 0; i <= N; i++) {
            int j = 0 + i;
            while (j <= N) {
                System.out.println("i: " + i + ", j: " + j);
                sum = sum + i + j;
                j++;
            }
        }
        System.out.println(sum);
    }
}
