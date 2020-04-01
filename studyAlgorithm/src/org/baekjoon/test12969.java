package org.baekjoon;

import java.util.Scanner;

public class test12969 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] dp = new int[N + 1];
		dp[3] = 3;
		for (int i = 4; i <= N; i++)
			dp[i] = dp[i - 1] + 2;

		if (dp[N] < K)
			System.out.println(-1);

		

		StringBuilder st = new StringBuilder();
		int base = K;
		if (N > 3) {
			while (base > 2) {
				base -= 2;
				st.append("A");
			}
		}

		switch (base) {
		case 0:
			st.append("CBA");
			break;
		case 1:
			st.append("BCA");
			break;
		case 2:
			st.append("BAC");
			break;
		case 3:
			st.append("ABC");
			break;
		}
		System.out.println(st);

	}

}
