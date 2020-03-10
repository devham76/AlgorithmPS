https://javaplant.tistory.com/14
https://programmers.co.kr/learn/courses/30/lessons/17685
package org.tryAgain;

import java.util.Arrays;

public class kakao_2018_17685 {

	public static void main(String[] args) {
		String[] words = {"word","war","warrior","world","worls","woa"};
		solution(words);
		String[] words2  = {"go","gone","guild"};
		solution(words2);
	}
	public static int solution(String[] words) {
	      int answer = 0;
	      Arrays.sort(words);
	      System.out.println("----------------");
	      for(String s :words)
	    		System.out.println(s);
	      
	     
	      String sameS = "";// 첫번째 동의어는 대문자로 설정하여 무조건 없게 만들었다
	      for(int i=0; i<words.length; i++) {
	    	  System.out.println("words["+i+"]="+words[i]);
	    	  
	    	  if(words[i].indexOf(sameS) == 0 && sameS.length() > 0 ) {
	    		  // 뒤에 나올 단어와 비교할 필요가 없을때
	    		  if(i == words.length-1 || words[i+1].indexOf(sameS) != 0) {
	    			  
	    			  answer += sameS.length()+1;
	    			  System.out.println("sameS="+sameS+" / answer="+answer);
	    			  sameS = "";
	    			  
	    			  continue;
	    		  }
	    		  
	    			  
	    		  for(int j=sameS.length(); j<words[i].length(); j++) {
	    			  if(words[i+1].length() < j) break;
	    			  
	    			  // 같은 단어만 뽑아준다
	    			  if(words[i].charAt(j) == words[i+1].charAt(j))
	    				  sameS += words[i].charAt(j);
	    			  else
	    				  break;
	    		  }
	    		  if (words[i].length() == sameS.length())
	    			  answer += sameS.length();
	    		  else
	    			  answer += sameS.length()+1;
	    		  
	    		  
	    		  
	    	  }
	    	  // 이전 동의어와 같은 단어가 포함되지 않았다면 
	    	  else if(words[i].indexOf(sameS) != 0 || sameS.length() == 0) {
	    		  sameS = "";
	    		  
	    		  int compare = i+1;
	    		  if(i == words.length-1) {
	    			  compare = i-1;
	    		  }
	    		  
	    		  for(int j=0; j<words[i].length(); j++) {
	    			  if(words[compare].length() < j) break;
	    			  
	    			  // 같은 단어만 뽑아준다
	    			  if(words[i].charAt(j) == words[compare].charAt(j))
	    				  sameS += words[i].charAt(j);
	    			  else
	    				  break;
	    		  }
	    		  if (words[i].length() == sameS.length())
	    			  answer += sameS.length();
	    		  else
	    			  answer += sameS.length()+1;
	    		  
	    	  }
	    	  
	    	  
	    	  System.out.println("sameS="+sameS+" / answer="+answer);
	      }
	      
	      System.out.println(answer);
	      return answer;
	}
}
