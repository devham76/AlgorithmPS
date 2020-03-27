package org.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class test10942_pailndrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		for (int i = 1; i < n + 1; i++)
			arr[i] = sc.nextInt();
		int m = sc.nextInt();

		int[] dp = new int[n];
		while (m-- > 0) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int mid = (start + end) / 2;

			if (start == end) {
				System.out.println(1);
				continue;
			}

			if (dp[mid] == 0) {

				for (int newstart = mid - 1; newstart > 0; newstart--) {
					int newend = mid + (mid - newstart);
					if (newend > n)
						break;

					if (arr[newstart] == arr[mid + (mid - newstart)])
						dp[mid] = newstart;
					else
						break;
				}
				// 
				if(dp[mid] == 0) {
					dp[mid] = mid;
					System.out.println(0);
					continue;
				}

			}
			
			if(dp[mid] > start)
				System.out.println(0);
			else
				System.out.println(1);

		}

	}

}
