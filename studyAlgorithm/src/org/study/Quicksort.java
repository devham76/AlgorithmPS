package org.study;

public class Quicksort {

	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1]; a[idx1] = a [idx2]; a[idx2] = tmp;
	}
	
	static void quickSort(int[] a, int left, int right) {
		int pl = left;			//왼쪽 커서
		int pr = right;			//오른쪽 커서
		
		int x = a[ (pl+pr)/2 ];	//피벗
		
		do {
			while(pl < x) pl++;
			while(pr > x) pr--;
			if(pl <= pr)
				swap(a, pl++, pr--);
		}while( pl<= pr ); 		// pl과 pr이 교차되면 중지.
		
		// 배열을 반복해서 나눠서 정렬한다.
		if(left < pr)	quickSort(a, left, pr);
		if(right > pl)	quickSort(a, pl, right);
	}
}
