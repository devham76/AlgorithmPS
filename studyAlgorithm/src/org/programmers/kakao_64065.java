// https://programmers.co.kr/learn/courses/30/lessons/64065
package org.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class kakao_64065 {

	public static void main(String[] args) {
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		solution(s);
	}

	public static int[] solution(String s) {

		List<tuple> tuples = new ArrayList<>();
		String s2 = s.substring(1, s.length() - 1); // 앞뒤 괄호 제거

		StringBuilder st = new StringBuilder();
		List<Integer> list = null;
		boolean is_set = false;	// } 괄호로 닫히지 않았을때만 숫자추가.
		for (int i = 0; i < s2.length(); i++) {
			if (s2.charAt(i) == '{') {
				list = new ArrayList<>();
				is_set = false;
			} else if (s2.charAt(i) == '}') {
				list.add(Integer.parseInt(new String(st)));
				st = new StringBuilder();

				tuples.add(new tuple(list.size(), list));
				is_set = true;
			} else if (s2.charAt(i) == ',' && is_set == false) {
				list.add(Integer.parseInt(new String(st)));
				st = new StringBuilder();
			} else if (s2.charAt(i) != ',' && is_set == false) {
				st.append(s2.charAt(i));
			}
		}

		Collections.sort(tuples);
		Iterator it = tuples.iterator();
		int idx = 0;
		int[] answer = new int[tuples.get(tuples.size() - 1).len];
		HashSet<Integer> hs = new HashSet<>();
		while (it.hasNext()) {
			tuple t = (tuple) it.next();
			List<Integer> integers = t.list;
			for(Integer i:integers) {
				if(!hs.contains(i)) {
					hs.add(i);
					answer[idx] = i;
					idx++;
					break;
				}
			}
		}

		for (Integer a : answer)
			System.out.println(a);
		return answer;
	}
}

class tuple implements Comparable<tuple> {
	int len;
	List<Integer> list;

	tuple(int len, List<Integer> list) {
		this.len = len;
		this.list = list;
	}

	@Override
	public int compareTo(tuple arg0) {

		return this.len - arg0.len;
	}
}