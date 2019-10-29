package org.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test2178 {
	// dx[i] dy[i] �� �����ؼ� �����¿� �̵� 
	static int dx[] = {-1, 1, 0, 0};	
	static int dy[] = {0, 0, 1, -1};
	static int M=4, N=6;
			
	static int[][] arr ={
			{1,1,0,1,1,0},
			{0,1,0,1,1,0},
			{1,1,1,1,1,1},
			{1,1,1,1,0,1}
			};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BFS(0,0);
	}
	
	static void BFS(int x,int y) {
		Queue<dot> qu = new LinkedList<dot>();
		qu.offer(new dot(x,y));
		
		while (!qu.isEmpty()) {
			dot d = qu.poll();
			int Cx = d.x;
			int Cy = d.y;
			//System.out.println(Cx+","+Cy);
			
			// ������ġ���� �����¿� �˻�
			for (int i=0; i<4; i++) {
				// ���� ��ǥ
				int Nx = Cx + dx[i];
				int Ny = Cy + dy[i];
				
				// �ش� ��ǥ�� ���� ���� �־�� �Ѵ�
				if ( Nx>=0 && Nx<M && Ny>=0 && Ny<N ) {
					// 1�� �� : �����ְ�, �湮 ���ߴ�.
					if (arr[Nx][Ny] == 1) {
						// ������� �̵��� ����+1
						System.out.println("x:"+Nx+" , y:"+Ny);
						arr[Nx][Ny] = arr[Cx][Cy] + 1;
						qu.offer(new dot(Nx, Ny));
					}
				}
			}
		}
		
		System.out.println(arr[M-1][N-1]);
	}
}
class dot{
	int x;
	int y;
	
	dot(int x, int y){
		this.x = x;
		this.y = y;
	}
}

