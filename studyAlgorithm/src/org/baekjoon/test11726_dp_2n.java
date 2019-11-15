package org.baekjoon;

import java.util.Scanner;

public class test11726_dp_2n {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] dp = new int[num+1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= num; i++) {
			// 여기서 10007 나머지계산을 하지 않으면, 이전의 dp[i] 도 값이 전부 틀려져버리기 때문에 dp[i]을 구할 때 마다 10007의 나머지계산을 진행 후에 저장
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] %= 10007;
		}
		System.out.println(dp[num]);
		

	}

}
