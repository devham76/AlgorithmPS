package org.baekjoon;

import java.util.Scanner;

public class test2156_wine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] wineArr = new int[10000];
		
		for (int i=0; i<size; i++)
			wineArr[i] = sc.nextInt();
		
		System.out.println( findMax(wineArr, size) );
	}
	static int findMax(int[] wineArr, int size) {
		int sum = 0;
		
		int[] maxArr = new int[size];
		
		maxArr[0] = wineArr[0];
		maxArr[1] = wineArr[0]+wineArr[1];
		maxArr[2] = Math.max(wineArr[0]+wineArr[1], wineArr[1]+wineArr[2]);
		if (size > 3) {
			for( int i=3; i<size; i++) {
				maxArr[i] = Math.max(wineArr[i]+wineArr[i-1]+maxArr[i-3], wineArr[i-1]+maxArr[i-2]);
			}
		}
		
		for (int i=0; i<size; i++)
			System.out.print(wineArr[i]+" ");
		System.out.println();
		for (int e:maxArr)
			System.out.print(e+ " ");
		System.out.println();
		
		return maxArr[size-1];
	}

}
