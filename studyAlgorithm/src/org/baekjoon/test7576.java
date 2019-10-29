package org.baekjoon;

import java.util.*;
public class test7576 {
	static boolean[][] visited;	// 방문여부
	static int[][] fruit;		// 과일판 
	static int M,N;				// 과일 열, 행
	static int todayCnt = 0; 	// 오늘 익은 과일수
	
	static int[] Dx = {-1, 1, 0, 0};
	static int[] Dy = {0, 0, -1, 1};
	
	public static void main(String[] args) {

		// 과일 정보 입력받기
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		visited = new boolean[N][M];
		fruit = new int[N][M];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				fruit[i][j] = sc.nextInt();
			}
		}
		
		Queue<dot> qu = new LinkedList<dot>();
		// 처음 1 의 위치 찾기
		for (int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				
				if(fruit[i][j] == 1) {
					qu.offer(new dot(i,j));
					visited[i][j] = true;
					todayCnt++;
				}
			}
		}
		
		// 익은 과일 하나도 없음 끝.
		if(todayCnt == 0 )
			System.out.println(-1);
		// 모두 익은 과일이라면
		else if(todayCnt == (M*N))
			System.out.println(0);
		else
			bfs(qu);
	}
	static void bfs(Queue<dot> qu) {
		int day = -1;
		int yesterdayCnt;					// 전날 익은 과일 개수

		while ( !qu.isEmpty()) {			// 뮤 : 전날익은 과일위치
			
			yesterdayCnt = todayCnt;
			todayCnt = 0;
			
			// 전날 익은 과일을 모두 꺼낸다.
			for (int i=0; i<yesterdayCnt; i++) {
				dot Cq = qu.poll();
				
				// 해당과일의 상하좌우 과일을 확인한다.
				for (int j=0; j<4; j++) {
					
					int Nx = Cq.x + Dx[j];
					int Ny = Cq.y + Dy[j];
					
					// 상하좌우가 과일상자 범위 안에 있어야 한다.
					if (0 > Nx || Nx >= N || 0 > Ny || Ny >= M ) 
						continue;
				
					// 이미 방문했다면 패쓰.
					if (visited[Nx][Ny] == true )
						continue;
					
					visited[Nx][Ny] = true;
					
					// 안익은 과일이라면 익히고, 큐에 넣고, 오늘익은 과일수 +1
					if (fruit[Nx][Ny] == 0) {
						fruit[Nx][Ny] = 1;
						qu.offer(new dot(Nx, Ny));
						todayCnt++;
					}
					
				}
			}
			day++;
		}
		
		boolean is_done = true;
		
		// 과일판에 안익은 과일이 있으면, -1
		for (int i=0; i<N; i++) {
			for(int e:fruit[i]) {
				if(e == 0) {
					System.out.println(-1);
					is_done = false;
					break;
				}
			}
		}
		
		if(is_done == true)
			System.out.println(day);
	}

	
}
