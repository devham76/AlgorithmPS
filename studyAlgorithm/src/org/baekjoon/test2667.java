package org.baekjoon;

import java.io.*;
import java.util.*;

public class test2667 {

	static int[][] arr;
	static int size;
	static boolean[][] visited;
	
	// ���� ���� 
	static int[] Dx = {-1, 1, 0, 0};
	static int[] Dy = {0, 0, -1, 1};
	
 	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
	
		size = Integer.parseInt(br.readLine());
		arr = new int[size][size];
		
		for(int i=0; i<size; i++) {
			input = br.readLine();
			for(int j=0; j<size; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		
		ArrayList<Integer> houseCount = new ArrayList<Integer>();
		visited = new boolean[size][size];
		int group = 0;
		
		// ��ü�� ���� 1�� ���� ã�´�
		for (int i=0; i<size; i++) {
			
			for (int j=0; j<size; j++) {
				
				// �̹� �湮�� ���̶�� �н�
				if (visited[i][j] == true) continue;
				
				// �湮���� ���� ���̶�� ���ο� ����+1 , ������ ���� �� ���ϱ�
				if(arr[i][j] == 1) {
					// ���� +1
					group++;
					houseCount.add(BFS(i,j));
				}
			}
		}
		
		// ��� ���
		System.out.println(group);
		
		Collections.sort(houseCount);
		for(int e:houseCount)
			System.out.println(e);
		
	}
	
	static int BFS(int x, int y) {

		int houseCount = 0;
		Queue<dot> qu = new LinkedList<dot>();
		qu.offer(new dot (x, y));
		
		while (!qu.isEmpty()) {
			// �湮�� ť �Ǿ� ���� �ϳ� �̴´�.
			dot Cd = qu.poll();
			int Cx = Cd.x;
			int Cy = Cd.y;
			
			
			// ���� ���� �����¿츦 Ȯ���Ѵ�.
			for (int i=0; i<4 ;i++) {
				int Nx = Cx + Dx[i];
				int Ny = Cy + Dy[i];
				
				// �����¿��� ���� ���� ���� �ִ��� Ȯ���Ѵ�.
				if (0 <= Nx && Nx < size && 0 <= Ny && Ny < size) {
					// ���� �ְ� �湮���� �ʾ����� 
					if (arr[Nx][Ny] == 1 && visited[Nx][Ny] == false) {
						// �湮�Ѵ�
						visited[Nx][Ny] = true;
						qu.offer(new dot(Nx,Ny));
						// ���� ���ڸ� �����ش�.
						houseCount++;
					}
				}
			}
		}
		return houseCount;
	}
}

