package org.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class kakako_2017_1829 {

	public static void main(String[] args) {
		
		int m = 6;
		int n = 4;
		int[][] pic = {{1, 1, 1, 0}, 
				{1, 2, 2, 0}, 
				{1, 0, 0, 1}, 
				{0, 0, 0, 1}, 
				{0, 0, 0, 3}, 
				{0, 0, 0, 3}
				};
		
		solution(m, n, pic);
		
	}
	
	
	  public static int[] solution(int m, int n, int[][] picture) {
	      int numberOfArea = 0;
	      int maxSizeOfOneArea = 0;
	      
	      int[] answer = new int[2];
	      
	      
	      boolean[][] visited = new boolean[m][n];
	      int[] Nx = {-1,1,0,0};
	      int[] Ny = {0,0,-1,1};
	      
	      for (int i=0; i<m; i++) {
	    	  for (int j=0; j<n; j++) {
	    		  
	    		  if (picture[i][j] == 0) {
	    			  visited[i][j] = true;
	    			  continue;
	    		  }
	    		  
	    		  if (visited[i][j] == true)
	    			  continue;
	    		  
	    		  int nowNum = picture[i][j];
	    		  int SizeOfOneArea = 0;
	    		  numberOfArea++;
	    		  Queue<dot> q = new LinkedList<dot>();
	    		  q.offer(new dot(i,j));
	    		  visited[ i ][ j ] = true;
	    		  while(!q.isEmpty()) {
	    			  dot d = q.poll();
	    			  
	    			  SizeOfOneArea++;
	    			  for (int k=0; k<4; k++) {
	    				  if (d.x + Nx[k] < 0 || d.x + Nx[k] >=m || d.y + Ny[k] < 0 || d.y + Ny[k] >= n)
	    					  continue;
	    				  if ( picture[ d.x + Nx[k] ][ d.y + Ny[k] ] == nowNum && visited[ d.x + Nx[k] ][ d.y + Ny[k] ] == false) {
	    					  q.offer(new dot(d.x + Nx[k] , d.y + Ny[k]));
	    					  visited[ d.x + Nx[k] ][ d.y + Ny[k] ] = true;
	    				  }
	    			  }
	    		  }
	    		  
	    		  if (SizeOfOneArea > maxSizeOfOneArea) {
	    			  System.out.println("SizeOfOneArea :"+SizeOfOneArea);
	    			  maxSizeOfOneArea = SizeOfOneArea;
	    		  }
	    	  }
	    	  
	      }
	      answer[0] = numberOfArea;
	      answer[1] = maxSizeOfOneArea;
	      System.out.println(answer[0]+","+answer[1]);
	      return answer;
	  }
}
class dot{
	int x;
	int y;
	
	dot(int x, int y){
		this.x = x;
		this.y = y;
	}
}