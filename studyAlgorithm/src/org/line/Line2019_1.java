package org.line;

import java.util.*;

public class Line2019_1 {
	static int cony, brown;
	static Queue<int[]> q;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cony = sc.nextInt();
		brown = sc.nextInt();

		if (cony != brown) {
			int[] position = { cony, brown, 0 };
			q = new LinkedList<>();
			visited = new boolean[200001];
			q.offer(position);
			bfs();
		} else
			System.out.println(0);
	}

	static int count = 0;

	public static void bfs() {
		int time = 1;
		while (true) {
		
			int size = q.size();
			for (int s = 0; s < size; s++) {
				
				int[] current = q.poll();
				visited[ current[1] ] = true;
				int[] move = { current[1] - 1, current[1] + 1, current[1] * 2 };
				int nextCony = current[0] + time;
				// 3가지 방법으로 움직일수있다.
				for (int i = 0; i < 3; i++) {
					int nextBrown = move[i];

					// 브라운은 범위를 벗어날수없고, 방문하지 않은 곳만 방문가능하다.
					if (nextBrown > 0 && nextBrown < 200001 && visited[nextBrown] == false) {
						System.out.println("cony:"+nextCony+" brown:"+nextBrown+" time:"+time);
						int[] newPosition = { nextCony, nextBrown, time };
						q.add(newPosition);
						visited[nextBrown] = true;
						if (nextCony == nextBrown) {
							System.out.println(time);
							return;
						}

					}

				}
			}
			time++;
		}

	}

}
