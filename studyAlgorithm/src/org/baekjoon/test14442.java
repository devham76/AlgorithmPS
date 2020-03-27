package org.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test14442 {
	static int M,N,K;
	static int[][] map;
	static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][M];
		
		// (x,y) 까지 k번 부셔서 도착한적 있는지 확인.
		visited = new boolean[N][M][K+1];
		
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}
		
		
		bfs();
	}	
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	private static void bfs() {
		Queue<location> q = new LinkedList<>();
		// (0,0)까지 0번 부셔서 1번이동(시작값포함)
		q.offer(new location(0,0,1,0));
		
		while(!q.isEmpty()) {
			location l = q.poll();
			visited[l.x][l.y][l.k] = true;
			
			if(l.x == N-1 && l.y == M-1) {
				System.out.println(l.cnt);
				return;
			}
				
			for(int i=0; i<4; i++) {
				int x = l.x + dx[i];
				int y = l.y + dy[i];

				if (x < 0 || x >= N || y < 0 || y >= M)
					continue;
				
				if(map[x][y] == 1) {
					// 지금까지 부순 횟수 >= 가능횟수 이면 더이상 못부순다.
					if(l.k >= K )
						continue;
					if(visited[x][y][l.k+1] == true)
						continue;
					
					q.offer(new location(x, y, l.cnt+1, l.k+1));
					visited[x][y][l.k+1] = true;
					
				}
				else {
					if(visited[x][y][l.k] == true)
						continue;
					
					q.offer(new location(x, y, l.cnt+1, l.k));
					visited[x][y][l.k] = true;
				}
			}
		}
		System.out.println(-1);
	}

}
class location{
	int x;
	int y;
	int cnt;
	int k;
	location(int x, int y, int cnt, int k){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.k = k;
	}
}