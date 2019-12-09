package org.baekjoon;

import java.util.Scanner;

public class test2133_dp_fillTile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] dp = new int[num+1];
		dp[0] = 1;
		dp[3] = 3;
		
		if(num % 2 == 0) {
		for (int i = 2; i <= num; i += 2) {
			dp[i] = dp[i - 2] * 3;
			// 길이가 2씩 늘어날때마다 2가지 경우가 계속 추가되는 것을 반영해줘야 문제를 해결할 수 있다.
			for (int j = 4; j <= i; j += 2) dp[i] += dp[i - j] * 2;
		}
		}
		System.out.println(dp[num]);
	}

}
