package org.baekjoon;

import java.util.Scanner;

public class test1937_dp_panda {
	static int m;
	static int[][] arr, dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		arr = new int[m][m];
		dp = new int[m][m];
		for (int i=0; i<m; i++) {
			for(int j=0; j<m; j++) {
				arr[i][j] = sc.nextInt();
				dp[i][j] = 0;
			}
		}
		
		for (int i=0; i<m; i++) {
			for(int j=0; j<m; j++) {
				fun(i,j);
			}
		}
		
		
		for (int i=0; i<m; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(answer+1);
	}
	static int[] nx = {-1,1,0,0};
	static int[] ny = {0,0,-1,1};
	static int answer = 0;
	public static int fun(int x, int y) {
		if (dp[x][y] > 0) return dp[x][y];
		
		for (int i=0; i<4; i++) {
			int dx = x+nx[i];
			int dy = y+ny[i];
			int newBamboo = 0;
			if (dx<0 || dx>=m || dy<0 || dy>=m)
				continue;
			
			if (arr[x][y] < arr[dx][dy]) {
				newBamboo += fun(dx, dy)+1;
				dp[x][y] = Math.max(dp[x][y], newBamboo);
			}
		}
		answer = Math.max(answer, dp[x][y]);
		return dp[x][y];
	}
}