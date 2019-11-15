package org.baekjoon;

import java.util.Scanner;

public class test1003_dp_fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int[][] answer = new int[testCase][2];
		int[][] dp = new int[2][41];
		
		dp[0][0] = 1;	// n = 0
		dp[1][1] = 1;	// n = 1
		
		for(int i = 0; i < testCase; i++) {
			int num = sc.nextInt();
			for(int j = 2; j <= num; j++) {
				dp[0][j] = dp[0][j-1] + dp[0][j-2];
				dp[1][j] = dp[1][j-1] + dp[1][j-2];
			}
			answer[i][0] = dp[0][num];
			answer[i][1] = dp[1][num];
		}
		for(int i = 0; i < testCase; i++) {
			System.out.println(answer[i][0] + " " + answer[i][1]);
		}
	}

}
