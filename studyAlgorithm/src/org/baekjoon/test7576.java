package org.baekjoon;

import java.util.*;
public class test7576 {
	static boolean[][] visited;	// �湮����
	static int[][] fruit;		// ������ 
	static int M,N;				// ���� ��, ��
	static int todayCnt = 0; 	// ���� ���� ���ϼ�
	
	static int[] Dx = {-1, 1, 0, 0};
	static int[] Dy = {0, 0, -1, 1};
	
	public static void main(String[] args) {

		// ���� ���� �Է¹ޱ�
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		visited = new boolean[N][M];
		fruit = new int[N][M];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				fruit[i][j] = sc.nextInt();
			}
		}
		
		Queue<dot> qu = new LinkedList<dot>();
		// ó�� 1 �� ��ġ ã��
		for (int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				
				if(fruit[i][j] == 1) {
					qu.offer(new dot(i,j));
					visited[i][j] = true;
					todayCnt++;
				}
			}
		}
		
		// ���� ���� �ϳ��� ���� ��.
		if(todayCnt == 0 )
			System.out.println(-1);
		// ��� ���� �����̶��
		else if(todayCnt == (M*N))
			System.out.println(0);
		else
			bfs(qu);
	}
	static void bfs(Queue<dot> qu) {
		int day = -1;
		int yesterdayCnt;					// ���� ���� ���� ����

		while ( !qu.isEmpty()) {			// �� : �������� ������ġ
			
			yesterdayCnt = todayCnt;
			todayCnt = 0;
			
			// ���� ���� ������ ��� ������.
			for (int i=0; i<yesterdayCnt; i++) {
				dot Cq = qu.poll();
				
				// �ش������ �����¿� ������ Ȯ���Ѵ�.
				for (int j=0; j<4; j++) {
					
					int Nx = Cq.x + Dx[j];
					int Ny = Cq.y + Dy[j];
					
					// �����¿찡 ���ϻ��� ���� �ȿ� �־�� �Ѵ�.
					if (0 > Nx || Nx >= N || 0 > Ny || Ny >= M ) 
						continue;
				
					// �̹� �湮�ߴٸ� �о�.
					if (visited[Nx][Ny] == true )
						continue;
					
					visited[Nx][Ny] = true;
					
					// ������ �����̶�� ������, ť�� �ְ�, �������� ���ϼ� +1
					if (fruit[Nx][Ny] == 0) {
						fruit[Nx][Ny] = 1;
						qu.offer(new dot(Nx, Ny));
						todayCnt++;
					}
					
				}
			}
			day++;
		}
		
		boolean is_done = true;
		
		// �����ǿ� ������ ������ ������, -1
		for (int i=0; i<N; i++) {
			for(int e:fruit[i]) {
				if(e == 0) {
					System.out.println(-1);
					is_done = false;
					break;
				}
			}
		}
		
		if(is_done == true)
			System.out.println(day);
	}

	
}
