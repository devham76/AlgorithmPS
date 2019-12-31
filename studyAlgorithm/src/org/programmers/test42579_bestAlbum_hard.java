package org.programmers;

import java.util.*;

import org.programmers.kakao_2019_Tree_findWay.Node;

public class test42579_bestAlbum_hard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] genres = {"classic", "pop", "classic", "classic", "pop"};	
		int[] plays = {500, 600, 150, 800, 2500};
		
		test42579_bestAlbum_hard t = new test42579_bestAlbum_hard();
		t.solution(genres, plays);
		
	}
	
	class song {
		int id;
		String genre;
		int plays;
		song(int id, String genre, int plays){
			this.id = id;
			this.genre = genre;
			this.plays = plays;
		}
	}
	
	Comparator<song> Comp = new Comparator<song>() {
		public int compare(song a, song b) {
			// 장르가 같다면 재생수가 큰순으로 (int)
			if(a.genre.equals(b.genre))
				return b.plays - a.plays;	
			// 장르별로 정리 (string)
			return a.genre.compareTo(b.genre);
		}
	};
	
	
    public int[] solution(String[] genres, int[] plays) {
    	
    	int size =  genres.length;
    	
    	List<song> songList = new ArrayList<>();
    	Map<String, Integer> generPlay = new HashMap<>();
    	
    	int play = 0;
    	for (int i=0; i<size; i++) {
    		songList.add( new song(i, genres[i], plays[i]));
    		if (generPlay.containsKey(genres[i]))
    			play = generPlay.get(genres[i]) + plays[i];
    		else
    			play = plays[i];
    		
    		generPlay.put(genres[i], play);
    	}
    	
    	songList.sort(Comp);
    	
    	Iterator it = sortByValue(generPlay).iterator();	// 총재생수가 큰 장르순으로 정렬
    	List<Integer> answer2 = new ArrayList<>();
    	while(it.hasNext()) {
            String key = (String) it.next();
            int num = 0;
            for (int i=0; i<size; i++) {
            	// 장르별로 2곡까지만 뽑는다
            	if (songList.get(i).genre.equals(key) && num < 2) {
            		answer2.add(songList.get(i).id);
            		++num;
            	}
            }
        }
    	
    	int[] answer = new int[answer2.size()];
    	for (int i=0; i<answer2.size(); i++) {
    		answer[i] = answer2.get(i);
    		System.out.print(answer[i]+" ");
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
