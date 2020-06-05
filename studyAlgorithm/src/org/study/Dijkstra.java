package org.study;

public class Dijkstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Graph {
	// 노드개수
	private int n;
	// 노드간의 가중치 저장 변수
	private int maps[][];

	public Graph(int n) {
		this.n = n;
		maps = new int[n + 1][n + 1];
	}

	// 간선 정보
	public void input(int i, int j, int w) {
		maps[i][j] = w;
		maps[j][i] = w;
	}

	public void dijkstra(int v) {
		// 최단 거리 저장할 변수
		int distance[] = new int[n + 1];
		// 노드 방문했는지 확인
		boolean[] check = new boolean[n + 1];

		// dinstance값 초기화
		for (int i = 1; i < n + 1; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		// 시작노드값 초기화
		distance[v] = 0;
		check[v] = true;

		// 연결노드 dinstance갱신
		// 방문 하지 않았고, 자기 자신이 아니면 거리 갱신
		for (int i = 1; i < n + 1; i++) {
			if (check[i] == false && maps[v][i] != 0) {
				distance[i] = maps[v][i];
			}
		}

		for (int a = 0; a < n - 1; a++) {
			int min = Integer.MAX_VALUE;
			int min_index = -1;
			
			// 최소값 찾기
			for(int i=1; i<n+1; i++) {
				if(!check[i] && distance[i] != Integer.MAX_VALUE) {
					if(distance[i]<min) {
						min = distance[i];
						min_index = 1;
					}	
				}
			}
			
			check[min_index] = true;
			for(int i=1; i<n+1; i++) {
				 if(!check[i] && maps[min_index][i]!=0){
	                    if(distance[i]>distance[min_index]+maps[min_index][i]){
	                        distance[i] = distance[min_index]+maps[min_index][i];
	                    }
	                }

			}
	         
	        //결과값 출력
	        for(int i=1;i<n+1;i++){
	            System.out.print(distance[i]+" ");
	        }
	        System.out.println("");


		}

	}
}
