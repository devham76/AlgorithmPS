package org.baekjoon;

import java.util.Scanner;

public class test10422 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int[] dp = new int[5001];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= 5000; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
				dp[i] %= 1000000007;
			}
		}
		while (T-- > 0) {

			int n = sc.nextInt();
			
			if (n % 2 != 0) {
				System.out.println(0);
				continue;
			}
			
			
			System.out.println(dp[n/2]);
		}

	}

}
