package org.baekjoon;

import java.io.*;
import java.util.*;

public class test2667_2 {

	static int[][] map;
	static int[][] check;
	static int N;
	static Queue<dot3> q; 
	static List<Integer> list;
	static int num = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		check = new int[N][N];
		for(int i=0; i<N; i++) {
			String line = sc.next();
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(line.charAt(j)+"");
			}
		}

		q = new LinkedList<>();
		list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 집이 있고, 단지번호가 확인 안되어있다면, 단지번호 부여하기
				if(map[i][j] == 1 && check[i][j] == 0) {
					
					q.add(new dot3(i,j));
					bfs();
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(Integer l:list)
			System.out.println(l);
		
	}
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	private static void bfs() {
		int listCount = 0;
		while (!q.isEmpty()) {
			dot3 dot = q.poll();
				
			// 4방향으로 움직일 수 있다.
			for(int i=0; i<4; i++) {
				int x = dot.x + dx[i];
				int y = dot.y + dy[i];
				
				if(x < 0 || x >= N || y < 0 || y >= N)
					continue;
				// 집이아니거나 or 이미 단지번호 부여되었으면 끝
				if(map[x][y] == 0 || check[x][y] != 0)
					continue;
				
				check[x][y] = num;
				q.add(new dot3(x,y));
				listCount++;
			}
		}
		list.add(listCount);
		num++;
	}

}
