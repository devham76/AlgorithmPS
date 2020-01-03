package org.programmers;

import java.util.*;
import java.util.regex.Pattern;

public class kakao_2018_17677_newsClustering {

	public static void main(String[] args) {
	
		String s1 = "E=M*C^2";
		String s2 = "e=m*c^2";
		
		kakao_2018_17677_newsClustering k = new kakao_2018_17677_newsClustering();
		k.solution(s1, s2);

	}

	public int solution(String str1, String str2) {
		int answer = 0;
		
		HashMap<String, Integer> hm1 = new HashMap<>();
		HashMap<String, Integer> hm2 = new HashMap<>();

		List<String> stringArray1 = new ArrayList<>();
		List<String> stringArray2 = new ArrayList<>();
		
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		// 두개씩 쪼개서 문자만 넣기
		String pattern = "^[a-zA-Z]*$";
		for (int i=0; i<str1.length()-1; i++) {
			String s1 = (String) str1.substring(i, i+2);
			if (Pattern.matches(pattern, s1) == true)
				stringArray1.add(s1);
		}
		for (int i=0; i<str2.length()-1; i++) {
			String s2 = (String) str2.substring(i, i+2);
			if (Pattern.matches(pattern, s2) == true)
				stringArray2.add(s2);
		}
		
		// <쪼갠것, 쪼갠것들 개수> 해쉬맵을 이용
		for (int i=0; i<stringArray1.size(); i++) {
			if ( hm1.containsKey(stringArray1.get(i)) ){
				hm1.put(stringArray1.get(i), hm1.get(stringArray1.get(i))+1 );
			}
			else 
				hm1.put(stringArray1.get(i), 1);
		}
		
		for (int i=0; i<stringArray2.size(); i++) {
			if ( hm2.containsKey(stringArray2.get(i)) ){
				hm2.put(stringArray2.get(i), hm2.get(stringArray2.get(i))+1 );
			}
			else
				hm2.put(stringArray2.get(i), 1);
		}
		
		// str1, str2 각각에 중복된것이 있는지 찾기, 해쉬맵을 이용하여 검색을 빠르게 했다
		Iterator<String> keySetIterator = hm1.keySet().iterator();
		float max = 0, min = 0;
		while(keySetIterator.hasNext()) {
			String key = keySetIterator.next();	
			// 중복된것이 있다면 최소, 최댓값을 찾고 str2에서 중복된것을 삭제한다
			if (hm2.containsKey(key) == true) {
				max += Math.max(hm1.get(key), hm2.get(key));
				min += Math.min(hm1.get(key), hm2.get(key));
				hm2.remove(key);
			}
			// 중복된것이 없다면 최소값은 0이고 최대값은 해당 값이다
			else {
				max += hm1.get(key);
			}
		}
		// 중복된것은 직전에 모두 삭제 했으므로 남은 것들을 돌며 최대값을 찾아준다
		keySetIterator = hm2.keySet().iterator();
		while(keySetIterator.hasNext()) {
			String key = keySetIterator.next();	
				max += hm2.get(key);
		}
		
		if (min == 0 && max == 0)
			answer = 65536;
		else 
			answer =  (int)Math.floor(min/max * 65536);
		
		return answer;
	}
	
}

