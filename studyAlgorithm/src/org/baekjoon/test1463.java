package org.baekjoon;

import java.util.Scanner;

public class test1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int[] dp = new int[num+1];
		
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		for(int i=4; i<=num; i++) {
			
			if(i%3==0)
				dp[i] = Math.min( 1+dp[i-1] ,1+dp[i/3]);
			else if (i%2 == 0)
				dp[i] = Math.min(1+dp[i-1], 1+dp[i/2]);
			else
				dp[i] = 1+dp[i-1];
		}
		System.out.println(dp[num]);
	}	
}

