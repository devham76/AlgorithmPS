	package org.baekjoon;

import java.util.Scanner;

public class test11058 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = N;
		int[] dp = new int[N+1];
		for(int i=1; i<7; i++)
			dp[i] = i;
		
		if(N >= 7) {
			
			for(int given=7; given <=N ; given++) {
				// j가 3인이유
				// 전체선택, 복사, 붙여넣기를 하려면 최소 3번이 남아야 한다.
				for(int remain=3; remain<=given; remain++) {	
					int printed = dp[given-remain];
					int buffer = dp[given-remain];	// 프린트 된 만큼 버퍼에있다
					int V_count = remain-2; // 남은 버튼의 개수 - (전체선택, 복사) = 붙여넣기 가능한 횟수
					dp[given] = Math.max(dp[given], printed + buffer*V_count);
				}	
			}
		}
		System.out.println(dp[N]);

	}

}
