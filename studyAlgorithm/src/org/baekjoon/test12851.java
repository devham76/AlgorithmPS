package org.baekjoon;

import java.io.*;
import java.util.*;

public class test12851 {
	
	static int N,K;
	static int road[] = new int[100001];
	static Queue<Integer> q;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Arrays.fill(road, -1);
		if(N == K) { 
			sb.append(0+"/n"+0);
		}
		else {
			q = new LinkedList<>();
			q.add(N);

			bfs();
			System.out.println(depth+" "+answer);
		}
		
	}
	static int depth = 0;
	private static void bfs() {
		//int depth = 0;
		while(!q.isEmpty()) {
			depth++;
			int size = q.size();
			
			// size를 구하고 기존에 큐에 있던 만큼만 반복함으로써 몇번째 depth인지 알 수 있다. 
			for(int i = 0 ; i < size ; ++i) {
				int cur = q.poll();
				// 다음과 같이 배열을 선언하므로써 코드를 많이 줄일 수 있었다.
				int[] next = { cur + 1, cur - 1, cur * 2};
				
				for(int j = 0 ; j < 3 ; ++j) {
					if(next[j] >= 0 && next[j] <= 100001 &&
					   road[next[j]] == - 1) { // 이전 방문 여부 확인
						road[next[j]] = cur; // 방문했다고 기록 
						
						if(next[j] == K) answer++; // 다음으로 방문할 곳이 K면 depth를 리턴 
						
						q.offer(next[j]);
					}
				}
			}
			if(answer > 0)
				return;
		}
	}

}
