package org.baekjoon;

import java.util.Scanner;

public class test1520_dp_downhill {

	static int m,n;
	static int[][] arr,dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		arr = new int[m][n];
		dp = new int[m][n];
		for (int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
				dp[i][j] = -1;
			}
		}
		
		// 높이지도, 현재 위치 x,y
		fun(0, 0);
		System.out.println("->"+dp[0][0]);
		
		for (int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static int[] nx = {1,-1,0,0};
	static int[] ny = {0,0,1,-1};
	public static int fun(int x, int y) {

		if (x == (m-1) && y == (n-1)) {
			return 1;
		}
		if (dp[x][y] > -1) {
			return dp[x][y];
		}
		
		int result = 0;
		for (int i=0; i<4; i++) {

			if(x+nx[i] < 0 || x+nx[i] >= m || y+ny[i] < 0 || y+ny[i] >=n) 
				continue;
			if(arr[x+nx[i]][y+ny[i]] < arr[x][y])
				result += fun(x+nx[i], y+ny[i]);
		}
		
		return dp[x][y]=result;
	}

}
