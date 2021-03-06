package org.baekjoon;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test1260_1 {

	static boolean[] visited;	
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int node = sc.nextInt();	// 노드 개수
		int line = sc.nextInt();	// 간선 개수
		int start = sc.nextInt();		// 시작 노드
		
		// 노드 개수 만큼 인접리스트을 만들어준다. 인덱스 헷갈림을 방지하기 위해 +1 해준다.
		list = new ArrayList[node+1];	
		// 인접리스트 초기화
		for (int i=1; i< node+1; i++)
			list[i] = new ArrayList<Integer>();
			
		// 간선 개수만큼 입력이 들어 온다.
		for (int i=0; i < line; i++) {
			 int x = sc.nextInt();
			 int y = sc.nextInt();
			 
			 // 자신의 노드에서 갈 수 있는 노드를 추가해준다.
			 list[x].add(y);
			 list[y].add(x);
		}
		
		// 인접한 노드가 두개 이상일때 작은 숫자부터 방문 하므로, 오름차순으로 정렬 해준다.
		for (int i=1; i<node+1; i++)
			Collections.sort(list[i]);
		
		// 노드의 방문 여부를 표시하는 배열. false로 초기화 해준다. 인덱스 혼동 방지를 위해 node+1 해준다.
		visited = new boolean[node+1];
		dfs(start);
		System.out.println();
		
		// 노드 방문 여부 표시 배열 초기화
		visited = new boolean[node+1];
		bfs(start);
		
		sc.close();
	}
	
	static void bfs(int start) {
		// bfs는 큐로 해결.
		Queue<Integer> qu = new LinkedList<Integer>();
		
		// 첫번째 노드를 방문한다.
		qu.add(start); 
		visited[start] = true;
		
		// 큐메 넣고(방문) 빼면서 , 큐가 빌때까지 반복한다.
		while (!qu.isEmpty()) {
				// 큐에서 노드 한개를 뺀다.
				int out = qu.poll();
				System.out.print(out+ " ");
				// 빼낸 노드의 인접 노드를 방문
				for (int x : list[out]) {
					// 인접노드를 방문한적이 없으면 방문표시 후, 큐에 삽입
					if(visited[x] == false) {
						visited[x] = true;
						qu.add(x);
					}
				}
				
			
		}
	}

	static void dfs(int start) {
		
		// 방문했으면 함수 종료
		if (visited[start] == true)
			return;
		
		// 방문표시
		visited[start] = true; 
		System.out.print(start+" ");
		
		// 방문한 노드와 인접한 노드를 방문한다.
		for (int i : list[start]) {
			// 인접노드를 방문안했으면 방문하러 간다.
			if (visited[i] == false)
				dfs(i);
		}
	}
	
}
