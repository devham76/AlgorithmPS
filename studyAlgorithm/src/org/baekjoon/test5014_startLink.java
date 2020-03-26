package org.baekjoon;

import java.io.*;
import java.util.*;

public class test5014_startLink {

	static Queue<Integer> q;
	static int up, down, gole;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int F = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		gole = Integer.parseInt(st.nextToken());
		up = Integer.parseInt(st.nextToken());
		down = Integer.parseInt(st.nextToken());

		arr = new int[F + 1];
		Arrays.fill(arr, -1);
		q = new LinkedList<>();
		q.offer(start);

		bfs();
		
		if(arr[gole] == -1 && start != gole)
			System.out.println("use the stairs");
		else
			System.out.println(arr[gole]+1);
		

	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int current = q.poll();
			if (current == gole) {
				return;
			}
			
			int[] next = { current + up, current - down };
			
			for (int i = 0; i < 2; i++) {
				if (next[i] <= 0 || next[i] > gole || arr[next[i]] != -1)
					continue;

				arr[next[i]] = arr[current]+1;


				q.offer(next[i]);
			}

		}

	}

}
