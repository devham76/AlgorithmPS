package org.baekjoon;

import java.util.Scanner;

public class test1309_dp_zoo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[N+1][3];
		
		for (int i = 1; i < N+1; i++) {
			if (i==1) {
				dp[i][0] = 1;dp[i][1] = 1;dp[i][2] = 1;
			}
			else 
			{
				dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
				dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
				dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
			}
		}


		int result = 0;
		for (int i=0; i<3; i++)
			result += dp[N][i];
		System.out.println(result % 9901);
	}

}
