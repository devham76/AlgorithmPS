package org.baekjoon;

import java.util.Scanner;

public class test2294_dp_coin2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = sc.nextInt();
		int[] coins = new int[num];
		for (int i=0; i<num; i++)
			coins[i] = sc.nextInt();

		int answer = 0;
		while (sum > 0) {
			int is_exist = 0;
			for (int i=num-1; i >= 0; i--) {
				if (sum >= coins[i]) {
					is_exist = 1;
					sum -= coins[i];
					break;
				}
			}
			answer++;
			if ( is_exist == 0) {
				answer = -1;
				break;
			}
		}
		System.out.println(answer);

	}

}
