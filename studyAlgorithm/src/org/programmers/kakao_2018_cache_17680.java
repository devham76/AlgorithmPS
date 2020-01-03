package org.programmers;
import java.util.*;

public class kakao_2018_cache_17680 {

	public static void main(String[] args) {
		
		String[] cities1 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		kakao_2018_cache_17680 k = new kakao_2018_cache_17680();
		k.solution(3, cities1);
		

	}
	  public int solution(int cacheSize, String[] cities) {
	      int answer = 0;
	      
	      List<String> cache = new LinkedList<String>();
	      
	      
	      for (int i=0; i<cities.length; i++) {
	    	  String city = cities[i].toLowerCase();
	    	  
	    	  if(cacheSize==0) {
	    		  answer += 5;
	    		  continue;
	    	  }
	    	  
	    	  int size = cache.size();
	    	  // ĳ�ÿ� �ִٸ�
	    	  if (cache.contains(city)) {
	    		  // �ǵڿ� ���� �ʴٸ�
	    		  if ( cache.indexOf(city) < size-1) {
	    			  cache.remove(cache.indexOf(city));
	    			  cache.add(city);
	    		  }
	    		  answer ++;
	    	  }
	    	  // ĳ�ÿ� ���ٸ�
	    	  else {
	    		  if(size == cacheSize) {
	    			  cache.remove(0);
	    		  }
	    		  cache.add(city);
    			  answer += 5;
	    	  }
	      }
	      
	      System.out.println(answer);
	      return answer;
	  }
}
