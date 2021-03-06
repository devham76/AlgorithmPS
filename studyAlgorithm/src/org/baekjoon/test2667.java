package org.baekjoon;

import java.io.*;
import java.util.*;

public class test2667 {

	static int[][] arr;
	static int size;
	static boolean[][] visited;
	
	// 점의 방향 
	static int[] Dx = {-1, 1, 0, 0};
	static int[] Dy = {0, 0, -1, 1};
	
 	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
	
		size = Integer.parseInt(br.readLine());
		arr = new int[size][size];
		
		for(int i=0; i<size; i++) {
			input = br.readLine();
			for(int j=0; j<size; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		
		ArrayList<Integer> houseCount = new ArrayList<Integer>();
		visited = new boolean[size][size];
		int group = 0;
		
		// 전체를 돌며 1인 점을 찾는다
		for (int i=0; i<size; i++) {
			
			for (int j=0; j<size; j++) {
				
				// 이미 방문한 점이라면 패스
				if (visited[i][j] == true) continue;
				
				// 방문하지 않은 집이라면 새로운 단지+1 , 단지내 집의 수 구하기
				if(arr[i][j] == 1) {
					// 단지 +1
					group++;
					houseCount.add(BFS(i,j));
				}
			}
		}
		
		// 결과 출력
		System.out.println(group);
		
		Collections.sort(houseCount);
		for(int e:houseCount)
			System.out.println(e);
		
	}
	
	static int BFS(int x, int y) {

		int houseCount = 0;
		Queue<dot> qu = new LinkedList<dot>();
		qu.offer(new dot (x, y));
		
		while (!qu.isEmpty()) {
			// 방문할 큐 맨앞 점을 하나 뽑는다.
			dot Cd = qu.poll();
			int Cx = Cd.x;
			int Cy = Cd.y;
			
			
			// 뽑힌 점의 상하좌우를 확인한다.
			for (int i=0; i<4 ;i++) {
				int Nx = Cx + Dx[i];
				int Ny = Cy + Dy[i];
				
				// 상하좌우의 점이 범위 내에 있는지 확인한다.
				if (0 <= Nx && Nx < size && 0 <= Ny && Ny < size) {
					// 집이 있고 방문하지 않았으면 
					if (arr[Nx][Ny] == 1 && visited[Nx][Ny] == false) {
						// 방문한다
						visited[Nx][Ny] = true;
						qu.offer(new dot(Nx,Ny));
						// 집의 숫자를 세어준다.
						houseCount++;
					}
				}
			}
		}
		return houseCount;
	}
}

