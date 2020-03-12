//https://m.blog.naver.com/PostView.nhn?blogId=occidere&logNo=220876138317&proxyReferer=https%3A%2F%2Fwww.google.com%2F
// https://www.acmicpc.net/problem/1010
package org.baekjoon;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class test1010 {

	static int n,m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseT = sc.nextInt();
		while (caseT > 0) {
			caseT--;
			int n = sc.nextInt();
			int m = sc.nextInt();
			int sum=0;
			int[][] dp = new int[n+1][m+1]; // 
			
			// n이 1이면 m까지 총 m개의 다리를 건설할수있다.
			for(int i=1; i<=m; i++) 
				dp[1][i] = i;
			
			// dp[3][5] = dp[2][4] + dp[2][3] + dp[2][2]
			// dp[2][4] = dp[1][3] + dp[1][2] + dp[1][1]
			for(int i=2;i<=n;i++)	// 첫째마을
				for(int j=i; j<=m; j++) // 둘째마을
					for(int k=j;k>=i;k--)
						dp[i][j]+=dp[i-1][k-1];
				
			
			System.out.println(dp[n][m]);
		}
		
	}


}
