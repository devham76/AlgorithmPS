package org.study;

public class Quicksort {

	public static void main(String[] args) {
		int[] arr = { 3, 9, 20, 1, 6, 5 };
		// 배열a, 배열의 시작, 배열의 끝
		quickSort(arr, 0, arr.length - 1);

		for (Integer a : arr)
			System.out.print(a + " ");
	}

	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}

	static void quickSort(int[] arr, int left, int right) {
		int pl = left;
		int pr = right;

		int pivot = arr[(pl + pr) / 2]; // pivot

		do {
			// pivot보다 작은것 , pivot, pivot보다 큰것
			// 해당 규칙에 위배되는 index를 찾는다.
			while (arr[pl] < pivot)
				pl++;
			while (arr[pr] > pivot)
				pr--;

			System.out.println("pl=" + pl + " pr=" + pr + " x=" + pivot);
			if (pl <= pr)
				swap(arr, pl++, pr--);

			for (Integer a : arr)
				System.out.print(a + " ");
			System.out.println();

		} while (pl <= pr); 

		if (left < pr)
			quickSort(arr, left, pr);
		if (right > pl)
			quickSort(arr, pl, right);
	}
}
