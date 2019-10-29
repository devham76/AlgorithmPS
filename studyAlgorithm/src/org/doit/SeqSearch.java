package org.doit;

import java.util.Scanner;
/*
 * 
 		선형 검색
 *
 */
public class SeqSearch {
	
	// 요솟수가 n인 배열 a에서 key와 같은 요소를 선형 검색합니다.
	static int seqSearch(int[] a, int n, int key) {
		
		for (int i=0; i<n; i++) {
			if (a[i] == key) return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		
		System.out.println("요솟수 : ");
		int num = std.nextInt();
		int[] x = new int[num];
		
		for (int i=0; i<num; i++) {
			System.out.print("x[" + i +"] : ");
			x[i] = std.nextInt();
		}
		
		System.out.println("검색할 값 : ");
		int ky = std.nextInt();
		
		int idx = seqSearch(x, num, ky);
		
		if(idx == -1)
			System.out.println("검색값을 찾지 못했습니다.");
		else
			System.out.println(ky + "는 x[" + idx + "]에 있습니다.");
	}
}
