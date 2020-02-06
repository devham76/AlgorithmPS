//https://www.welcomekakao.com/learn/courses/30/lessons/42861
package org.tryAgain;

import java.util.*;

public class Test42861_islandConnect {

	public static void main(String[] args) {
		Test42861_islandConnect t = new Test42861_islandConnect();
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		t.solution(4, costs);

	}
	static int[][] map;
	static int min=0;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        map = new int[n][n];
        boolean[] visited = new boolean[n]; 
        
        for(int i=0; i<costs.length; i++) {
        	map[costs[i][0]][costs[i][1]] = costs[i][2]; 
        	map[costs[i][1]][costs[i][0]] = costs[i][2]; 
        	min += costs[i][2];
        }
        
        List<Integer> connect = new ArrayList<>();
        connect.add(0);	// 출발지 0
        
        visited[0] = true;	// 0 방문함
        while(connect.size() < n) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            
            // 현재까지 연결된 섬들 과 연결될수 있는 가장 저렴한 섬을 찾는다
            // 현재까지 연결된 섬을 하나씩 검색
            for(int island = 0; island < connect.size(); island++) {
                int i = connect.get(island);
                System.out.println("i"+i);
                // 기준 섬과 연결된 섬 중 연결선이 가장 작은 섬과 값을 찾는다.
                // 방문하지 않았고, 자기자신이 아니고, 연결선이 있고, 연결값이 최소일때
                for(int j = 0; j < n; j++) {
                    if(!visited[j] && i != j && map[i][j] > 0 && map[i][j] < min) {
                        min = map[i][j];
                        minIdx = j;
                        System.out.println("midIdx:"+j);
                    }
                }
            }
            // 방문한다
            visited[minIdx] = true;
            // 방문한 섬은 연결한다
            connect.add(minIdx);
            answer += min;
        }
        System.out.println(answer);
        //fun(visited, 0, 1, n, 0, "");
        //System.out.println(min);
        return answer;
    }
    
    public static void fun(boolean[] visited , int prev, int count, int total, int sum, String str) {
    	if(count == total) {
    		System.out.println("-------.>>>"+sum);
    		System.out.println(str);
    		min = Math.min(min, sum);
    		return;
    	}
    	//System.out.println("prev:"+prev);
    	for(int i=1; i<total; i++) {
    		
    		if(i == prev) 
    			continue;
    		if(visited[i] == true)
    			continue;
    		
    		
    		if(map[prev][i] == 0)
    			continue;
    		//System.out.println(count+" | "+prev+" ->"+ i + " : "+map[prev][i]);
    		
    		visited[i] = true;
    		fun(visited, i, count+1, total, sum+map[prev][i],str+ " "+prev +"->"+i);
    		visited[i] = false;
    		
    	}
    }
}
