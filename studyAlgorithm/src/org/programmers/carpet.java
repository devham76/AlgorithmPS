package org.programmers;

import java.util.Arrays;

public class carpet {
	
	public static void main(String[] args) {
		solution(24, 24);
	}
	static int[] solution(int brown, int red) {
        int[] answer = new int[2];
        
        for (int i=1; i<=red; i++) {
        	if(red % i != 0)
        		continue;
        	
        	int garo = red/i;
        	
        	if ( (garo+i)*2 + 4 == brown) {
        		answer[0] = garo+2;
        		answer[1] = i+2;
        		break;
        	}
        }
        
        return answer;
    }

}