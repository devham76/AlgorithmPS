package org.psStrategies;

import java.util.Scanner;

/*
 * [문제]
 * n,m크기의 맵에서 (a,b)위치에 보물이 있을때, 최단거리로 도착할경우의수와 최단거리 출력
 * 
 * */

public class test5 {
	static int n, m, a, b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();

		if ((a == 0 && b == 0) || n <= a || m <= b) {
			System.out.println("fail");
		} else {

			solve();

		}

	}

	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };

	private static void solve() {
		boolean[][] visited = new boolean[a + 1][b + 1];
		int[][] map = new int[a + 1][b + 1];
		map[0][0] = 1;
		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {

				for (int k = 0; k < 2; k++) {
					int x = i + dx[k];
					int y = j + dy[k];
					if (x > a || y > b)
						continue;

					map[x][y] += map[i][j];
				}

			}
		}

		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(map[a][b] + "\n" + (a + b));
	}

	/*
	 장애물이 없고, 맵의 크기가 작으니까, 수학적 접근가능
	 1. 1로 초기화하고 
	 dp[i][0] = 1
	 dp[0][1] = 1
	 2. dp[i][j] = dp[i-1][j] + dp[i][j-1] 이용.
	 0C0 0C1 0C2 0C3
	 1C0 1C1 1C2 1C3
	 2C0 2C1 2C2 2C3
	 3C0 3C1 3C2 3C3
	 * */
}
