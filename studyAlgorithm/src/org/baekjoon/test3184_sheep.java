package org.baekjoon;

import java.util.*;

public class test3184_sheep {

	static int n, m;
	static char map[][];
	static boolean visited[][];
	static int sheep = 0, wolf = 0;
	static Queue<dot4> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String str = sc.next();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int Wolf = 0, Sheep=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				
				if(map[i][j] != '#' && visited[i][j] == false) {
					q = new LinkedList<>();
					q.offer(new dot4(i,j));
					bfs();
					//System.out.println("wolf="+wolf+", sheep="+sheep);
					if (sheep > wolf) 
						Sheep += sheep;
					else
						Wolf += wolf;
					wolf = 0;
					sheep = 0;
				}
			}
		}
		
		System.out.println(Sheep+" "+Wolf);
	}

	static int[] dx = {1,-1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	private static void bfs() {
		while(!q.isEmpty()) {
			dot4 dot = q.poll();
			if(map[dot.x][dot.y] == 'v') {
				wolf++;
			}
			if(map[dot.x][dot.y] == 'o') {
				sheep++;
			}
			visited[dot.x][dot.y] = true;
			for(int i=0; i<4; i++) {
				int nx = dot.x + dx[i];
				int ny = dot.y + dy[i];
				
				if(nx < 0 || nx >=n || ny < 0 || ny>= m)
					continue;
				if(visited[nx][ny] == true || map[nx][ny] == '#')
					continue;
				
				visited[nx][ny] = true;
				
				q.offer(new dot4(nx, ny));
				
				
			}
		}
		
	}

}
class dot4{
	int x;
	int y;
	dot4(int x, int y){
		this.x = x;
		this.y = y;
	}
}