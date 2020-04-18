package org.codingTest;

import java.util.HashSet;
import java.util.Iterator;

public class p_3_1 {

	public static void main(String[] args) {
		int[] n = { 3, 7, 2, 8, 6, 4, 5, 1 };
		//solution(n, 3);
	}

	static int len, k;
	static int min = 10000000;

	public  int solution(int[] numbers, int K) {
		int answer = 0;
		len = numbers.length;
		k = K;

		solve(numbers, count_diff(numbers), 0);

		System.out.println(min);
		return answer;
	}

	private static void solve(int[] number, int diff_count, int count) {

		if (diff_count == 0) {
			min = Math.min(min, count);

		}

		for (int i = 0; i < number.length - 1; i++) {

			if (Math.abs(number[i] - number[i + 1]) > k) {
				int next = (i + 3) % len;
				
				while ( next != i) {

					// 둘이 바꾼 배열
					int[] newArr = number.clone();
					newArr = swap(i, next, newArr);
					// 이전보다 개수가 작아진다면
					int newdiff = count_diff(newArr);

					for (Integer n : newArr) {
						System.out.print(n + " ");
					}
					System.out.println();
					if (newdiff < diff_count) {
						solve(newArr, newdiff, count + 1);
					}
					next = (next+1) % len;
				}

			}
		}
	}

	private static int[] swap(int idx, int next, int[] arr) {
		int tmp = arr[next];
		arr[next] = arr[idx];
		arr[idx] = tmp;
		return arr;
	}

	private static int count_diff(int[] arr) {
		int cnt = 0;

		for (int i = 0; i < arr.length - 1; i++) {

			if (Math.abs(arr[i] - arr[i + 1]) > k) {
				cnt++;
			}
		}
		return cnt;
	}

}
