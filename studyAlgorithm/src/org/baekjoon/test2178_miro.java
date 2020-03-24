package org.baekjoon;

import java.io.*;
import java.util.*;

public class test2178_miro {

	static int[][] map;
	static int[][] way;
	static int n,m;
	static Queue<dot3> q; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		way = new int[n][m];
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(line.charAt(j)+"");
			}
		}
		//Arrays.fill(way,200);
		
		q = new LinkedList<>();
		way[0][0] = 1;
		q.add(new dot3(0,0));
		bfs();
		System.out.println(way[n-1][m-1]);
		
	}
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	private static void bfs() {
		
		while (!q.isEmpty()) {
			dot3 dot = q.poll();
			// 4방향으로 움직일 수 있다.
			for(int i=0; i<4; i++) {
				int x = dot.x + dx[i];
				int y = dot.y + dy[i];
				if(x < 0 || x >= n || y < 0 || y >= m)
					continue;
				// 못가는 길 or 이미 지나간길
				if(map[x][y] == 0 || way[x][y] != 0)
					continue;
				
				way[x][y] = way[dot.x][dot.y]+1;
				q.add(new dot3(x,y));
			}
		}
		
	}

}
class dot3{
	int x;
	int y;
	dot3(int x, int y){
		this.x = x;
		this.y = y;
	}
}
