package org.study;

import java.util.*;
public class Combination {
/*
 * 조합 : n 개 중에서 r 개 선택
 * 참고 : https://bcp0109.tistory.com/15?category=848939
 * */
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		boolean[] visited = new boolean[arr.length];
		
		/*
		 * 시작 기준점은 인덱스  0 
		 * arr.length개 중에서 
		 * i=1 ; 1개 부터 arr.length개 까지 뽑을 것이다.
		 */
		for(int i=1; i<arr.length; i++)
			combination(arr, visited, 0, arr.length, i);		
	
	}
	
	/*
	 * 백트레킹 사용
	 * combination(뽑을 배열, 뽑혔는지 확인하는 배열, 시작 기준점, n개중, r개 선택)
	 * */
	static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		
		// 뽑기로 한 개수 만큼 다 뽑앗다면 print
		if(r==0) {
			print(arr, visited, n);
			return;
		}
		else {
			// 기준점 인덱스 부터 배열의 끝까지 뒤진다
			for(int i=start; i<n; i++) {
				// 방문 후 true 표시.
				visited[i] = true;						
				
				// i+1; 방문한 인덱스 이 후의 값을 뒤진다 / n개중에 좀 전에 방문 한개 했으므로 r-1개를 뽑는다
				combination(arr, visited, i+1, n, r-1);	
				
				// 방문 완료 후 false 표시.
				visited[i] = false; 					
			}
		}
	}
	
	// 배열 출력
	static void print(int[] arr, boolean[] visited, int n) {
		for(int i=0; i<n; i++) {
			if(visited[i] == true)
				System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}
	
}