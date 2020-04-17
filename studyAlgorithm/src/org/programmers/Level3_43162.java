package org.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Level3_43162 {

	public static void main(String[] args) {
		int[][] c = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		solution(3, c);
	}

	public static int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visited = new boolean[n];
		Queue<Integer> q = new LinkedList<>();
		int all = 0;

		// 0번부터 시작
		q.offer(0);
		all++;
		
		while (true) {

			while (!q.isEmpty()) {
				int now = q.poll();
				visited[now] = true;

				for (int i = 0; i < n; i++) {
					// 서로 연결되어있고, 방문하지 않은곳이라면 큐에 삽입.
					if (computers[now][i] == 1 && visited[i] == false) {
						q.offer(i);
						visited[i] = true;
						all++;
					}
				}
			}
			answer++;

			// 모든 지점을 방문했다면 끝.
			if (all >= n)
				break;

			// 방문하지 않은 지점 1곳을 방문.
			for (int i = 0; i < n; i++) {
				if (visited[i] == false) {
					q.offer(i);
					all++;
					break;
				}
			}

		}

		System.out.println(answer);
		return answer;
	}
}
