package org.programmers;

import java.util.Arrays;

public class boat {

	public static void main(String[] args) {
		int[] p = {70,80,50};

		solution(p, 100);
	}
	public static int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int head = 0;
        for(int i=people.length-1; i >= 0; i--) {
        	// 마지막 남은 한 사람
        	if (i==head) {
        		answer++;
        		break;
        	}
        	// 제일 몸무게 큰사람 + 작은 사람 이 limit보다 작으면 같이 태워보낸다
        	if (people[i] + people[head] <= limit) {
        		head++;
        		answer++;
        		// 마지막 남은 두사람이었다면 for문 나간다
        		if (i==head) {
            		break;
            	}
        	} else {
        	// 제일 몸무게 큰사람만 태워 보낸다
        		answer++;
        	}
        }
        return answer;
    }
}