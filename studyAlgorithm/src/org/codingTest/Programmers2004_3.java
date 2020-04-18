package org.codingTest;

import java.util.HashSet;
import java.util.Iterator;

public class Programmers2004_3 {

	public static void main(String[] args) {
		int[] n = { 3, 7, 2, 8, 6, 4, 5, 1 };
		solution(n, 3);
	}

	static int len, k;

	public static int solution(int[] numbers, int K) {
		int answer = 0;
		len = numbers.length;
		k = K;
		int diff_count=0;
		HashSet<Integer> problem = new HashSet<>();
		for (int i = 0; i < numbers.length - 1; i++) {

			// 문제있는 인덱스를 담는다.
			if (Math.abs(numbers[i] - numbers[i + 1]) > K) {
				diff_count++;
				problem.add(i);
				problem.add(i + 1);
			}
		}
		int[] arr = numbers.clone();
		solve(problem, arr, 0, diff_count);
		return answer;
	}

	static int min = 10000000;

	private static void solve(HashSet<Integer> problem, int[] arr, int count, int diff_count) {
		Iterator it = problem.iterator();
		while (it.hasNext()) {
			int idx = (int) it.next();
			int next = (idx + 3) % len;
			
			int[] newArr = swap(idx, next, arr);
			if(count_diff(newArr) == diff_count-1) {
				problem.remove(idx);
				problem.remove(next);	
				solve(problem, arr, 0, diff_count);
				
			}

		}

	}

	private static int[] swap(int idx, int next, int[] arr) {
		int tmp = arr[next];
		arr[next] = arr[idx];
		arr[idx] = arr[next];
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
