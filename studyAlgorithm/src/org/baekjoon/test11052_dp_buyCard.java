package org.baekjoon;

import java.util.Scanner;

public class test11052_dp_buyCard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] card = new int[num+1];
		int[] dp = new int[num+1];
		
		for (int i=1; i<=num; i++)
			card[i] = sc.nextInt();
		
	   for (int i = 1; i <= num; i++) {
	       for (int j = 1; j <= i; j++) {
	           dp[i] = Math.max(dp[i], card[j] + dp[i - j]);
	       }
	   }

		System.out.println(dp[num]);
	}

}
