package org.baekjoon;

import java.io.*;
import java.util.*;

public class test5557 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		long[][] dp = new long[n-1][21]; // 0~20까지 허용
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int result = arr[n - 1];

		dp[0][arr[0]] = 1;
		for (int i = 1; i < n-1; i++) {
			for (int j = 0; j <= 20; j++) {
				if (dp[i - 1][j] > 0) {
					int num1 = j + arr[i];
					int num2 = j - arr[i];

					if (num1 <= 20)
						dp[i][num1] += dp[i - 1][j];
					if (num2 >= 0)
						dp[i][num2] += dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[n-2][result]);

	}

}
