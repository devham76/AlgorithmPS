package org.kakao;

import java.util.LinkedList;
import java.util.Queue;

public class kakao_interen_2005_4 {

	public static void main(String[] args) {
		int[][] b = { 
				{0, 0, 0, 0, 0, 0}, 
				{0, 1, 1, 1, 1, 0},
				{0, 1, 1, 0, 0, 1}, 
				{0, 1, 0, 1, 0, 1}, 
				{0, 1, 0, 0, 0, 1}, 
				{0, 0, 0, 1, 0, 0} };
		solution(b);
	}

    static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int n = 0;
	static int min = 25 * 500;

	public static int solution(int[][] board) {

		n = board.length;
		for (int i = 0; i < 4; i++) {
			
			visited = new boolean[n][n];
			visited[0][0] = true;
			String str = "(0,0,"+i+")";
			dfs(0, 0, i, 0, board, str);
			
			//bfs(i, board);
		}
		return min;
	}

	private static void bfs(int dir, int[][] board) {
		
		visited = new boolean[n][n];
		visited[0][0] = true;

		pos pos = new pos(0, 0, dir, 0);
		Queue<pos> q = new LinkedList<>();
		q.add(pos);

		while (!q.isEmpty()) {
			pos now = q.poll();
			//System.out.println("x="+now.x + " y="+now.y+ " m="+now.money);
			if(now.x == n-1 && now.y == n-1) {
				System.out.println(now.money);
				min = Math.min(min, now.money);
			}
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if ( nx >= n ||  ny >= n)
					continue;

				if (board[nx][ny] == 1)
					continue;

				//System.out.println("nx="+nx + " ny="+ny );
				if (i == now.dir) {
					q.offer(new pos(nx, ny, i, now.money + 100));
				} else {
					q.offer(new pos(nx, ny, i, now.money + 600));
				}
			}
		}

	}

	static boolean[][] visited;

	private static void dfs(int x, int y, int dir, int money, int[][] board, String str) {
		if(min < money)
            return;
		if (x == n - 1 && y == n - 1) {
			min = Math.min(min, money);
			System.out.println(money);
			System.out.println(str);
		}

		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;

			if (visited[nx][ny] == true || board[nx][ny] == 1)
				continue;
			visited[nx][ny] = true;
			//System.out.println("x="+nx+" y="+ny+ " i="+i);
			if (i == dir) {
				dfs(nx, ny, i, money + 100, board, str + "(" + nx + "," + ny + " "+i+")");
			} else {
				dfs(nx, ny, i, money + 600, board, str + "(" + nx + "," + ny + " "+i+")");
			}
			visited[nx][ny] = false;

		}
	}
}

class pos {
	int x;
	int y;
	int dir;
	int money;

	pos(int x, int y, int dir, int money) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.money = money;
	}
}