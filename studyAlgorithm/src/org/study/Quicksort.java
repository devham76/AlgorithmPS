package org.study;

public class Quicksort {

	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1]; a[idx1] = a [idx2]; a[idx2] = tmp;
	}
	
	static void quickSort(int[] a, int left, int right) {
		int pl = left;			
		int pr = right;			
		
		int x = a[ (pl+pr)/2 ];	//�ǹ�
		
		do {
			while(pl < x) pl++;
			while(pr > x) pr--;
			if(pl <= pr)
				swap(a, pl++, pr--);
		}while( pl<= pr ); 		// pl�� pr�� �����Ǹ� ����.
		
		// �迭�� �ݺ��ؼ� ������ �����Ѵ�.
		if(left < pr)	quickSort(a, left, pr);
		if(right > pl)	quickSort(a, pl, right);
	}
}
