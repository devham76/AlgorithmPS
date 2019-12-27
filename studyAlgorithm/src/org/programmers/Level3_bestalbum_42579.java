package org.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// 다시 풀기 !!!
// https://www.welcomekakao.com/learn/courses/30/lessons/42579
public class Level3_bestalbum_42579 {

	public static void main(String[] args) {

		String[] g = {"classic", "pop", "classic", "classic", "pop","hiphop"};
		int[] plays = {500, 600, 150, 800, 2500, 10000};

		solution(g, plays);
	}

	public static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		HashMap<Integer, String> gHash = new HashMap<>();
		HashMap<Integer, Integer> pHash = new HashMap<>();
		HashMap<String, Integer> Allplay = new HashMap<>();
		
		//HashMap<String, HashMap<Integer, Integer>> pHash = new HashMap<>();
		
		for (int i=0; i<genres.length; i++) {
			if (Allplay.containsKey(genres[i]))
				Allplay.put(genres[i], Allplay.get(genres[i]) + plays[i]);
			else {
				Allplay.put(genres[i], plays[i]);
			}
			gHash.put(i, genres[i]);
			pHash.put(i, plays[i]);
		}
		Iterator it = sortByValue(Allplay).iterator();
    	while(it.hasNext()) {
            String key = (String) it.next();
            System.out.println(key + " = " + Allplay.get(key));
            /*
            int num = 0;
            for (int i=0; i<size; i++) {
            	if (songList.get(i).genre.equals(key) && num < 2) {
            		answer2.add(songList.get(i).id);
            		++num;
            	}
            }
            */
        }
		return answer;
	}
    public static List sortByValue(final Map map) {

        List<String> list = new ArrayList();
        list.addAll(map.keySet());

        Collections.sort(list,new Comparator() {

            public int compare(Object o1,Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable) v1).compareTo(v2);
            }

        });

        Collections.reverse(list); // 주석시 오름차순
        return list;
    }
}
