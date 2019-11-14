// https://www.acmicpc.net/problem/11047
package org.baekjoon;

import java.util.Scanner;

public class test11047_greedy_coin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int goal = sc.nextInt();
		int[] coin = new int[n]; 
		int answer = 0;
		for (int i=0; i<n; i++)
			coin[i] = sc.nextInt();
		
		for ( int i = n-1; i >= 0; i--) {
			if(goal == 0)
				break;
			if( goal < coin[i])
				continue;
			
			int j = 0;
			while (goal >= coin[i] * j) j++;

			goal -= coin[i]*(j-1);
			answer += (j-1);
				
		}
		System.out.println(answer);
	}

}
