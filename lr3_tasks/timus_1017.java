import java.math.BigInteger;
import java.util.Scanner;

public class timus_1017 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		BigInteger[] dp = new BigInteger[n + 1];
		for (int i = 0; i <= n; i++) {
			dp[i] = BigInteger.ZERO;
		}
		dp[0] = BigInteger.ONE;

		for (int part = 1; part <= n; part++) {
			for (int sum = n; sum >= part; sum--) {
				dp[sum] = dp[sum].add(dp[sum - part]);
			}
		}

		System.out.println(dp[n].subtract(BigInteger.ONE));
	}
}
