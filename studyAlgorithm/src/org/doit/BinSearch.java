package org.doit;
import java.util.Scanner;

public class BinSearch {

	static int binSearch(int[] a, int n, int key) {
		int pl = 0; 		// 검색 범위의 첫 인덱스
		int pr = n - 1;		// 검색 범위의 끝 인덱스
		
		do {
			int pc = ( pl + pr ) / 2;
			if (a[pc] == key)
				return pc;		// 검색성공
			else if (a[pc] < key)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while (pl <= pr);
		
		return -1; 				// 검색실패
	}
	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
	
		System.out.println("요솟수 : ");
		int num = std.nextInt();
		int[] x = new int[num];
		
		System.out.println("오름차순으로 입력하세요 ");
		
		System.out.print("x[0] = ");
		x[0] = std.nextInt();
		
		//-- 바로 전 요소 보다 작으면 다시 입력
		for (int i=1; i<num; i++) {
			do {
				System.out.print("x[" + i + "] = ");
				x[i] = std.nextInt();
			} while( x[i-1] > x[i]); 
		}
		
		System.out.print("검색할 값 : ");
		int ky = std.nextInt();
		
		int idx = binSearch(x, num, ky);
		
		if(idx == -1)
			System.out.println("해당값을 찾지 못했습니다.");
		else
			System.out.println("x["+idx+"]에 있습니다.");
	}
}
