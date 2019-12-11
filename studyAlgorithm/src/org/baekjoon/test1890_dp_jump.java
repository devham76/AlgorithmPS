package org.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test1890_dp_jump {

	static int[] nx = {1,0};
	static int[] ny = {0,1};
	static int N;
	static int[][] arr = new int[101][101];
	static long[][] dp = new long[101][101];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		String str[];
		for (int i=0; i<N; i++) {
			str = br.readLine().split(" ");
	        for (int j = 0; j < N; j++) {
	            arr[i][j] = Integer.parseInt(str[j]);
				dp[i][j] = -1;
			}
		}
		
		System.out.println( fun(0,0) );
	}

	public static long fun(int x, int y) {
		
		// 목적지에 도착 시 경우의 수 1반환
		if(x == N-1 && y == N-1)
			return 1;
		
		// 이 지점 부터 목적지까지 가는 경로의 개수가 있다면 해당 경로의 개수 반환.
		// -> 이 지점 부터 목적지까지는 가는 경로의 개수가 이미 있기 때문에 또 다시 경로의 개수를 세어줄 필요 없이 바로 사용
		if (dp[x][y] > -1)
			return dp[x][y];
		
		// 이 지점에서 목적지까지 갈 수 있는 경우의 수
		dp[x][y] = 0;
		for (int i=0; i<2; i++) {
			int nextX = x + ( arr[x][y] * nx[i] );
			int nextY = y + ( arr[x][y] * ny[i] );
			
			// 이 지점에서 목적지까지 오른쪽 또는 아래쪽으로 이동해서 갈 수 있으므로 그 경우를 모두 더한다
			dp[x][y] += fun(nextX, nextY);
		}
		
		// 경로의 개수를 dp배열에 저장 , 메모이제이션 기법 사용
		return dp[x][y];
	}
}
