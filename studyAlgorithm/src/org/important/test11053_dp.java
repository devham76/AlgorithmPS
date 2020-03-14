// LTS 문제 !!!
package org.important;

import java.util.Arrays;
import java.util.Scanner;

public class test11053_dp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];

		for (int i = 0; i < arr.length; i++) 
			arr[i] = sc.nextInt();

		// 부분수열을 만들어서 넣어줄 배열
		int[] tailTable = new int[arr.length];
		tailTable[0] = arr[0];	// 빈 배열에 첫번째 요소 추가
		int tailIdx = 0;		// 꼬리의 index
		
		for(int i=1; i<arr.length; i++) {   
			// 넣을 요소가 꼬리요소 보다 크다면 삽입
			if(arr[i] > tailTable[tailIdx]) {
				tailTable[++tailIdx] = arr[i];
			}
			// 넣을 요소가 꼬리요소 보다 작으면, 요소들중에서 자기보다 큰것중 가장 작은것과 교환
			else{
				int insertIdx = Arrays.binarySearch(tailTable, 0, tailIdx, arr[i]);
				// 0보다 크거나 같을 경우는, 요소가 이미 있을 경우이다. 
				insertIdx = insertIdx >= 0 ? insertIdx : -(insertIdx) -1;
				tailTable[insertIdx] = arr[i];
				
			}
		}
		
		System.out.println(tailIdx+1);
			
	}

}
