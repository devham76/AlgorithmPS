package org.programmers;

import java.util.HashMap;
import java.util.Iterator;

// 다시 풀기 !!!
// https://www.welcomekakao.com/learn/courses/30/lessons/42579
public class Level3_bestalbum_42579 {

	public static void main(String[] args) {

		String[] g = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};

		solution(g, plays);
	}

	public static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		HashMap<String, Integer> gHash = new HashMap<>();
		HashMap<Integer,Integer> tHash = new HashMap<>();
		HashMap<String, HashMap<Integer, Integer>> pHash = new HashMap<>();
		
		for (int i=0; i<genres.length; i++) {
			pHash.put(genres[i], new HashMap(i, plays[i]));
			if (gHash.containsKey(genres[i]))
				gHash.put(genres[i], gHash.get(genres[i]) + plays[i]);
			else {
				gHash.put(genres[i], plays[i]);
			}

		}
		System.out.println(pHash);

		return answer;
	}
}
