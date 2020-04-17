package org.programmers;

import java.util.LinkedList;

public class Level2_42883 {

	public static void main(String[] args) {
		solution("1924", 2);

	}

	public static String solution(String number, int k) {
		StringBuilder answer = new StringBuilder();
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < number.length(); i++)
			list.add(Integer.parseInt(number.charAt(i) + ""));

		int idx = 0;
		while (true) {
			boolean is_end = false;
			while (idx >= 0 && idx < list.size()) {
				int nextIdx = idx + 1;
				if (list.get(idx) < list.get(nextIdx)) {
					list.remove(idx);
					idx--;
					k--;

					if (k <= 0) {
						is_end = true;
						break;

					}
				} else {
					idx++;
				}
			}
			if (is_end == true)
				break;
			

			if(idx == list.size()-1) {
				for(int i=0; i<k; i++) {
					list.remove(0);
				}
			}
			idx = 0;
		}

		for (Integer l : list) {
			answer.append(l);
		}
		String a = new String(answer);
		System.out.println(a);
		return a;
	}
}
