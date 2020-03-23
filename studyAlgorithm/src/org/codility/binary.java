package org.codility;

import java.util.*;

public class binary {

	public static void main(String[] args) {
		solution(1041);

	}
    public static int solution(int N) {
        int answer = 0;
        String binary = Integer.toBinaryString(N);
        List<Integer> sumList = new ArrayList<>();
        
        int sum = 0;
        for(int i=1; i<binary.length(); i++) {
        	if(binary.charAt(i) == '0') {
        		sum++;
        	}
        	else if (binary.charAt(i) == '1') {
        		
        		sumList.add(sum);
        		sum = 0;
        	}
        }
        Collections.sort(sumList);
        
        answer = sumList.size() > 0 ? sumList.get(sumList.size()-1) : 0;
        System.out.println(answer);
        return answer;
    }
}
