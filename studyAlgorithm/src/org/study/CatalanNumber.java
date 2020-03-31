package org.study;

public class CatalanNumber {

	static int[] dp;

	public static void main(String[] args) {
		int N = 10;
		for (int i = 1; i <= N; i++) {
			System.out.println(catalan(i));
		}

		System.out.println();
		dp = new int[N + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
			System.out.println(dp[i]);
		}
	}

	static int catalan(int n) {
		int res = 0;

		// base case
		if (n <= 1) {
			return 1;
		}

		for (int i = 0; i < n; i++) {
			res += catalan(i) * catalan(n - i - 1);
		}
		return res;
	}
}
