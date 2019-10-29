package org.study;

import java.util.*;
/*
 *  순열 : n 개 중에서 r개 선택
 *  시간복잡도는 O(n!)
 *  연습 문제 : https://www.acmicpc.net/problem/10974
 */

public class Permutation {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int[] output = new int[arr.length];
		boolean[] visited = new boolean[arr.length];
		perm(arr, output, visited, 0, arr.length, 3);
		
	}
	
	// 순서를 지키면서 n개중 r개를 뽑는 경우
	// 사용 예시 : perm(arr, output, visited, 0, n, 3);
	static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		
		//- 현재 깊이는 뽑은 개수이다
		//- 즉, 뽑은 개수와 뽑을 개수가 같다면 종료.
		if(depth == r) {
			print(output,r);
			return;
		}
		
		// 1. 모든 원소를 순회한다.
		for (int i=0; i<n; i++) {
			// 2. 방문하지 않은 원소를 찾는다
			if(visited[i] != true) {
				visited[i] 		= true;		// 방문표시를 한다
				output[depth] 	= arr[i];	// 결과값 배열의 해당깊이 위치에 방문하지 않은 원소 값 대입
				perm(arr, output, visited, depth+1, n, r);
				visited[i] 		= false;
			}
		}
	}
	
	// 배열 출력
	static void print(int[] arr, int r) {
        for(int i=0; i<r; i++)
            System.out.print(arr[i] + " ");
		System.out.println();
	}
}
