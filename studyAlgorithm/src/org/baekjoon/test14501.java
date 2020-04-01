// 15486, 14501
package org.baekjoon;

import java.util.Scanner;

public class test14501 {

	static int N, max;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			arr[i][0] = sc.nextInt(); // T
			arr[i][1] = sc.nextInt(); // P
		}
		max = 0;

		
		//-- brute force
		// solve(1, 0); 
		
		//-- dp
		int[] dp = new int[N + 2];
		//-- 1. brute force 방법을 그대로 이용
		for (int day = 1; day <= N; day++) {
			int nextDay = day + arr[day][0];
			if (nextDay - 1 <= N) {
				dp[nextDay] = Math.max(dp[day] + arr[day][1], dp[nextDay]);
			}
			dp[day + 1] = Math.max(dp[day + 1], dp[day]);
		}
		// 마지막 날 전 까지 일했거나 , 마지막날에도 일했을때
		max = Math.max(dp[N + 1], dp[N]);
		
		//-- 2. dp[day] : day전날까지 일했을때 제일 큰 pay
		dp = new int[N + 2];
		max = 0;
		for (int day = 1; day <= N; day++) {
			max = Math.max(max, dp[day]);
			
			int nextDay = day + arr[day][0];
			if (nextDay - 1 <= N) {
				// 오늘도 일했을때 값 vs 오늘안하고 내일 일했을때 값
				dp[nextDay] = Math.max( max + arr[day][1], dp[nextDay]);
			}
		}		
		
		System.out.println(max);

	}

	private static void solve(int today, int totalPay) {

		max = Math.max(max, totalPay);

		if (today > N) {
			return;
		}

		// 오늘 받은 일을 해본다.
		// 당일에 1일치 일을 할수있으므로 -1을 해준다.
		// N=10, today=10, arr[10][0] = 1이라면
		// 10일에 1일치 일을 할수있다.
		if (today + arr[today][0] - 1 <= N) {
			solve(today + arr[today][0], totalPay + arr[today][1]);
		}

		// 오늘 받은일을 하지 않는다.
		solve(today + 1, totalPay);

	}

}
