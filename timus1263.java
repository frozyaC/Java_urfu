import java.util.Scanner;

public class timus1263 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        int[] CandidateCounter = new int[N];

        for (int i = 0; i < M; i++) {
            CandidateCounter[in.nextInt() - 1]+=1;
        }

        for (int i = 0; i < N; i++) {
            double percent = (double)CandidateCounter[i] / M * 100;
            System.out.println(String.format("%.2f", percent) + "%");
        }
    }
}
