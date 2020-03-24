package org.baekjoon;

import java.util.*;

public class test15558_jumpGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] game = new int[2][n+1];
		boolean[][] visited = new boolean[2][n+1];
		for (int i = 0; i < 2; i++) {
			String str = sc.next();
			for (int j = 1; j <= n; j++) {
				game[i][j] = Integer.parseInt(str.charAt(j-1) + "");
			}
		}

		int is_possible = 0;
		Queue<Gamedot> q = new LinkedList<>();
		int time = 0;
		q.offer(new Gamedot(0, 1));

		while (!q.isEmpty()) {
			Gamedot dot = q.poll();
			// visited[dot.x][dot.y] = true;
			int[] dx = { dot.x, dot.x, (dot.x + 1) % 2 };
			int[] dy = { dot.y+1, dot.y-1, dot.y+k };

			time++;
			for (int i = 0; i < 3; i++) {
				int x = dx[i];
				int y = dy[i];
				//System.out.println("x="+x+" y="+y+" time="+time);
				// -- 게임에서 이김
				if (y > n) {
					is_possible = 1;
					q.clear();
					break;
				}
				
				if( time <= y)
					continue;
				
				if (visited[x][y] == false && game[x][y] == 1) {
					visited[x][y] = true;
					q.offer(new Gamedot(x, y));
					//System.out.println("x="+x+" y="+y+" time="+time);
				}
				
			}
			visited[0][time] = true;
			visited[1][time] = true;
		}
		System.out.println(is_possible);

	}

}

class Gamedot {
	int x;
	int y;

	Gamedot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
