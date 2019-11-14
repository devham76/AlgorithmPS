package org.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class test2217_greedy_lope {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int[] lope = new int[cnt];
		for (int i = 0; i < cnt; i++)
			lope[i] = sc.nextInt();
		int max = 0, now = 0;
		Arrays.sort(lope);
		for (int i = 0; i < cnt; i++) {
			now = lope[ cnt-1-i] * (i + 1); 
			max = max > now ? max : now;
		}
		System.out.println(max);
	}

}
