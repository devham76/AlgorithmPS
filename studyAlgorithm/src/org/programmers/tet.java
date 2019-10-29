package org.programmers;

public class tet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,4,3,2};
		
		int arrSize = arr.length;
		int isOk = 0;
		for(int e : arr) {
			if (e == arrSize)
				isOk = 1;
		}
		if (isOk == 0)
			System.out.println("false");
		
		System.out.println("true 1");
		for (int i=0; i<arrSize; i++) {
			for (int j=i+1; j<=arrSize; j++) {
				if( arr[i] == arr[j]) {
					isOk = 0;
					break;
				}
			}
		}
	}

}
