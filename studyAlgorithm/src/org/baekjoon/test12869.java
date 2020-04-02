package org.baekjoon;

import java.util.Scanner;

public class test12869 {
	static int[] SCV;

	static int[][] attack = { { 9, 3, 1 }, { 9, 1, 3 }, { 3, 9, 1 }, { 3, 1, 9 }, { 1, 9, 3 }, { 1, 3, 9 } };

	static int min = 60; // 체력의 최대값은 60이고 attack의 최소값은 1이므로 최대 60.
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		SCV = new int[3];
		for (int i = 0; i < N; i++) {
			SCV[i] = sc.nextInt();
		}

		// dp[count][0] count사용해서 0번째 있는 체력
		dp = new int[60][3];
		solve(0);
	}

	private static void solve(int count) {
		
		if(dp[count][0] >= SCV[0] && dp[count][1] >= SCV[1] && dp[count][0] >= SCV[0]) {
			min = Math.min(min, count);
			return;
		}
		
		if(dp[count][0] > 0) {
			return;
		}
		
		for(int i=0; i<6; i++) {
			dp[count+1][0] = dp[count][0] + SCV[0];
			dp[count+1][1] = dp[count][1] + SCV[1];
			dp[count+1][2] = dp[count][2] + SCV[2];
			solve(count+1);
		}
		
	}

}
