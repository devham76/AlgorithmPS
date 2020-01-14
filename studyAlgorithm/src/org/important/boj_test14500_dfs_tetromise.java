// https://www.acmicpc.net/problem/14500 
// 구현하기 어려운 문제는 아니였지만 문제를 해결하는 방법이 어려웠다
package org.important;

import java.util.Arrays;
import java.util.Scanner;

public class boj_test14500_dfs_tetromise {
	static int[][] board;
	static boolean[][] visited;
	static int N,M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N][M];
		visited = new boolean[N][M];
		for (int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		for (int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				dfs1(i,j,0,0);	// 해당 좌표를 방문했다고 표시하지 않으므로 i,j,0,0로해야함 !! 조심 !
				dfs2(i,j);
			}
		}
		System.out.println(max);
	}
	static int max = 0;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	// ㅗ 를 제외한 나머지는 dfs로 처리가능하다
	static void dfs1(int x, int y, int result, int depth) {
		if(depth == 4) {
			max = Math.max(max, result);
			return;
		}
		
		// 해당좌표에서 상하좌우 확인하여 방문안한곳에 방문한다
		for(int i=0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			// 범위 벗어남
			if(nx <0 || nx >=N || ny<0 || ny >=M)
				continue;
			// 이미방문했음
			if(visited[nx][ny] == true)
				continue;
			
			visited[nx][ny] = true;
			dfs1(nx, ny, result+board[nx][ny], depth+1);
			visited[nx][ny] = false;
		}
	}
	
	static void dfs2(int x, int y) {
		int outNum=0;	// 범위를 벗어난 영역개수
		int[] nums = new int[4];
		for(int i=0; i<4; i++) {
			if(outNum >= 2) // 범위를 벗어난 영역개수가 2개이상 이면 못구하므로 나간다
				return;
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if(nx <0 || nx >=N || ny<0 || ny >=M) {
				++outNum;
				continue;
			}
			nums[i] = board[nx][ny];
		}
		Arrays.sort(nums);
		int result = board[x][y];
		for(int i=3; i>0; --i) {
			result += nums[i];	// 큰거 세개만 더한다
			//System.out.println("result: "+result);
		}
		max = Math.max(max, result);
		
	}

}
