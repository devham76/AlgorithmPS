package org.study;

public class SortInsertion {

	public static void main(String[] args) {
		int[] arr = { 10, 9, 8, 7, 6, 5, 4 };	// 최악 O(n^)

		for (int i = 1; i < arr.length; i++) {

			int standard = arr[i]; // 기준

			int aux = i - 1; // 비교할 대상

			while (aux >= 0 && standard < arr[aux]) {

				arr[aux + 1] = arr[aux]; // 비교대상이 큰 경우 오른쪽으로 밀어냄

				aux--;

			}

			arr[aux + 1] = standard; // 기준값 저장

		}

		//-- 출력
		for(Integer a : arr) {
			System.out.print(a+" ");
		}

	}

}
