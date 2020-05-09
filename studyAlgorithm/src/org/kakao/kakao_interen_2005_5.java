package org.kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class kakao_interen_2005_5 {

	public static void main(String[] args) {
		int[][] p = { { 0, 1 }, { 0, 3 }, { 0, 7 }, { 8, 1 }, { 3, 6 }, { 1, 2 }, { 4, 7 }, { 7, 5 } };
		int[][] o = { { 8, 5 }, { 6, 7 }, { 4, 1 } };
		solution(9, p, o);
	}

	static int[][] room;
	static HashMap<Integer, List<Integer>> hm;
	static HashSet<Integer> pass;

	public static boolean solution(int n, int[][] path, int[][] order) {

		room = new int[n][n];

		// 지나가고 싶은 공간, 지나와야하는공간
		hm = new HashMap<>();
		// 지나친공간
		pass = new HashSet<>();
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < 2; j++) {
				room[path[i][0]][path[i][1]] = 1;
				room[path[i][1]][path[i][0]] = 1;
			}
		}

		for (int i = 0; i < order.length; i++) {
			if (hm.containsKey(order[i][0])) {
				hm.get(order[i][1]).add(order[i][0]);
			} else {
				List<Integer> l = new ArrayList<>();
				l.add(order[i][0]);
				hm.put(order[i][1], l);
			}
		}
		int passcnt = pass.size();
		do {
			passcnt = pass.size();
			dfs(0);
		} while (passcnt != pass.size()); // 더이상 추가되는 공간이 없으면 끝
		
		if(passcnt == n)
			return true;
		else
			return false;
	}

	static boolean[] visited;

	private static void dfs(int r) {
		int n = room.length;
		visited = new boolean[room.length];
		Queue<Integer> q = new LinkedList<>();
		q.add(r);

		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < room.length; i++) {
				if (room[now][i] == 1) {
					if (visited[i] == true)
						continue;

					if (hm.containsKey(i) == true) {
						List<Integer> l = hm.get(i);
						for (int j = 0; j < l.size();) {
							if (pass.contains(l.get(j))) {
								l.remove(j);
							} else
								j++;
						}
						if (l.size() == 0) {
							pass.add(i);
							hm.remove(i);
							q.add(i);
							visited[i] = true;
						}
					} else {
						pass.add(i);
						q.add(i);
						visited[i] = true;
					}
				}
			}
		}

	}
}