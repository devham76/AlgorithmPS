package org.programmers;

import java.util.Arrays;

public class Test20190919 {

	public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        
        for (int i=1; i<heights.length; i++) {
            for (int j=i-1; j>=0; j--) {
                if (heights[j] > heights[i]) {
                	System.out.println(heights[i] +"<"+ heights[j]);
                    answer[i] = j+1;
                    System.out.println("answer["+i+"]=>"+answer[i]);
                    break;
                }
                else {
                    if (j==0) answer[i] = 0;
                }
            }
        }
        return answer;
    }
	public static void main(String[] args) {
		int[] a = {6, 9, 5, 7, 4};
		int[] b = solution(a);
		for (int i: b) {
			System.out.println(b[i]+" , ");
		}
		    
		
        
	}

}
