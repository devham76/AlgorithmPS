package org.baekjoon;

import java.util.Scanner;

public class test2579 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int stair[] = new int[300+1];
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			stair[i] = sc.nextInt();
		}
		
		int sum[] = new int[stair.length];
		
		
		for (int i = 1; i <= 3; i++) {
		    if (i != 3) { //����°���� �������� �ʾ��� ��� 1��° ���  + 2��° ���
		        sum[i] = sum[i-1] + stair[i];
		    }
		    else {	
		    	sum[i] = Math.max(sum[i-2] + stair[i], stair[i] + stair[i-1] );
		    }
		}

		for (int i = 4; i <= n; i++) {
			sum[i] = Math.max(sum[i-3] + stair[i-1] + stair[i], sum[i-2] + stair[i]);
		}
		System.out.print(sum[n]);
	}

}
