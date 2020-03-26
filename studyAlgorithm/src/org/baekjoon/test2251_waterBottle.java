package org.baekjoon;

import java.util.*;

public class test2251_waterBottle {
	static int a, b, c;
	static Queue<int[]> q;
	static HashSet<String> hs;
	static int[] origin;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		origin = new int[3];
		for (int i = 0; i < 3; i++) {
			origin[i] = sc.nextInt();
		}
		
		q = new LinkedList<>();
		hs = new HashSet<>();
		int[] first = {0,0,origin[2]};
		q.offer(first);

		bfs();

	}

	private static void bfs() {
		List<Integer> list = new ArrayList<>();
		while (!q.isEmpty()) {
			int[] bottle = q.poll();
			if (bottle[0] == 0)
				list.add(bottle[2]);

			for (int give = 0; give < 3; give++) {
				for (int j = 1; j < 3; j++) {
					int[] newBottle = bottle.clone();
					int receive = (give + j) % 3;
					//System.out.println("give="+give+" receive="+receive+" bottle[give]="+bottle[give]);
					// 주는 쪽이 0 이면 변화 없으므로 나간다.
					if (bottle[give] == 0 || bottle[receive] == origin[receive])
						continue;
					
					if (bottle[give]+bottle[receive] > origin[receive]) {
						newBottle[give] = bottle[give] - (origin[receive]-newBottle[receive]);
						newBottle[receive] = origin[receive];
					}else {
						newBottle[receive] += bottle[give];
						newBottle[give] = 0;
					}
					
					String str = "";
					for(Integer b : newBottle) {
						str += b;
					}
					if(!hs.contains(str)) {
						q.offer(newBottle);
						hs.add(str);
					}
					
				}
			}

		}
		
		Collections.sort(list);
		for(int i=0; i<list.size()-1; i++)
			System.out.print(list.get(i)+" ");

	}

}
