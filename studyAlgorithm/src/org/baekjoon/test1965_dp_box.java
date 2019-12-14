package org.baekjoon;

import java.util.Scanner;

public class test1965_dp_box {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		int[] dp = new int[num];
		
		for (int i=0; i<num; i++) {
			dp[i] = 1;
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		for (int i=1; i<num; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i]>arr[j]) 
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
		

	}

}
