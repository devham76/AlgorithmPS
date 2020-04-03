package org.psStrategies;

import java.util.Scanner;

public class test5 {
	static int n, m, a, b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();

		if (n <= a || m <= b) {
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
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(map[a][b] + "\n" + (a + b));
	}

}
