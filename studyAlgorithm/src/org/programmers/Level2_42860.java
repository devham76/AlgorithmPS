package org.programmers;

import java.util.HashMap;

public class Level2_42860 {

	public static void main(String[] args) {
		solution("BBAAABB");

	}

	public static int solution(String name) {
		int answer = 0;
		HashMap<Character, Integer> hm = new HashMap<>();
		hm.put('B', 1);
		hm.put('C', 2);
		hm.put('D', 3);
		hm.put('E', 4);
		hm.put('F', 5);
		hm.put('G', 6);
		hm.put('H', 7);
		hm.put('I', 8);
		hm.put('J', 9);
		hm.put('K', 10);
		hm.put('L', 11);
		hm.put('M', 12);
		hm.put('N', 13);
		hm.put('O', 12);
		hm.put('P', 11);
		hm.put('Q', 10);
		hm.put('R', 9);
		hm.put('S', 8);
		hm.put('T', 7);
		hm.put('U', 6);
		hm.put('V', 5);
		hm.put('W', 4);
		hm.put('X', 3);
		hm.put('Y', 2);
		hm.put('Z', 1);

		// 처음부터 순서대로 확인
		int ascIdx = 0;
		int notA = 0;
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) != 'A') {
				ascIdx = i;
				answer += hm.get(name.charAt(i));
				notA++;
			}
		}

		int descIdx = 0;
		int idx = 0;
		
		for (int i = name.length() - 1; i > 0; i--) {
			idx++;
			if (name.charAt(i) != 'A') {
				descIdx = idx;
			}
		}
		int min;
		if(notA == 0)
			min = Math.min(ascIdx, descIdx);
		else
			min = Math.min(ascIdx, Math.min(descIdx, notA));
		
		answer += min;
		System.out.println(answer);
		return answer;
	}

}
