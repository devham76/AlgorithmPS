package org.programmers;

import java.util.Arrays;

public class summercoding_2017_12978 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int[][] road = {{1,2,1},{2,3,3},{5,2,2}
		,{1,4,2},{5,3,1},{5,4,2}};
		int K = 3;
		
		summercoding_2017_12978 s1 = new summercoding_2017_12978();
		//s1.solution(N, road, K);
		
		N = 6;
		K = 4;
		int[][] road2 = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		s1.solution(N, road2, K);
	}

    public int solution(int N, int[][] road, int K) {
        int answer = 1;

        int[] timeArr = new int[N];
        
        for (int i=0; i<road.length; i++) {
        	if (road[i][0] == 1) {
        		timeArr[ road[i][1]-1 ] = road[i][2];
        		if (road[i][2] < K ) answer++;
        	}
        	else if (road[i][1] == 1) {
        		timeArr[ road[i][0]-1 ] = road[i][2];
        		if (road[i][2] < K ) answer++;
        	}
        }
        System.out.println("answer : "+answer);
        for (int i=1; i < timeArr.length; i++) {
        	for (int e:timeArr)
        		System.out.print(e+" ");
        	System.out.println();
        		for (int j=0; j < road.length; j++) {
        			if (timeArr[i] == 0) {
        			
        			int next = 0;
        			if (road[j][0] == i+1 && road[j][1] != 1)
        				next = road[j][1];
        			else if (road[j][1] == i+1 && road[j][0] != 1)
        				next = road[j][0];
        			else 
        				continue;
        				
        			System.out.println("j: "+j+" , timeArr["+i+"] : "+timeArr[i]+ " , next : "+next+" timeArr[next-1]:"+ timeArr[next-1] +" road[j][2]"+road[j][2] );
        			timeArr[i] = timeArr[next-1] + road[j][2];
        			System.out.println("timeArr["+i+"] : "+timeArr[i]);
        			
        			if (timeArr[i] <= K) answer++;
        			}
        		}
        	
        }
        System.out.println(answer);
        return answer;
    }
}
