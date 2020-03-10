//https://programmers.co.kr/learn/courses/30/lessons/42886
package org.programmers;

import java.util.Arrays;

public class test42886_scale {

	public static void main(String[] args) {
		int[] weight = {3, 1, 6, 2, 7, 30, 1};
		solution(weight);
	}
    public static int solution(int[] weight) {
    	Arrays.sort(weight);
    	int answer = weight[0];
        for(int i=1; i<weight.length; i++) {
        	if(answer+1 >= weight[i])
        		answer += weight[i];
        	else {
        		
        		break;
        	}
        }
        System.out.println(++answer);
        return answer;
    }
}
