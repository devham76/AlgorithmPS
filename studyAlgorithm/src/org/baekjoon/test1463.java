package org.baekjoon;

import java.util.Scanner;

public class test1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int[] dp = new int[num+1];
		dp[1] = 0;
		for (int i=2; i<num+1; i++) {
			dp[i] = dp[i-1]+1;
			// 해당 숫자가 2로 나눠떨어진다면, 2로나누거나, -1하는 방법 두가지가있다 
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i-1]+1, dp[i/2]+1);
			else if (i % 3 == 0)
				dp[i] = Math.min(dp[i-1]+1, dp[i/3]+1);

		}
		System.out.println(dp[num]);
	}	
}
