package org.baekjoon;

import java.util.Scanner;

public class test11054_dp_Lis {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp1 = new int[n];
		int[] dp2 = new int[n];
		int max = 0;
		int[] arr = new int[n];
		
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			dp1[i] = 1;
			dp2[i] = 1;
		}

		for (int i=1; i<n; i++) {
			for (int j=0; j<i; j++) {
				if (arr[i] > arr[j]) {
					dp1[i] = Math.max(dp1[j]+1, dp1[i]);
				}
			}
		}
		for (int i=n-2; i>=0; i--) {
			for (int j=i+1; j<n; j++) {
				if (arr[i] > arr[j]) {
					dp2[i] = Math.max(dp2[j]+1, dp2[i]);
				}
			}
		}
		
		for (int i=0; i<n; i++) {
			max = Math.max(dp1[i] + dp2[i], max);
		}
		System.out.println(max-1);
		
	}

}
