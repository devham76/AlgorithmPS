package org.baekjoon;

import java.util.Scanner;

public class test2293 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coins = new int[n+1];
		int[] dp = new int[k+1];
		for(int i=1; i<=n; i++) {
			coins[i] = sc.nextInt();
		}
		dp[0] = 1;
		for(int coinIdx=1; coinIdx<=n; coinIdx++) {
			for(int price=1; price<=k; price++) {
				if(price >= coins[coinIdx])
					dp[price] += dp[price - coins[coinIdx]];
			}
		}
		System.out.println(dp[k]);
	}

}
