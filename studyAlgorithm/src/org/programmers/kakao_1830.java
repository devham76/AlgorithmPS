package org.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class kakao_1830 {

	public static void main(String[] args) {
		String s1 = "aHbEbLbLbOacWdOdRdLdDc";
		solution(s1);
		String s2 = "AxAxAxAoBoBoB";
		solution(s2);
		String t = "ABC";
	}

	public static String solution(String sentence) {
		String answer = "";
		HashMap<Character, List> hm = new HashMap<>();

		for (int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			// 소문자일때
			if (Character.isLowerCase(c)) {

				// 이전에 해당 소문자가 존재할때
				if (hm.containsKey(c)) {
					List<Integer> list = hm.get(c);
					list.add(i);
					hm.replace(c, list);
				} else {
					// 해당 소문자 처음 발견
					List<Integer> list = new ArrayList<>();
					list.add(i);
					hm.put(c, list);
				}

			}
		}

		StringBuilder sb = new StringBuilder();
		Iterator it = hm.keySet().iterator();
		int new_start = 0, new_end = 0;
		int before_start = 0, before_end = 0;
		while (it.hasNext()) {
			boolean is_ok = true;
			char c = (char) it.next();
			List<Integer> list = hm.get(c);
			int length = list.size();


			before_start = new_start;
			before_end = new_end;
			
			
			if (length == 1) {
				if (list.get(0) == 0) {
					is_ok = false;
					break;
				}
				new_start = list.get(0) - 1;
				new_end = list.get(0) + 2;

			} else if (length == 2) {
				new_start = list.get(0);
				new_end = list.get(1);

			} else if (length > 2) {
				for (int i = 0; i < list.size() - 1; i++) {
					if (list.get(i + 1) - list.get(i) != 2) {
						is_ok = false;
						break;
					}
				}

				new_start = list.get(0) - 1;
				new_end = list.get(length - 1) + 2;
			}
			
			
			if (before_end > new_start && before_start <new_start) 
				continue;
			
			if (  (before_end != 0 && (before_end > new_start)) || is_ok == false) {
				answer = "invaild";
				break;
			}
			
			
			if (before_end != new_start && before_end != 0) {
				String sub = sentence.substring(before_end, new_start).replaceAll("[a-z]", "");
				sub.trim();
				if(!sub.equals(""))
					sb.append(sub + " ");
			}


			String sub = sentence.substring(new_start, new_end).replaceAll("[a-z]", "");
			sub.trim();
			if(!sub.equals(""))
				sb.append(sub + " ");
		} 
		
		//----------------
		if (new_end < sentence.length()) {
			String sub = sentence.substring(new_end, sentence.length()).replaceAll("[a-z]", "");
			sub.trim();
			sb.append(sub);
		}

		if(!answer.equals("invaild")) {
			if(sb.charAt(sb.length()-1) == ' ') {
				sb.delete(sb.length()-1, sb.length());
			}
			answer = new String(sb);
		}
		System.out.println("====================answer = [" + answer+"]");
		return answer;

	}
}
