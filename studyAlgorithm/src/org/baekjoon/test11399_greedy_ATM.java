package org.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class test11399_greedy_ATM {
	/*
	5
	3 1 4 3 2
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int peopleNum = sc.nextInt();
		int[] pArr = new int[peopleNum];
		int[] tArr = new int[peopleNum];

		for (int i = 0; i < peopleNum; i++)
			pArr[i] = sc.nextInt();
		
		Arrays.sort (pArr);
		tArr[0] = pArr[0];
		int sum = tArr[0];
		for (int i=1; i< peopleNum; i++ ) {
			tArr[i] = tArr[i-1] + pArr[i];
			sum +=tArr[i];
		}
		System.out.println(sum);
	}

}
