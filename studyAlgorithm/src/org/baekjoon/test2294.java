package org.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class test2294 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coins = new int[n+1];
		int[] dp = new int[k+1];	// 해당 값을 만들기 위해 사용되는 동전의 최소 개수
		for(int i=1; i<=n; i++) {
			coins[i] = sc.nextInt();
		}
		
		// 전체를 최대 값으로 초기화
		Arrays.fill(dp, 10000);
		// 첫번째 동전만 사용해서 해당값을 만들 수 있으면, 사용개수를 입력한다.
		for(int price=1; price<=k; price++) {
			if(price % coins[1] == 0)
				dp[price] = price/coins[1];
		}
		// 0을 만들기 위해선 0개의 동전이 필요.
		dp[0] = 0;
		// 첫번째 + 2,3,...n번째 동전을 이용할때 최소 사용개수
		for(int coinIdx=2; coinIdx<=n; coinIdx++) {
			for(int price=1; price<=k; price++) {
				if(price >= coins[coinIdx]) {
					dp[price] = Math.min(dp[price] , dp[price - coins[coinIdx]]+1);
				}
			}
		}
		
		// 해당 값을 만들지 못했을때
		if(dp[k] == 10000)
			System.out.println(-1);
		else
			System.out.println(dp[k]);

	}

}
