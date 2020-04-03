package org.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level3_49191 {

	public static void main(String[] args) {
		int n = 5;
		int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
		solution(n, results);
	}

	public static int solution(int n, int[][] results) {

		List<ArrayList<Integer>> graphList = new ArrayList<>();

		// base
		for (int i = 0; i <= n; i++) {
			graphList.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < results.length; i++) {
			// 진곳->이긴곳
			graphList.get(results[i][1]).add(results[i][0]);
		}
		int[][] info = new int[n + 1][2]; // 노드n에서 갈수있는 0, 올수있는 1
		for (int startnode = 1; startnode <= 5; startnode++) {
			boolean[] visited = new boolean[n + 1];
			int goCount = 0;
			Queue<Integer> q = new LinkedList<>();
			q.offer(startnode);
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (Integer nextNode : graphList.get(cur)) {
					if (visited[nextNode] == false) {
						info[nextNode][1]++;
						goCount++;
						visited[nextNode] = true;
						q.add(nextNode);
					}
				}
			}
			info[startnode][0] = goCount;

		}
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (info[i][0] + info[i][1] == n - 1)
				answer++;
		}
		return answer;

	}
}
