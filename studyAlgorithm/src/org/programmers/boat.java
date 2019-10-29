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
        	// ������ ���� �� ���
        	if (i==head) {
        		answer++;
        		break;
        	}
        	// ���� ������ ū��� + ���� ��� �� limit���� ������ ���� �¿�������
        	if (people[i] + people[head] <= limit) {
        		head++;
        		answer++;
        		// ������ ���� �λ���̾��ٸ� for�� ������
        		if (i==head) {
            		break;
            	}
        	} else {
        	// ���� ������ ū����� �¿� ������
        		answer++;
        	}
        }
        return answer;
    }
}