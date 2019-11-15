package org.baekjoon;

import java.util.Scanner;

public class test2156_dp_wine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] wine = new int[num];
		int[] dp = new int[num];
		for ( int i = 0; i < num; i++) {
			wine[i] = sc.nextInt();
		}

		dp[0] = wine[0];
		if (num >= 2)
			dp[1] = wine[0] + wine[1]; 
		if (num >= 3)
			dp[2] = Math.max(wine[0]+wine[1], Math.max(wine[0] + wine[2], wine[1]+wine[2]));
		if (num >= 4) {
			/*
			 * 셋중에 가장 큰값을 구한다.
			 * ooxo
			 * oxxo
			 * oxoo 
			 * */
			for (int i = 3; i < num; i++)
				dp[i] = Math.max(dp[i-1],  Math.max(dp[i-2]+wine[i],  dp[i-3] + wine[i-1]+wine[i]));
		}
		
		System.out.println(dp[num-1]);
	}

}
