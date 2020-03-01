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
			// 1��1~N���� ���� ���´�
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
			// row������° ���� ���� ���ʷ� ���� ���´�
			col[row+1] = i;
			if(isPossible(col, row+1)) {
				dfs(col, row+1);
			}
		}
		
	}

	// �ش� ���� ���� ���� �������ִ��� Ȯ���Ѵ�
	private static boolean isPossible(int[] col, int newRow) {
		for(int i=1; i<newRow; i++) {
			// ���� ���� ��� ������ �࿡ ���� ���� ���� ���� �ִ��� Ȯ���Ѵ�
			if(col[i] == col[newRow]) 
				return false;
			
			// ���� ���� ��� ������ �࿡ ���� ���� �밢���� ��ġ�� �ִ��� Ȯ���Ѵ�.
			if(Math.abs(i-newRow) == Math.abs(col[i]-col[newRow]))
				return false;
		}
		return true;
	}

}
