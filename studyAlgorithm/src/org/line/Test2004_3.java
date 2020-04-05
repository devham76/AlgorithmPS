package org.line;

import java.util.ArrayList;
import java.util.List;

public class Test2004_3 {

	public static void main(String[] args) {
		String r = "111011110011111011111100011111";
		String r1 = "0011001000";
		solution(r1, 5);

	}

	public static int solution(String road, int n) {
		int answer = 0;
		List<Integer> list = new ArrayList<>();
		// base
		list.add(0);
		for (int i = 0; i < road.length(); i++) {
			if (road.charAt(i) == '0') {
				list.add(i+1);
			}

		}

		if (n >= list.size()-1) {
			answer = road.length();
		} else {
			for (int i = n; i < list.size(); i++) {
				int candidate = 0;
				if (i == list.size() - 1)
					candidate = list.get(i) - list.get(i - n) - 1;
				else
					candidate = list.get(i + 1) - list.get(i - n) - 1;

				answer = Math.max(answer, candidate);

			}
		}
		System.out.println(answer);
		return answer;
	}
}
