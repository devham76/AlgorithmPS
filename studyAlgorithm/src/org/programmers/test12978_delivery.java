package org.programmers;

import java.util.Arrays;

public class test12978_delivery {

	public static void main(String[] args) {
		int N = 6;
		int[][] roads = {{1,2,1},
				{1,3,2},{2,3,2},{3,4,3},
				{3,5,2},{3,5,3},{5,6,1}};
		int K = 4;
		
		solution(N, roads, K);
		int N1 = 5;
		int[][] roads1 = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int K1 = 3;
		solution(N1, roads1, K1);
	}
	static int[][] map;
	
	public static int solution(int N, int[][] road, int K) {
		int answer = 1;
		int[] distance = new int[N+1];
		boolean[] visited = new boolean[N+1];
		map = new int[N+1][N+1];
		for(int[] row:map) {
			Arrays.fill(row, 500000);
		}
		for(int i=0; i<road.length; i++) {
			map[road[i][0]][road[i][1]]  = Math.min(map[road[i][0]][road[i][1]], road[i][2]);
			map[road[i][1]][road[i][0]]  = Math.min(map[road[i][1]][road[i][0]], road[i][2]);
		}
		
		for(int i=1; i<N+1; i++) {
			distance[i] = map[1][i];
		}
		
		for(int i=2; i<N+1; i++) {
			if(distance[i] > K) continue;
			fun(visited, distance, i, K);
			
		}
		
		System.out.println();
		for(int i=2; i<N+1; i++) {
			if (distance[i] <= K)
				answer++;
			System.out.print(distance[i] + " ");
		}
		System.out.println(answer);
		return answer;
	}
	private static void fun(boolean[] visited, int[] distance, int idx, int K) {
		
		for(int i=2; i<distance.length; i++) {
			if(idx == i || visited[i]  == true) continue;
			
			distance[i] = Math.min(distance[i], distance[idx]+map[idx][i]); 
			
			if(distance[i] < K) {
				visited[i]  = true;
				fun(visited, distance, i, K);
				visited[i]  = false;
			}
		}
		
	}

}
