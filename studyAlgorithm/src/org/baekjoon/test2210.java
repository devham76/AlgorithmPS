package org.baekjoon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class test2210 {
	static HashSet<String> hs;
	static int[][] board;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		board = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		hs = new HashSet<>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				List<Integer> list = new LinkedList<>();
				list.add(board[i][j]);
				dfs(list, i, j);
			}
		}

		System.out.println(hs.size());
	}

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	private static void dfs(List<Integer> list, int x, int y) {

		if (list.size() == 6) {
			StringBuffer sb = new StringBuffer();
			for (Integer l : list) {
				sb.append(l);
			}
			String str = new String(sb);
			if (!hs.contains(str)) {
				hs.add(str);
				
			}

			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5)
				continue;

			list.add(board[nx][ny]);
			dfs(list, nx, ny);
			list.remove(list.size() - 1);
		}

	}

}
