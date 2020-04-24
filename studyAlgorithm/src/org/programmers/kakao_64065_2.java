package org.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class kakao_64065_2 {

	public static void main(String[] args) {
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		solution(s);

	}

	public static int[] solution(String s) {
		int[] answer;
		ArrayList<String> sList = new ArrayList<>();
		ArrayList<String> answerList = new ArrayList<>();
		StringTokenizer divS = new StringTokenizer(s, "{}");

		// {}로 나눈다.
		while (divS.hasMoreElements()) {
			String tempString = divS.nextToken();
			System.out.println("tempString ="+tempString);
			// 4,2,3 
			// ,
			// 3
			// ,  이런식으로 값이 분리된다.
			if (!tempString.equals(","))
				sList.add(tempString);
		}

		// 길이 순서대로 정렬.
		Collections.sort(sList, (o1, o2) -> {
			return Integer.compare(o1.length(), o2.length());
		});
		// 맨앞에 값 추가
		answerList.add(sList.get(0));
		// 그 뒤부터 입력 안된 값 추가
		for (int i = 1; i < sList.size(); i++) {
			String[] tempChar = sList.get(i).split(",");
			for (int j = 0; j < tempChar.length; j++) {
				// asnwerList에 없는 값만 추가한다.
				if (!answerList.contains(tempChar[j]))
					answerList.add(tempChar[j]);
			}
		}

		return answerList.stream().mapToInt(Integer::parseInt).toArray();
	}
}
