package org.codingTest;

import java.util.*;

public class Lesson2_OddOccurrencesInArray {

	public static void main(String[] args) {
		int[] a = {9, 3, 9, 3, 9, 7, 9, 7, 10, 10, 1};
		solution(a);
	}
    public static int solution(int[] A) {
    	int answer = 0;
        Arrays.sort(A);
     
        for(Integer i:A)
        	System.out.print(i+" ");
        System.out.println();
        for(int i=0; i<A.length-2; i+=2) {
        	System.out.println("a="+A[i]+" , a+1="+A[i+1]);
        	if(A[i] != A[i+1]) {
        		answer = A[i];
        		System.out.println("answer="+answer);
        		break;
        	}
        }
        if(answer == 0 ) {
        	answer = A[A.length-1];
        }
        System.out.println(answer);
        return answer;
    }
}
