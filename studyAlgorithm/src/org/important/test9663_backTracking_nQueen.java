package org.important;

import java.util.Scanner;

public class test9663_backTracking_nQueen {

	static int count=0;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=1; i<=N; i++) {
			int[] col = new int[N+1];
			// 1행1~N열에 말을 놓는다
			col[1] = i; 
			dfs(col, 1);
		}
		System.out.println(count);
	}

	private static void dfs(int[] col, int row) {
		
		if(row == N) {
			count++;
			return;
		}
		
		for(int i=1; i<=N; i++) {
			// row다음번째 행의 열에 차례로 말을 놓는다
			col[row+1] = i;
			if(isPossible(col, row+1)) {
				dfs(col, row+1);
			}
		}
		
	}

	// 해당 행의 열에 말을 놓을수있는지 확인한다
	private static boolean isPossible(int[] col, int newRow) {
		for(int i=1; i<newRow; i++) {
			// 새로 놓을 행과 이전의 행에 놓인 말이 같은 열에 있는지 확인한다
			if(col[i] == col[newRow]) 
				return false;
			
			// 새로 놓을 행과 이전의 행에 놓인 말이 대각선에 위치해 있는지 확인한다.
			if(Math.abs(i-newRow) == Math.abs(col[i]-col[newRow]))
				return false;
		}
		return true;
	}

}
