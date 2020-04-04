/*
 * 이분탐색 (binary search)
 * 정렬되어있는 배열에서 찾을 수를 하나씩  찾는게 아니라, 탐색 범위를 절반으로 줄여서 찾는것.
 * */

package org.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class test1654 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 가지고 있는 수
		int k = sc.nextInt(); // 만들어야 하는 수
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		long max = arr[k - 1];
		long min = 1; // 제일 작은 수는 자연수이므로 1
		long middle = 0;

		while (max >= min) {
			middle = (max + min) / 2;
			long count = 0;
			for (int i = 0; i < n; i++) {
				count += arr[i] / middle;
			}

			
			if (count >= n) {		// 잘라서 만든 개수가 원하는 개수보다 크거나 같으면, 랜선값 크게한다. 그래야 적게 자름
				min = middle + 1;
			} else if (count < n) {	// 잘라서 만든 개수가 원하는 개수보다 작으면, 랜선값 작게한다. 그래야 많이 자름
				max = middle - 1;
			}

		}
		System.out.println(max);
	}

}
