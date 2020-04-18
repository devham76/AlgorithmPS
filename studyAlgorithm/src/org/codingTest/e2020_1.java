package org.codingTest;

import java.util.*;

public class e2020_1 {

	public static void main(String[] args) {
		int[] A = {2,3,3,4,5,6,11,11,11,11,11,11,11,11,11,11,11};
		// 2가2개, 3이3개, 4가 4개있으면 제일많은 4반환하시오
		Arrays.sort(A);
		
		int idx = 0;
		int max = 0;
		while (idx < A.length) {
			int number = A[idx];
			int count = 1;
			int i = idx+1;
			for(; i<A.length; i++) {
				
				if(number == A[i]) {
					count++;
				}
				else {
					
					break;
				}
			}
			if(count != number)
				count = 0;
			max = Math.max(max, count);
			idx = i;
		}
		System.out.println(max);
	}

}
