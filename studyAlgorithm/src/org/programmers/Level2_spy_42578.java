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
		// < ���� ���� , ������ ���� > 
		HashMap<String, Integer> map = new HashMap<>();
		for (int i=0; i<clothes.length; i++) {
			if(map.containsKey(clothes[i][1]))
				map.put(clothes[i][1], map.get(clothes[i][1]) + 1 );
			else
				map.put(clothes[i][1], 1);
		}
		
		// ex. (�Ȱ�2���� �������+�Ȼ������) * (����2���� �������+�Ȼ������) - ��ξ��������
		for (String key:map.keySet()) {
			answer *= (map.get(key)+1);
		}
		answer--;	// �ƹ��͵� ��������� ����
		return answer;
	}

}
