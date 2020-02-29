package org.baekjoon;

import java.io.*;
import java.util.*;
public class test1987_backtracking_alphabet {

	static char[][] arr;
	static int R,C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		for(int i=0; i<R; i++) {
			String string = br.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j] = string.charAt(j);
			}
		}
		
		String way = arr[0][0]+"";
		fun(0,0,way);
		System.out.println(max);
	}

	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int max;
	private static void fun(int x, int y, String way) {
		
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= R || ny < 0 || ny >= C) 
				continue;
			if (way.contains(arr[nx][ny]+"")) {
				max = Math.max(max, way.length());
				continue;
			}
			
			fun(nx,ny,way+arr[nx][ny]);
			
		}
		
	}

}
