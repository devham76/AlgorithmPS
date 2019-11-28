// ½ÇÆÐ ;;;;
package org.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class test11053_dp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];

		for (int i = 0; i < arr.length; i++) 
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		int answer = 0, before = 0;
		for (int i = 0; i < arr.length; i++) {
			if (before < arr[i]) {
				++answer;
				before = arr[i];
			}
		}
		System.out.println(answer);
	}

}
