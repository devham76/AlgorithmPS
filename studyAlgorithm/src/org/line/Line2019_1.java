package org.line;

import java.util.*;

public class Line2019_1 {
	static int cony, brown;
	static int cRoad[];
	static int bRoad[];
	static Queue<Integer> cQ, bQ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cony = sc.nextInt();
		brown = sc.nextInt();

		if (cony != brown) {
			cRoad = new int[100001];
			bRoad = new int[100001];
			cQ = new LinkedList<>();
			bQ = new LinkedList<>();
			
			cQ.add(cony);
			bQ.add(brown);
			bfs();
		} else
			System.out.println(0);
	}

	static int count = 0;

	public static void bfs() {
		int time = 0;
		while (true) {

			int size = q.size();
			for (int s = 0; s < size; s++) {
				int current = q.poll();
				int[] move = { current - 1, current + 1, current * 2 };
				// 큐에 입력할때 방문확인하지 않고 	꺼낼때 확인
				visited[current] = true;
				// 3가지 방법으로 움직일수있다.
				for (int i = 0; i < 3; i++) {
					int next = move[i];

					// 범위를 벗어날수없고, 방문한곳은 못들어간다
					if (next >= 0 && next < 100001 && visited[next] == false) {
						q.add(next);
						road[next] = current;
						if (next == dongsang) {
							// 숨바꼭질4일땐 추적.
							/*
							int before = next;
							for(int k=0; k<time;k++) {
								System.out.print(road[before]+" ");
								before = road[before];
							}
							*/
							count++;
						}
						
					}

				}
			}
			time++;
			// 최소시간일때 도착하면 처음 count가 0보다 커지니까 그 이상의 시간은 볼필요없으므로 종료
			if(count > 0)
				break;
		}
		System.out.println();
		System.out.println(time + "\n" + count);

	}

}
