import java.util.Scanner;

public class timus_1014 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		if (n == 0) {
			System.out.println(10);
			return;
		}
		if (n == 1) {
			System.out.println(1);
			return;
		}

		StringBuilder answer = new StringBuilder();
		for (int digit = 9; digit >= 2; digit--) {
			while (n % digit == 0) {
				answer.append(digit);
				n /= digit;
			}
		}

		if (n != 1) {
			System.out.println(-1);
		} else {
			System.out.println(answer.reverse());
		}
	}
}
