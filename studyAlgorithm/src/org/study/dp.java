package org.study;

import java.util.Arrays;
import java.util.Scanner;


public class dp {
	static int[] dp,call;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		dp = new int[n+1];
		Arrays.fill(dp, -1);	// 배열의 모든 요소를 -1로 채우기

		call = new int[n+1];
		org_fibonacci(n);
		int i = 0;
		for(int e:call)
		System.out.println("F("+ i++ +"): "+e+"회 호출");
		
		//System.out.println(fibonacci(n));
		//fibonacci2(n);
		//for(int e:dp)
		//	System.out.print(e+", ");
	}
	
	// 탑 다운
	static int fibonacci(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		// 이미 값을 계산한 적이 있다면 그 값을 바로 리턴
		if(dp[n] != -1) return dp[n];
		// 아니라면 계산해서 dp리스트에 넣어 보존
		dp[n] = fibonacci(n-2) + fibonacci(n-1);
		return dp[n];
	}
	
	// 바텀 업
	static void fibonacci2(int n) {
		Arrays.fill(dp, 0);
		dp[1] = 1;
		for (int i=2; i<=n; i++)
			dp[i] = dp[i-1]+dp[i-2];
		System.out.println(dp[n]);
	}
	
	// dp이용 하지 않은 피보나치 수열
	static int org_fibonacci(int n) {
		call[n]++;
		if(n==0) return 0;
		if(n==1) return 1;
		return org_fibonacci(n-2) + org_fibonacci(n-1);
	}
}
