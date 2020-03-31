package org.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test3197_dfs {
	static char[][] map;
	static boolean[][] visited;
	static dot8 swan;
	static int r, c;
	static int day = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		map = new char[r][c];

		visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			String str = sc.next();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'L') {
					swan = new dot8(i, j);
				}
			}
		}

		while (checkMeet() == false) {
			System.out.println("check meet false");
			map = nextDayMap();
		}
		System.out.println(day);
	}

	private static char[][] nextDayMap() {
		//char[][] newMap = map.clone();
		char[][] newMap = new char[r][c];
		visited = new boolean[r][c];

		Queue<dot8> q = new LinkedList<>();
		q.offer(new dot8(0, 0));
		while (!q.isEmpty()) {
			dot8 dot = q.poll();
			char now = map[dot.x][dot.y];
			for (int i = 0; i < 4; i++) {
				int x = dot.x + dx[i];
				int y = dot.y + dy[i];
				if (x < 0 || x >= r || y < 0 || y >= c)
					continue;

				if (visited[x][y] == true)
					continue;
				
				if (now != 'X' && map[x][y] == 'X')
					newMap[x][y] = '.';
				else
					newMap[x][y] = map[x][y];

				q.offer(new dot8(x, y));
				visited[x][y] = true;
			}
			
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println("----");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(newMap[i][j]);
			}
			System.out.println();
		}
		return null;
	}

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	private static boolean checkMeet() {
		visited = new boolean[r][c];
		Queue<dot8> q = new LinkedList<>();
		q.offer(swan);
		while (!q.isEmpty()) {
			dot8 dot = q.poll();
			visited[dot.x][dot.y] = true;
			// System.out.println(dot.x+" "+dot.y);
			for (int i = 0; i < 4; i++) {
				int x = dot.x + dx[i];
				int y = dot.y + dy[i];
				if (x < 0 || x >= r || y < 0 || y >= c)
					continue;
				if (visited[x][y] == true || map[x][y] == 'X')
					continue;

				if (map[x][y] == 'L') {
					return true;
				}

				q.offer(new dot8(x, y));
				visited[x][y] = true;
			}
		}
		return false;
	}

}

class dot8 {
	int x;
	int y;

	dot8(int x, int y) {
		this.x = x;
		this.y = y;
	}
}