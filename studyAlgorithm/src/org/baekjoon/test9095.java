package org.baekjoon;

import java.util.Scanner;

public class test9095 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int[] answer = new int[testCase];
		int[] dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		int idx=0;
		while (testCase != 0) {
			int num = sc.nextInt();
			for (int i = 4; i <= num; i++)
				dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
			
			answer[idx++] = dp[num];
			--testCase;
		}
		for(int e:answer)
			System.out.println(e);

	}

}
