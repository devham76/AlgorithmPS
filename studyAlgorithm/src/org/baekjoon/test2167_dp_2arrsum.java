package org.baekjoon;

import java.util.Scanner;

public class test2167_dp_2arrsum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n+1][m+1];
		for (int i=1; i<n+1; i++) {
			for (int j=1; j<m+1; j++)
				arr[i][j] = sc.nextInt();
		}
		int testCase = sc.nextInt();
		for (int i =0; i < testCase; i++) {
			findSum(arr, sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
	}
	public static void findSum(int[][] arr, int x1, int y1, int x2, int y2) {
		int sum = 0;
		for (int i=x1; i<=x2; i++) {
			for (int j=y1; j<=y2; j++)
				sum += arr[i][j];
		}
		System.out.println(sum);
	}
}
