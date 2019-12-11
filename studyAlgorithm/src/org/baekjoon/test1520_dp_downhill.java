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

		// 목적지 도착했으면 경우의 수 1 반환
		if (x == (m-1) && y == (n-1)) {
			return 1;
		}
		
		// !!! 내가 틀린 지점 !!!
		// 이미 목적지까지 도착한 경로 이라면 해당 경로의 수 반환
		if (dp[x][y] > -1) {
			return dp[x][y];
		}
		
		int result = 0;
		for (int i=0; i<4; i++) {

			// 지도 밖으로 나가면 끝.
			if(x+nx[i] < 0 || x+nx[i] >= m || y+ny[i] < 0 || y+ny[i] >=n) 
				continue;
			
			// 다음 이동지역이 현재보다 낮다면 이동
			if(arr[x+nx[i]][y+ny[i]] < arr[x][y]) {
				// !!! 내가 틀린 지점 !!! , 이미 목적지까지 도착한 경로가 있으면 메모이제이션기법으로 저장해줘야 한다.
				// 목적지까지 도착했을경우 1 ( + 이미 목적지까지 도착한 경로가 있다면 해당 경로도 추가 )
				result += fun(x+nx[i], y+ny[i]);
			}
		}
		
		return dp[x][y] = result;
	}

}
