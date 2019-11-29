package org.baekjoon;

import java.util.Scanner;

public class test11055_dp_BiggesSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		int[] dp = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
			dp[i] = arr[i];
		}
		
		int max = 0;
		for (int i = 1; i < num; i++) {
			for (int j = 0; j < i; j++) {
				if ( arr[i] > arr[j] ) {
					dp[i] = Math.max(dp[i], dp[j]+arr[i]);
				}
				max = Math.max(max, dp[i]);
			}
		}
		System.out.println(max);
	}
}
