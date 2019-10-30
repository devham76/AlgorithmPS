package org.programmers;

import java.util.HashMap;

public class Level2_spy_42578 {

	public static void main(String[] args) {
		String[][] c = {
				{"yellow_hat", "headgear"}
				, {"blue_sunglasses", "eyewear"}
				, {"green_turban", "headgear"}};
		solution(c);

	}
	public static int solution(String[][] clothes) {
		int answer = 1;
		// < 옷의 종류 , 종류의 개수 > 
		HashMap<String, Integer> map = new HashMap<>();
		for (int i=0; i<clothes.length; i++) {
			if(map.containsKey(clothes[i][1]))
				map.put(clothes[i][1], map.get(clothes[i][1]) + 1 );
			else
				map.put(clothes[i][1], 1);
		}
		
		// ex. (안경2개를 뽑을경우+안뽑을경우) * (바지2벌을 뽑을경우+안뽑을경우) - 모두안입을경우
		for (String key:map.keySet()) {
			answer *= (map.get(key)+1);
		}
		answer--;	// 아무것도 안입은경우 제외
		return answer;
	}

}
