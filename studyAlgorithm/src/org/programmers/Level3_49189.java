package org.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Level3_49189 {

	public static void main(String[] args) {
		int[][] edge = { { 7, 5 }, { 4, 5 }, { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 2 }, { 2, 4 } };
		int n = 7;
		solution(n, edge);
	}

	public static int solution(int n, int[][] edge) {
		boolean[] visited = new boolean[n + 1];
		int[][] info = new int[n + 1][n + 1];
		for (int i = 0; i < edge.length; i++) {
			info[edge[i][0]][edge[i][1]] = 1;
			info[edge[i][1]][edge[i][0]] = 1;
		}

		Queue<Integer> nextQ = new LinkedList<>();
		nextQ.offer(1);
		visited[1] = true;
		int size=0;
		while (!nextQ.isEmpty()) {
			size = nextQ.size();
			
			for (int i = 0; i < size; i++) {
				int cur = nextQ.poll();
				visited[cur] = true;
				for (int j = 2; j <= n; j++) {
					if (info[cur][j] == 1 && visited[j] == false) {
						nextQ.offer(j);
						visited[j] = true;
					}
				}
			}
		}
		System.out.println(size);
		return size;
	}
}
