package org.study;

import java.util.*;
public class PermutationTest {
	public static void main(String[] args) {
	
		//N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오
		Scanner std = new Scanner(System.in);
		int num = std.nextInt();
		
		int arr[] 			= makeArray(num);		// 원본 배열
		int output[] 		= new int[num]; 		// 결과값 배열
		boolean visited[] 	= new boolean[num]; 	// 방문검사 배열
		perm(arr, output, visited, num, 0, num);	// arr배열에서 num개를 순열로 뽑는다.
	}
	
	//---------------------------
	//-- static의 메인 함수에서 호출하므로 해당 함수도 static이여야 한다.
	//---------------------------
	static int[] makeArray(int num) {
		int[] array = new int[num];
		for (int i=0; i<num; i++) {
			array[i] = i+1;
		}
		return array;
	}
	
	//---------------------------
	/*
	 * num   ; 원본 배열 전체길이
	 * depth ; 현재 노드의 깊이
	 * pick  ; 뽑을 개수  
	 * */
	//---------------------------
	static void perm(int[] arr, int[] output, boolean[] visited, int num, int depth, int pick) {
	
		// 노드의 깊이 , 즉 output의 숫자 개수와 뽑을개수가 같으면 print한다.
		if (depth == pick) {
			print(output, pick);
		}
		
		for (int i=0; i<num; i++) {
			// 해당 숫자를 방문하지 않았다면
			if(visited[i] == false) {
				visited[i] 		= true;			// 방문표시
				output[depth]	= arr[i];		// 결과값 배열의 해당 깊이 자리에 방문하지 않는 원소를 삽입
				// 삽입 후에 한단계 깊은 노드로 이동 하여 output에 값추가
				perm(arr, output, visited, num, depth+1, pick);
				visited[i] 		= false;		// 한단계 깊은 노드 삽입이 끝나고 부모노드로 왔을때 arr[]의 다음 원소를 해당 자리에 넣을수 있다.
			}
		}
	}
	
	//---------------------------
	//-- 배열 원소 프린트 함수
	//---------------------------
	static void print(int[] output, int pick) {
		for (int i=0; i<pick; i++) {
			System.out.print(output[i]+" ");
		}
		System.out.println("");
	}
	
}

