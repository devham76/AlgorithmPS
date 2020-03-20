package org.programmers;

import java.util.Arrays;

public class test12987 {

	public static void main(String[] args) {
		int[] a = {5,1,3,7};
		int[] b = {2,2,6,8};
		solution(a,b);

	}
	public static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int idx=0;
        for(int i=0; i<A.length; i++) {
        	for(int j=idx; j<B.length; j++) {
        		if(A[i] < B[j]) {
        			answer++;
        			idx = j+1;
        			break;
        		}
        	}
        }
        System.out.println(answer);
        return answer;
    }
}
