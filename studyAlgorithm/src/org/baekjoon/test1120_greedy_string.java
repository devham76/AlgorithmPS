package org.baekjoon;

import java.util.Scanner;

public class test1120_greedy_string {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int diff = s2.length() - s1.length();
		if (diff == 0) {
			int min = 0;
			for (int j = 0; j < s1.length(); j++) {
				if (s1.charAt(j) != s2.charAt(j))
					min++;
			}
			System.out.println(min);
			return ;
		}
		
		int min = s1.length();
		for (int i = 0; i <= diff; i++) {
			int cnt = 0;
			for (int j = 0; j < s1.length(); j++) {
				if (s1.charAt(j) != s2.charAt(i+j))
					cnt++;
			}
			min = min < cnt ? min : cnt;
		}
		System.out.println(min);
	}

}
