package org.study;

public class binarySearch {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		// 2 는 arr배열의 어떤 인덱스에 있을까?
		binarySearch(2, arr);
	}

	private static void binarySearch(int key, int[] arr) {
		
		int mid;
		int left = 0;
		int right = arr.length -1;
		
		
		while (right >= left) { 
			mid = ( left + right) / 2;
			if (arr[mid] == key) {
				System.out.println(key +"는 arr배열의 "+mid+"에 있습니다");
				break;
			}
			else if ( arr[mid] < key ) {
				left = mid+1;
			}
			else if ( arr[mid] > key ) {
				right = mid-1;
			}
		}
		
	}
}
