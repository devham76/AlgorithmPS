package org.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class kakao_2017_gps_1837 {

	public static void main(String[] args) {

		int n = 7;
		int m = 10;
		int[][] edge_link = { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 3, 5 }, { 4, 6 }, { 5, 6 }, { 5, 7 },
				{ 6, 7 } };
		int k = 6;
		int[] gps_log = { 1, 3, 2, 6 };
		solution(n, m, edge_link, k, gps_log);

	}

	public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
		int answer = 0;

		int[][] map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			map[i][i] = 1;
		}
		for (int i = 0; i < edge_list.length; i++) {

			map[edge_list[i][0]][edge_list[i][1]] = 1;
			map[edge_list[i][1]][edge_list[i][0]] = 1;
		}

		int[] visited = new int[n + 1];
		Queue<Integer> q = new LinkedList<>();
		int same = 0;
		for (int i = 0; i < gps_log.length - 1; i++) {
			if (gps_log[i] == gps_log[i + 1])
				same++;

			if (map[gps_log[i]][gps_log[i + 1]] != 1) {
				System.out.println(gps_log[i] + " , " + gps_log[i + 1]);
				int start = gps_log[i];
				int end = gps_log[i + 1];
				q.offer(start);

				while (!q.isEmpty()) {
					int now = q.poll();
					for (int next = 1; next <= n; next++) {
						if (now == next)
							continue;
						if (map[now][next] == 1 && visited[next] == 0) {
							q.add(next);
							System.out.println("now = " + now + " next=" + next + " visited[now]=" + visited[now]);
							visited[next] = visited[now] + 1;
							if (next == end) {
								q.clear();
								break;
							}
						}
					}
				}
				System.out.println(visited[end]);
			}
			visited = new int[n + 1];
		}
		return answer;
	}
}
