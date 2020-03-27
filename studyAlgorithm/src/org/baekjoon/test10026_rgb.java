package org.baekjoon;

import java.util.*;

public class test10026_rgb {

	static boolean[][] visited;
	static char[][] map;
	static Queue<dot6> q  = new LinkedList<>();
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new char[n][n];

		for (int i = 0; i < n; i++) {
			String st = sc.next();
			for (int j = 0; j < n; j++) {
				char color = st.charAt(j);
				map[i][j] = color;
			}
		}

		visited = new boolean[n][n];
		int result = 0;
		
		for (int type = 0; type < 2; type++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j] == false) {
						result++;
						q.offer(new dot6(i, j));
						solution(type);
					}
				}
			}
			System.out.print(result+" ");

			visited = new boolean[n][n];
			result = 0;
		}
		
	}

	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
 	private static void solution(int type) {
		// type 0: 색약x 1: 색약
		while(!q.isEmpty()) {
			dot6 dot = q.poll();
			visited[dot.x][dot.y] = true;
			
			int color = map[dot.x][dot.y];
			for(int i=0; i<4; i++) {

				int x = dot.x + dx[i];
				int y = dot.y + dy[i];
				
				if(x < 0 || x>=n || y<0 || y >=n )
					continue;
				if(visited[x][y] == true)
					continue;
				
				if(type == 0) {
					if(color != map[x][y])
						continue;
				}
				else if (type == 1) {
					if( ((color == 'R' || color =='G' )&& map[x][y] == 'B') || 
							(color=='B' && color !=map[x][y]))
						continue;
				}
				
				q.offer(new dot6(x,y));
				visited[x][y] = true;
			}
			
		}
		
	}

}
class dot6 {
	int x;
	int y;
	dot6(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
