package org.kakao;
// 시간초과
// 압축, 구간배열 사용해야한다
public class kakao_2017_1833 {

	public static void main(String[] args) {
		int[][] data= {{0, 0}, {1, 1}, {0, 2}, {2, 0}};
		kakao_2017_1833 k = new kakao_2017_1833();
		k.solution(4, data);

	}
	  public int solution(int n, int[][] data) {
	      int answer = 0;
	     
	      for (int i=0; i<data.length-1; i++) {
	    	  for(int j=i+1; j<data.length; j++) {
	    		  if(data[i][0] == data[j][0] || data[i][1]==data[j][1])
	    			  continue;
	    		  if(find(i,j,data))
	    			  continue;
	    		  
	    		  answer++;
	    	  }
	      }
	      System.out.println(answer);
	      return answer;
	  }
	  public static boolean find(int i, int j, int[][] data) {
	
		  int x1 = data[i][0];
		  int x2 = data[j][0];
		  if(x1 < x2) {
			  int tmp = x1;
			  x1 = x2;
			  x2 = tmp;
		  }
		  int y1 = data[i][1];
		  int y2 = data[j][1];
		  
		  if(y1 < y2) {
			  int tmp = y1;
			  y1 = y2;
			  y2 = tmp;
		  }
		  boolean result = false;
		  for (int k=0; k<data.length; k++) {
			  	if(x2 <data[k][0] && x1 > data[k][0]) {
			  		if(y2 <data[k][1] && y1 > data[k][1]) {
			  			result = true;
			  			return result;
			  		}
		  
			  	}
		  }
		  return result;
		  
	  }
}
