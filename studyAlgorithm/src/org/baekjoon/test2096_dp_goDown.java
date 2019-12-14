package org.baekjoon;

import java.util.Scanner;

public class test2096_dp_goDown {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[][] arr = new int[num][3];
		int[][] dpmin = new int[num][3];
		int[][] dpmax = new int[num][3];
		int min = 1000000000;
		int max = 0;
		
		for (int i=0; i<num; i++) {
			for (int j=0; j<3; j++) {
				arr[i][j] = sc.nextInt();
				
				if (i==0) {
					dpmin[i][j] = arr[i][j];
					dpmax[i][j] = arr[i][j];
				}
				else {
					int newmin=0;
					int newmax=0;
					if(j==0) {
						dpmin[i][j] = Math.min(dpmin[i-1][j], dpmin[i-1][j+1]) + arr[i][j];
						dpmax[i][j] = Math.max(dpmax[i-1][j], dpmax[i-1][j+1]) + arr[i][j];
					}
					else if (j==1) {
						dpmin[i][j] = Math.min( Math.min(dpmin[i-1][j-1], dpmin[i-1][j]), dpmin[i-1][j+1]) + arr[i][j];
						dpmax[i][j] = Math.max( Math.max(dpmax[i-1][j-1], dpmax[i-1][j]), dpmax[i-1][j+1]) + arr[i][j];
					}
					else if (j==2) {
						dpmin[i][j] = Math.min(dpmin[i-1][j-1], dpmin[i-1][j]) + arr[i][j];
						dpmax[i][j] = Math.max(dpmax[i-1][j-1], dpmax[i-1][j]) + arr[i][j];
					}
				}
			}
			min = Math.min( Math.min(dpmin[num-1][0], dpmin[num-1][1]), dpmin[num-1][2]);
			max = Math.max( Math.max(dpmax[num-1][0], dpmax[num-1][1]), dpmax[num-1][2]);
		}
		
		System.out.println(max+ " "+ min);
/*
		for (int i=1; i<num; i++) {
			for (int j=0; j<3; j++) {
				System.out.print(dpmin[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i=1; i<num; i++) {
			for (int j=0; j<3; j++) {
				System.out.print(dpmax[i][j]+" ");
			}
			System.out.println();
		}
		*/
	}
	

}
