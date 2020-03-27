package org.baekjoon;

import java.util.*;

public class test2234 {
	static int[][] map;
	static boolean[][] visited;
	static int n, m;
	static int num = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		/*
		 * 성 전체를 돌면서 방그룹의 개수와 각방의 개수를 구한다.
		 * */
		int maxRoom = 0;	// 가장 많은 방의 수
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == false) {
					++num;	// 방 그룹의 수
					// (i,j)가 속한 방 그룹의 방개수를 구한다.
					int curCount = roomInfo(new dot7(i, j));
					if (maxRoom < curCount) {
						maxRoom = curCount;
					}
				}
			}
		}

		System.out.println(num + "\n" + maxRoom);

		maxRoom = 0;
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 성문을 하나씩 없애서 해당 그룹의 방개수를 구한다
				// 방개수들 중에 가장 큰값을 구한다.
				for (int k = 1; k < 16; k *= 2) {
					// 벽이 없으면 패쓰. 해당자리가 1(벽)인지 확인한다.
					// 1&1 = 1(벽), 0&1 = 0(벽없음)
					if ((map[i][j] & k) != k)
						continue;

					// 벽이 있을때
					map[i][j] -= k; // 벽 없애기
					if (visited[i][j] == false) {
						int curCount = roomInfo(new dot7(i, j));
						if (maxRoom < curCount) {
							maxRoom = curCount;
						}
					}
					map[i][j] += k; // 벽 복구
					visited = new boolean[n][m]; // 해당방그룹에 방문한 이력 초기화
				}
				
			}
		}
		System.out.println(maxRoom);

	}
 
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	// startdot이 속한 방 그룹의 방개수를 구한다.
	private static int roomInfo(dot7 startdot) {
		int sum = 0;
		Queue<dot7> q = new LinkedList<>();
		q.offer(startdot);

		while (!q.isEmpty()) {
			sum++;
			dot7 dot = q.poll();
			visited[dot.x][dot.y] = true;

			// 벽이없어야 지나갈수있다. 1이아니여야 지나갈수있다.
			for (int i = 1; i < 16; i *= 2) {
				if ((map[dot.x][dot.y] & i) != i) {
					int direction = i/2;
					if(i == 8) direction--;
					
					int x = dot.x + dx[direction];
					int y = dot.y + dy[direction];

					if (x < 0 || x >= n || y < 0 || y >= m)
						continue;

					if (visited[x][y] == true)
						continue;

					visited[x][y] = true;
					q.offer(new dot7(x, y));

				}
			}

		}
		return sum;

	}

}

class dot7 {
	int x;
	int y;

	dot7(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
