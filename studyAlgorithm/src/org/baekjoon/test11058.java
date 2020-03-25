	package org.baekjoon;

import java.util.Scanner;

public class test11058 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = N;
		int[] dp = new int[N+1];
		for(int i=1; i<7; i++)
			dp[i] = i;
		
		if(N >= 7) {
			
			for(int i=7; i <=N ; i++) {
				for(int j=1; j<=i-1; j++) {
					System.out.println(i+" , "+ (i-j-1)+" ==>"+( j * dp[i-j-1]));
					dp[i] = Math.max(dp[i], j * dp[i-j-1]);
				}
			}
		}
		System.out.println(dp[N]);

	}

}
