package org.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class kakao_17684 {

	public static void main(String[] args) {
		String m = "KAKAO";
		solution(m);
	}

	public static int[] solution(String msg) {
		
		List<Integer> list = new ArrayList<>();

		HashMap<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < 26; i++) {
			String alphabet = Character.toString((char) (i + 65)) + "";
			hm.put(alphabet, i + 1);
		}
		int i = 0;
		while (i < msg.length()) {
			String str = msg.charAt(i) + "";
			int number = hm.get(str);
			int j=0;
			int len=str.length();
			while (hm.containsKey(str) && i+j<msg.length()) {
				j++;
				number = hm.get(str);
				len = str.length();
				if(i+j <msg.length())
					str += msg.charAt(i+j);
			}
			list.add(number);
			hm.put(str, hm.size() + 1);
			i += len;
		}
		
		int[] answer = new int[list.size()];
		for (int k=0; k<list.size(); k++) {
			answer[k] = list.get(k);
		}

		return answer;
	}
}
