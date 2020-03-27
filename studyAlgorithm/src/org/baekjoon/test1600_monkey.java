package org.baekjoon;

import java.io.*;
import java.util.*;

public class test1600_monkey {
	static int[][] map;
	static boolean[][][] visited;
	static int K, w, h;
	static Queue<dot5> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[w][h];
		visited = new boolean[w][h][31];
		// visited[x][y][k] : (x,y) 까지 k번 말처럼 갔다.를 표시한다.
		for (int i = 0; i < w; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < h; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0][0][0] = true;
		q = new LinkedList<>();
		q.offer(new dot5(0, 0, 0, K));
		bfs();

	}

	static int[] hx = { -2, -2, 2, 2, -1, -1, 1, 1 };
	static int[] hy = { -1, 1, -1, 1, -2, 2, -2, 2 };

	static int[] mx = { 1, -1, 0, 0 };
	static int[] my = { 0, 0, 1, -1 };

	private static void bfs() {
		while (!q.isEmpty()) {

			dot5 dot = q.poll();

			if (dot.x == w - 1 && dot.y == h - 1) {
				System.out.println(dot.cnt);
				return;
			}

			if (dot.x < 0 || dot.x >= w || dot.y < 0 || dot.y >= h)
				continue;
			if (visited[dot.x][dot.y][dot.k] == true || map[dot.x][dot.y] == 1)
				continue;

			visited[dot.x][dot.y][dot.k] = true;

			for (int i = 0; i < 4; i++) {
				int x = dot.x + mx[i];
				int y = dot.y + my[i];
				q.add(new dot5(x, y, dot.cnt + 1, dot.k));

			}

			if (dot.k <= 0)
				continue;

			for (int i = 0; i < 8; i++) {
				int x = dot.x + hx[i];
				int y = dot.y + hy[i];
				q.add(new dot5(x, y, dot.cnt + 1, dot.k - 1));

			}

		}
		System.out.println(-1);
		return;
	}

}

class dot5 {
	int x;
	int y;
	int cnt;
	int k;

	dot5(int x, int y, int cnt, int k) {
		this.x = x;
		this.y = y;
		this.k = k;
		this.cnt = cnt;
	}
}