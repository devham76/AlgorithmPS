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
		Arrays.fill(dp, -1);	// �迭�� ��� ��Ҹ� -1�� ä���

		call = new int[n+1];
		org_fibonacci(n);
		int i = 0;
		for(int e:call)
		System.out.println("F("+ i++ +"): "+e+"ȸ ȣ��");
		
		//System.out.println(fibonacci(n));
		//fibonacci2(n);
		//for(int e:dp)
		//	System.out.print(e+", ");
	}
	
	// ž �ٿ�
	static int fibonacci(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		
		if(dp[n] != -1) return dp[n];
		
		dp[n] = fibonacci(n-2) + fibonacci(n-1);
		return dp[n];
	}
	
	// ���� ��
	static void fibonacci2(int n) {
		Arrays.fill(dp, 0);
		dp[1] = 1;
		for (int i=2; i<=n; i++)
			dp[i] = dp[i-1]+dp[i-2];
		System.out.println(dp[n]);
	}
	
	// dp�̿� ���� ���� �Ǻ���ġ ����
	static int org_fibonacci(int n) {
		call[n]++;
		if(n==0) return 0;
		if(n==1) return 1;
		return org_fibonacci(n-2) + org_fibonacci(n-1);
	}
}
