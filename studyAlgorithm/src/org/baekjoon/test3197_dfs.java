package org.baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test3197_dfs {
	static char[][] map;
	static boolean[][] visited;
	static dot8[] swan;
	static int r, c;
	static int day = 0;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Queue<dot8> nextQ, swanWaterQ, waterQ;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();

		map = new char[r][c];
		visited = new boolean[r][c];
		swan = new dot8[2];
		int swanIdx = 0;
		waterQ = new LinkedList<>(); // 물위치

		for (int i = 0; i < r; i++) {
			String str = sc.next();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);

				/// 백조위치를 저장한다.
				if (map[i][j] == 'L') {
					swan[swanIdx++] = new dot8(i, j);
				} else if (map[i][j] == '.') {
					// 물의 위치를 저장한다.
					waterQ.offer(new dot8(i, j));
				}
			}
		}

		// 첫번째 백조 주변의 물 위치
		swanWaterQ = new LinkedList<>();
		visited[swan[0].x][swan[0].y] = true;
		swanWaterQ.offer(swan[0]);

		while (checkMeet() == false) { // 백조 두개가 만나는지 확인
			nextDayMap();	// 다음날 얼음을 녹인다.
			day++;
		}
		System.out.println(day);
	}

	private static void nextDayMap() {
		// 당일 발견한 물 위치를 확인하며 얼음을 녹인다.
		int size = waterQ.size();
		for (int i = 0; i < size; i++) {
			dot8 dot = waterQ.poll();
			for (int j = 0; j < 4; j++) {
				int x = dot.x + dx[j];
				int y = dot.y + dy[j];
				
				if (x < 0 || x >= r || y < 0 || y >= c)
					continue;
				
				// 얼음이면 물로 변경해준다
				if(map[x][y] == 'X') {
					map[x][y] = '.';
					// 다음날 이 위치를 돌며 만나는 얼음을 녹일예정이다.
					waterQ.offer(new dot8(x,y));	
				}
			}
		}
	}

	// 첫번째 백조가 있는 물 주변을 조사해서
	// 1. 두번째 백조와 만나는지 확인
	// 2. 물에 인접하여 다음날 얼음이 될곳을 저장
	private static boolean checkMeet() {

		// 물에 인접한 얼음
		nextQ = new LinkedList<>();

		while (!swanWaterQ.isEmpty()) {
			dot8 dot = swanWaterQ.poll();

			// 두번째 백조에게 갈수있음.
			if (swan[1].x == dot.x && swan[1].y == dot.y) {
				return true;
			}

			for (int i = 0; i < 4; i++) {
				int x = dot.x + dx[i];
				int y = dot.y + dy[i];
				if (x < 0 || x >= r || y < 0 || y >= c)
					continue;

				if (visited[x][y] == true)
					continue;

				visited[x][y] = true;

				// 물에 인접한 얼음으로 다음날에 물이 된다.
				if (map[x][y] == 'X') {
					nextQ.offer(new dot8(x, y));
				} else {
					swanWaterQ.offer(new dot8(x, y));
				}

			}
		}
		swanWaterQ = nextQ; // 다음날 물이 되어 검색할 곳 // 첫번째 백조 주변의 물 위치
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