package org.doit;
import java.util.Scanner;

public class BinsearchX {

	static int binSearch(int[] a, int n, int key) {
		int pl = 0; 		// 검색 범위의 첫 인덱스
		int pr = n - 1;		// 검색 범위의 끝 인덱스
		
		do {
			int pc = ( pl + pr ) / 2;
			if (a[pc] == key) {	// 검색성공
				if (a[pc] == a[pc-1])
					pr = pc - 1;
				else
					return pc;		
			}
			else if (a[pc] < key)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while (pl <= pr);
		
		return -1; 				// 검색실패
	}
	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		
		int[] x = {1,3,5,7,7,7,7,8,8,9,9};
		
		System.out.print("검색할 값 : ");
		int ky = std.nextInt();
		
		int idx = binSearch(x, x.length, ky);
		
		if(idx == -1)
			System.out.println("해당값을 찾지 못했습니다.");
		else
			System.out.println("x["+idx+"]에 있습니다.");
	}
}
