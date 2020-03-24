package org.baekjoon;

import java.util.*;

public class test1697_hideSeek {

	static Queue<Integer> q;	// 다음 회에 들어갈 위치
	static int road[];			// road[i] = j i위치에 j시간이 걸린다
	static int dongsang;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int subin = sc.nextInt();
		dongsang = sc.nextInt();
		
		if(subin == dongsang)
			System.out.println("0");
		else {
			road = new int[100001];
			q = new LinkedList<>();
			q.add(subin);
			bfs();
		}
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			int current = q.poll();
			int[] move = {current-1 , current+1, current*2};
			
			// 3가지 방법으로 움직일수있다.
			for(int i=0; i<3; i++) {
				int next = move[i];
				
				// 범위를 벗어날수없다
				if(next < 0 || next >= 100001)
					continue;
				
				// 이미 다녀간적이 있다면 나간다
				if(road[next] != 0)
					continue;
				
				// 현재위치에서 다음으로 1회 이동했으므로, 다음 위치 이동수 = 현재까지 이동수+1 
				road[next] = road[current]+1;	
				
				if(next == dongsang) {
					System.out.println(road[next]);
					return;
				}
				
				q.add(next);
				
			}
		}
		
	}

}
