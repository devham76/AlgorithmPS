package org.baekjoon;

import java.util.Scanner;

public class test1520 {
	static int m,n;
	static int[][] arr;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		arr = new int[m][n];
		dp = new int[m][n];
		for (int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		
	}
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	private static int recur(int x, int y) {
		if(x ==(m-1) && y == (n-1)) {
			return 1;
		}
		
		if(dp[x][y] > 0) {
			return dp[x][y];
		}
		int result = 0;
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx < 0 || nx >=m || ny <0 || ny >=n)
				continue;
			
			
			if(arr[x][y] > arr[nx][ny]) {
				
				//System.out.println(nx+" ,"+ny);
				result += recur(nx,ny);
			}
		}
		dp[x][y] = result;
		return dp[x][y];
	}

}
