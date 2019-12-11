package org.baekjoon;

import java.util.Scanner;

public class test1904_dp_01tile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] dp = new int[1000000];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i=3; i<=num; i++) {
			dp[i] = dp[i-1]%15746 + dp[i-2]%15746;
			dp[i] %= 15746;
		}
		System.out.println(dp[num]);	
	}

}
