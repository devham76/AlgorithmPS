package org.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class kakao_1836 {

	public static void main(String[] args) {
		String[] b = { "NRYN", "ARYA" };
		solution(2, 4, b);

	}

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static char[][] cboard;
	static boolean[][] visited;
	static List<Character> list = new ArrayList<>();
	static List<Character> list1, list2;

	public static String solution(int m, int n, String[] board) {
		String answer = "";
		int allCnt = 0;
		cboard = new char[m][n];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				cboard[i][j] = board[i].charAt(j);
				if (cboard[i][j] != '.' && cboard[i][j] != '*')
					allCnt++;
			}
		}

		int cnt = 0;
		// 1. 바로 옆 4방에 있는지 검사
		/*
		list1 = new ArrayList<>();
		cnt = check_4area();
		System.out.println("check_4area = " + cnt);
		Collections.sort(list1);
		list.addAll(list1);
		*/
		do {
			int newcnt = 0;
			

			// 2. 한번 꺾어서 삭제 가능한지 검사
			System.out.println("second start");
			
			
			for (int i = 0; i < cboard.length; i++) {
				for (int j = 0; j < cboard[0].length; j++) {
					System.out.print(cboard[i][j]+" ");
				}
				System.out.println();
			}
			
			System.out.println();
			list2 = new ArrayList<>();
			for (int i = 0; i < cboard.length; i++) {
				for (int j = 0; j < cboard[0].length; j++) {

					if (cboard[i][j] != '.' && cboard[i][j] != '*') {
						newcnt += check_cross(i, j);
					}
				}
			}
			Collections.sort(list2);
			
			list.addAll(list2);
			System.out.println("check_cross = " + newcnt);
			cnt = newcnt;
		} while (cnt != 0); // 더이상 짝맞출것이 없을때 종료

		System.out.println("allcnt=" + allCnt);
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i));
		System.out.println("answer=" + answer);

		if (allCnt == list.size() * 2) {
			StringBuffer bf = new StringBuffer();
			for (int i = 0; i < list.size(); i++)
				bf.append(list.get(i));
			answer = new String(bf);
		} else
			answer = "IMPOSSIBLE";
		System.out.println("answer=" + answer);

		return answer;
	}

	private static int check_cross(int x, int y) {
		int count = 0;
		visited = new boolean[cboard.length][cboard[0].length];
		char obj = cboard[x][y];
		// 오른쪽, 아래 쪽만 방향 검사
		for (int k = 0; k < 4; k++) {
			visited[x][y] = true;
			count += cross(obj, x, y, k, 1);

		}

		return count;
	}

	private static int cross(char obj, int x, int y, int direction, int chance) {

		int count = 0;
		int nx = x + dx[direction];
		int ny = y + dy[direction];

		if (nx < 0 || nx >= cboard.length || ny < 0 || ny >= cboard[0].length)
			return 0;

		if (visited[nx][ny] == true || cboard[nx][ny] == '*')
			return 0;

		visited[nx][ny] = true;
		System.out.println("nx=" + nx + " ny=" + ny + "obj=" + obj + " chance=" + chance + " x=" + x + " y=" + y+ "cboard[nx][ny]="+cboard[nx][ny]);
		if (cboard[nx][ny] == obj) {
			list2.add(cboard[nx][ny]);
			System.out.println("obj="+obj);
			cboard[nx][ny] = '.';
			cboard[x][y] = '.';
			return 1;
		} else if (cboard[nx][ny] == '.') {
			count += cross(obj, nx, ny, direction, chance);

			if (chance == 1) {
				for (int i = 0; i < 4; i++) {
					if (i != direction) {
						count += cross(obj, nx, ny, i, 0);

					}
				}
			}
		}

		return count;
	}

	private static int check_4area() {
		int count = 0;
		for (int i = 0; i < cboard.length; i++) {
			for (int j = 0; j < cboard[0].length; j++) {
				char obj = cboard[i][j];
				if (obj == '.' || obj == '*')
					continue;

				// 오른쪽, 아래 쪽만 방향 검사
				for (int k = 0; k < 2; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];

					if (nx >= cboard.length || ny >= cboard[0].length)
						continue;

					if (cboard[nx][ny] == obj) {
						count++;
						list1.add(cboard[nx][ny]);
						cboard[nx][ny] = '.';
						cboard[i][j] = '.';
						break;
					}

				}

			}
		}

		return count;
	}
}
