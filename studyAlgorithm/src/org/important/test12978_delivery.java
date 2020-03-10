package org.important;

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
	
	public static int solution(int N, int[][] road, int K) {
		int answer		 	= 1;	// 1번마을은 무조건 갈수있다.
		int[] distance 		= new int[N+1];
		boolean[] visited 	= new boolean[N+1];
		int[][] map = new int[N+1][N+1];
		
		// 무한대로 초기화
		for(int[] row:map) {
			Arrays.fill(row, 500000);
		}
		
		for(int i=0; i<road.length; i++) {
			// 갈수있는 길이 여러가지 일때 가장 짧은 길을 선택
			map[road[i][0]][road[i][1]]  = Math.min(map[road[i][0]][road[i][1]], road[i][2]);
			map[road[i][1]][road[i][0]]  = Math.min(map[road[i][1]][road[i][0]], road[i][2]);
		}
		
		
		// 1번 마을에서 다른 마을 까지의 거리를 넣는다
		for(int i=2; i<N+1; i++) {
			distance[i] = map[1][i];
		}
		// 시작노드값 초기화
		distance[1] = 0;
		visited[1] = true;
		int visitedCnt = 1;
		
		
		// 방문한 마을 수가 전체 마을 수 보다 크거나 같으면 종료
		while (visitedCnt < N) {
			int min = 500000;
			int minIdx = 1;
			
			// 현재마을에서 가장 가까운 마울 찾기
			for(int i=2; i<N+1; i++) {
				// 해당 마을까지 갈수있고, 방문한 마을이 아니라면 
				if(distance[i] < 500000 && visited[i] == false) {
					if(distance[i] < min) {
						min = distance[i];
						minIdx = i;
					}
				}
			}
			

			// 가장 가까운 마을 방문
			visited[minIdx] = true;
			visitedCnt++;
			for(int i=2; i<N+1; i++) {
				// 내마을이 아니고 방문한 마을이 아니라면 
				if(map[minIdx][i] != 0 && visited[i] == false) {
					if (distance[i] > distance[minIdx]+map[minIdx][i])
					distance[i] = distance[minIdx]+map[minIdx][i];
				}
			}
		}
		
		
		
		//System.out.println();
		for(int i=2; i<N+1; i++) {
			if (distance[i] <= K)
				answer++;
			//System.out.print(distance[i] + " ");
		}
		return answer;
	}
	

}
