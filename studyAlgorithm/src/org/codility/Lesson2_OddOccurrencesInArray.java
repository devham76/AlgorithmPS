package org.codility;

import java.util.*;

public class Lesson2_OddOccurrencesInArray {

	public static void main(String[] args) {
		int[] a = {9,3,9,3,9,7,9};
		solution(a);
	}
    public static int solution(int[] A) {
    	int answer = 0;
        Arrays.sort(A);
        for(int i=0; i<A.length-3; i+=2) {
        	if(A[i] != A[i+1]) {
        		answer = A[i];
        		
        	}
        }
        if(answer == 0 ) {
        	answer = A[A.length-1];
        }
        System.out.println(answer);
        return answer;
    }
}
