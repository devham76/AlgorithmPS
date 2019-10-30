package org.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Level1_marathon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] p = {"leo", "kiki", "eden"};
		String[] c = {"eden", "kiki"};

		solution(p,c);
	}
	public static String solution(String[] participant, String[] completion) {
		Arrays.sort(participant);
		Arrays.sort(completion);
		int i;
		for (i=0; i<completion.length; i++) {
			if(!participant[i].equals(completion))
				return participant[i];
		}
		return participant[i];
	}
	public static String solution2(String[] participant, String[] completion) {
		String answer = "";
		int val = 0;

		Map<String, Integer> hm = new HashMap<>();

		for (String part:participant) {
			// 해시맵에 해당 key에대한 value값이 없다면
			if(hm.get(part) == null)
				hm.put(part,1);
			else {
				val = hm.get(part) + 1;
				hm.put(part, val);
			}
		}

		for (String comp:completion) {
			val = hm.get(comp) -1;
			hm.put(comp, val);
		}

		for (String key:hm.keySet()) {
			if(hm.get(key)==1) answer = key;
		}
		return answer;
	}
}
