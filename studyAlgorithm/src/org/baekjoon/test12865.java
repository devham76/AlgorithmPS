package org.baekjoon;

import java.util.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class test12865 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		// dp[idx][limit] : 0~idx번까지의 물건을 limit 무게까지 넣었을때 최대 가치
		int[][] dp = new int[n + 1][k + 1];
		int[][] product = new int[n + 1][2]; // 0:무게 1:가치
		for (int i = 1; i <= n; i++) {
			int weight = sc.nextInt();
			int value = sc.nextInt();
			product[i][0] = weight;
			product[i][1] = value;
		}

		for (int idx = 1; idx <= n; idx++) {
			for (int limit = 1; limit <= k; limit++) {
				// 현재 물건 전까지 물건들로 limit무게 까지 만들 수 있는 최대 가치 입력
				dp[idx][limit] = dp[idx - 1][limit];
				if (limit >= product[idx][0]) {

					int curWeight = product[idx][0];
					int curValue = product[idx][1];

					// 현재 물건을 넣기 이전의 가치 vs 현재 물건의 가치 + (limit-현재물건의 무게)일때 최대가치
					dp[idx][limit] = Math.max(dp[idx - 1][limit], curValue + dp[idx - 1][limit - curWeight]);
				}
			}

		}
		System.out.println(dp[n][k]);
	}

}
