package org.baekjoon;

import java.util.Scanner;

public class test1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int[] dp = new int[num+1];
		dp[1] = 0;
		for (int i=2; i<num+1; i++) {
			dp[i] = dp[i-1]+1;
			// �ش� ���ڰ� 2�� �����������ٸ�, 2�γ����ų�, -1�ϴ� ��� �ΰ������ִ� 
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i-1]+1, dp[i/2]+1);
			else if (i % 3 == 0)
				dp[i] = Math.min(dp[i-1]+1, dp[i/3]+1);

		}
		System.out.println(dp[num]);
	}	
}
