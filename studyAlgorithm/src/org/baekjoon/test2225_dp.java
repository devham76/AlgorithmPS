package org.baekjoon;

import java.util.Scanner;

public class test2225_dp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// 0~n까지 더해서 k를 만든다
		int[][] dp = new int[N+1][K+1];
		
		for (int i=0; i<N+1; i++) {
			for (int j=1; j<K+1; j++) {
				if (i == 0 || j == 1) dp[i][j] = 1;
				else if (j==2) dp[i][j] = i+1;
				else dp[i][j] = dp[i][j-1] + dp[i-1][j];
				
				dp[i][j] %= 1000000000;
			}
		}
		System.out.println(dp[N][K]);
	}

}
