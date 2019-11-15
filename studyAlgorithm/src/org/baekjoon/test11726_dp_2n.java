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
			// ���⼭ 10007 ����������� ���� ������, ������ dp[i] �� ���� ���� Ʋ���������� ������ dp[i]�� ���� �� ���� 10007�� ����������� ���� �Ŀ� ����
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] %= 10007;
		}
		System.out.println(dp[num]);
		

	}

}