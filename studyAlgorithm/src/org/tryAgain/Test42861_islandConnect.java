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
        connect.add(0);	// ����� 0
        
        visited[0] = true;	// 0 �湮��
        while(connect.size() < n) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            
            // ������� ����� ���� �� ����ɼ� �ִ� ���� ������ ���� ã�´�
            // ������� ����� ���� �ϳ��� �˻�
            for(int island = 0; island < connect.size(); island++) {
                int i = connect.get(island);
                System.out.println("i"+i);
                // ���� ���� ����� �� �� ���ἱ�� ���� ���� ���� ���� ã�´�.
                // �湮���� �ʾҰ�, �ڱ��ڽ��� �ƴϰ�, ���ἱ�� �ְ�, ���ᰪ�� �ּ��϶�
                for(int j = 0; j < n; j++) {
                    if(!visited[j] && i != j && map[i][j] > 0 && map[i][j] < min) {
                        min = map[i][j];
                        minIdx = j;
                        System.out.println("midIdx:"+j);
                    }
                }
            }
            // �湮�Ѵ�
            visited[minIdx] = true;
            // �湮�� ���� �����Ѵ�
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
