package org.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class test2193 {
	static int arr[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		arr = new int[n];
		if (n == 1)
			arr[0] = 1;
		else if (n == 2) 
			arr[1] = 1;
		else { 	
			arr[0] = 1;
			arr[1] = 1;
			for (int i = 2; i < n; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
		}
		System.out.println(arr[n-1]);
	}
}
