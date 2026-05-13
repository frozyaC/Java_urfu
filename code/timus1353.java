import java.util.Scanner;

public class timus1353 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int S = in.nextInt();
        long[] dp = new long[S + 1];
        dp[0] = 1;

        for (int i = 0; i < 9; i++) {
            long[] next = new long[S + 1];

            for (int sum = 0; sum <= S; sum++) {
                for (int digit = 0; digit <= 9 && sum + digit <= S; digit++) {
                    next[sum + digit] += dp[sum];
                }
            }

            dp = next;
        }

        long answer = dp[S];
        if (S == 1) {
            answer++;
        }
        in.close();
        System.out.println(answer);
    }
}
