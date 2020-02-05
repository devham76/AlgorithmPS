package org.baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class test1946_greedy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int test=0; test<testCase; test--) {
			int num = sc.nextInt();
			int[] arr = new int[num+1];
			for(int i=0; i< num; i++) {
				arr[sc.nextInt()] = sc.nextInt();
			}
			
			int answer=1;
			int pre = arr[1];
			for(int i=2; i<arr.length; i++) {
				if(arr[i] < pre) {
					pre = arr[i];
					++answer;
				}
			}
			System.out.println(answer);
			testCase--;
		}
	}
	
}
