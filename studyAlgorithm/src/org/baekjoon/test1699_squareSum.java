// -- �ٽ� Ǯ��
package org.baekjoon;

import java.util.Scanner;

public class test1699_squareSum {

	public static void main(String[] args) {
		private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		public static void main(String args[]) throws IOException { 
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); int N = Integer.parseInt(br.readLine()); int dp[] = new int[N + 2]; dp[1] = 1; for (int i = 2; i <= N; i++) { dp[i] = Integer.MAX_VALUE; for (int j = 1; j * j <= i; j++) { if (i == j * j) { dp[i] = 1; break; } dp[i] = Math.min(dp[i - j * j] + dp[j * j], dp[i]); } } bw.write(String.valueOf(dp[N])); bw.flush(); }
		}

		��ó: https://ksh-code.tistory.com/326 [�˰����� �����ϴ� ��]

		��ó: https://ksh-code.tistory.com/326 [�˰����� �����ϴ� ��]

}
