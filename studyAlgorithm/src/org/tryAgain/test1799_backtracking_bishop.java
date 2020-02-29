다시 , 백트레킹 boj
package org.tryAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1799_backtracking_bishop {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][N];
		for( int i=0;i <N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for( int j=0;j <N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int sum=0;
		int[] dx = {-1,-1,1,1};
		int[] dy = {-1,1,-1,1};
		for( int i=0;i <N; i++) {
			
			for( int j=0;j <N; j++) {
				if(arr[i][j] != 1)
					continue;
				
				sum++;
				arr[i][j] = 0;
				for(int k=0; k<N; k++) {
					for(int l=0; l<4; l++) {
						int nx = i+(dx[l]*k);
						int ny = j+(dy[l]*k);
						// 범위 넘어가면 무시
						if(nx < 0 || nx >=N || ny < 0|| ny >= N)
							continue;
						
						arr[nx][ny] = 2;
						
					}
				}
			}
		}
		System.out.println(sum);
	}

}
