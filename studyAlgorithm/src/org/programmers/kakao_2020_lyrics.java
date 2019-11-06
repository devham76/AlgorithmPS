package org.programmers;

public class kakao_2020_lyrics {

	public static void main(String[] args) {

		String[] w = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] q = {"fro??", "????o", "fr???", "fro???", "pro?"};
		solution(w,q);
	}
    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        
        for (int i=0; i<queries.length; i++) {
        	int len = queries[i].length();
        	String start = queries[i].substring(0, 1);
        	boolean is_start_ch = start.equals("?");
        	String alphaOnly = queries[i].replaceAll("[^a-zA-Z]+","");
        	int alphLen = alphaOnly.length();
        	
        	for(int j=0; j<words.length; j++) {
        		if(len != words[j].length())
        			continue;
        		
        		// ?로 시작하지 않는다면
        		if(is_start_ch == false && words[j].indexOf(alphaOnly) == 0) 
        			answer[i]++;
   
        		
        		if(is_start_ch == true ) {
        			String newS = words[j].substring( words[j].length()-alphLen,words[j].length());
        			if(newS.equals(alphaOnly))
        				answer[i]++;
        		}
        	}
        }

        return answer;
    }

}
