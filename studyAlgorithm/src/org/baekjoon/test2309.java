package org.baekjoon;

import java.util.*;

public class test2309 {
	
	static int is_finish = 0;
	public static void main(String[] args) {
		// 풀이 : 9개 중에 7개를 뽑아 100이 되는 조합을 찾자
		int[] arr = {20, 5, 26, 18, 10, 14, 25, 8, 13};
		
		/*Scanner std = new Scanner(System.in);
		int[] arr = new int[9];
		for (int i=0; i<9; i++ )
			arr[i] = std.nextInt();
		*/
		// 1. 퀵정렬로 정렬
		sort(arr, 0, arr.length-1);
		
		// 2. 조합검색
		boolean visited[] = new boolean[9];
		combination(arr, visited, 0, 9, 7);
		
	}
	
	//-- 조합, start를 기준으로 n개중에 r개를 뽑는 숫자 조합
	static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		// r개를 모두 뽑았다면 그들의 합이 100이 되는지 검사.
		if(is_finish != 1 ) {
		if(r == 0) {
			check(arr, visited, n);
		}
		else {
			for( int i=start; i < n; i++) {
				visited[i] = true;
				combination(arr, visited, i+1, n, r-1);
				visited[i] = false;
			}
		}
		}
	}
	//-- 그들의 합이 100이 되는지 검사
	static void check(int[] arr, boolean[] visited, int n) {
		int sum = 0;
		 Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i<n ; i++) {
			if( visited[i] == true) {
				sum += arr[i];
				q.add(arr[i]);
			}
		}
		
		
		// 합이 100이면 원소 출력
		if(sum == 100) {
			while(!q.isEmpty())
				System.out.println(q.poll());
			
			is_finish = 1;
		}	
		
	}
	//-- 퀵정렬
	static void sort(int[] arr, int left, int right) {
		int pl = left, pr = right;
		int pivot = arr[ (pl+pr) / 2];
		do {
			while(arr[pl] < pivot) pl++;
			while(arr[pr] > pivot) pr--;
			if(pl <= pr)
				swap(arr, pl++, pr--);
		}while (pl <= pr);
		
		if(left < pr)  sort(arr, left, pr);
		if(pl < right) sort(arr, pl, right);
	}
	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1]; a[idx1] = a[idx2]; a[idx2] = tmp;
	}
}
