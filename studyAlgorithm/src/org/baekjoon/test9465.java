package org.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test9465 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t > 0) {
			t--;
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][n];
			int[][] dp = new int[2][n];
			
			for(int i=0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			
			if(n >=2) {
				dp[0][1] = arr[0][1] + arr[1][0];
				dp[1][1] = arr[1][1] + arr[0][0];
			}
		
			if(n >= 3) {
				for(int j=2; j<n; j++) {
					
					dp[0][j] = arr[0][j] + Math.max(dp[0][j-2], Math.max(dp[1][j-2], dp[1][j-1]));
					dp[1][j] = arr[1][j] + Math.max(dp[0][j-2], Math.max(dp[1][j-2], dp[0][j-1]));
				}
				
			}
			/*
			System.out.println("----------------");
			for(int j=0; j<n; j++) {
				System.out.println(arr[0][j]+ " "+ arr[1][j]);
			}
			System.out.println();
			for(int j=0; j<n; j++) {
				System.out.println(dp[0][j]+ " "+ dp[1][j]);
			}
			*/
			System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
		}

	}

}
