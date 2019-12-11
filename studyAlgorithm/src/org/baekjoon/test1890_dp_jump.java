package org.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test1890_dp_jump {

	static int[] nx = {1,0};
	static int[] ny = {0,1};
	static int N;
	static int[][] arr = new int[101][101];
	static long[][] dp = new long[101][101];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		String str[];
		for (int i=0; i<N; i++) {
			str = br.readLine().split(" ");
	        for (int j = 0; j < N; j++) {
	            arr[i][j] = Integer.parseInt(str[j]);
				dp[i][j] = -1;
			}
		}
		
		System.out.println( fun(0,0) );
	}

	public static long fun(int x, int y) {
		
		// �������� ���� �� ����� �� 1��ȯ
		if(x == N-1 && y == N-1)
			return 1;
		
		// �� ���� ���� ���������� ���� ����� ������ �ִٸ� �ش� ����� ���� ��ȯ.
		// -> �� ���� ���� ������������ ���� ����� ������ �̹� �ֱ� ������ �� �ٽ� ����� ������ ������ �ʿ� ���� �ٷ� ���
		if (dp[x][y] > -1)
			return dp[x][y];
		
		// �� �������� ���������� �� �� �ִ� ����� ��
		dp[x][y] = 0;
		for (int i=0; i<2; i++) {
			int nextX = x + ( arr[x][y] * nx[i] );
			int nextY = y + ( arr[x][y] * ny[i] );
			
			// �� �������� ���������� ������ �Ǵ� �Ʒ������� �̵��ؼ� �� �� �����Ƿ� �� ��츦 ��� ���Ѵ�
			dp[x][y] += fun(nextX, nextY);
		}
		
		// ����� ������ dp�迭�� ���� , �޸������̼� ��� ���
		return dp[x][y];
	}
}
