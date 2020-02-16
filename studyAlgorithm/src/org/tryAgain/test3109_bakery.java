//https://www.acmicpc.net/problem/3109
Æ²¸²
package org.tryAgain;

import java.util.Scanner;

public class test3109_bakery {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		char[][] arr = new char[R][C];
		boolean[][] visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			String line = sc.next();
			visited[i][0] = true;
			for(int j=0; j<C; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		int answer=0;
		int[] dx = {-1,0,1};
		int[] dy = {1,1,1};
		
		for(int i=0; i<C-1; i++) {
			for(int j=0; j<R; j++) {
				if(visited[j][i] == false)
					continue;
				
				for(int k=0; k<3; k++) {
					int nx = j+dx[k];
					int ny = i+dy[k];
					
					if(nx<0 || nx>=R || ny<0 || ny>=C)
						continue;
					
					if(arr[nx][ny] == 'x')
						continue;;
						
					if(visited[nx][ny] == true)
						continue;
					
					visited[nx][ny] = true;
					if(i == C-3) answer++; 
				}
				
			}
		}
		/*
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(visited[i][j] +" ");
			}
			System.out.println();
		}
		*/
		System.out.println(answer);
	}

}
