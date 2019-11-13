package org.programmers;

import java.util.ArrayList;

public class kakao_2020_Pillar {

	public static void main(String[] args) {
		int[][] build = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}}; 
		int[][] build2 = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
		solution(5, build2);
	}
	static int[][] pillar;
	static int[][] bo;
	public static int[][] solution(int n, int[][] build_frame) {
		pillar = new int[n+1][n+1];
		bo = new int[n+1][n+1];

		for (int build=0; build < build_frame.length; build++) {
			int y = build_frame[build][0];
			int x = build_frame[build][1];
			int frame = build_frame[build][2];
			int is_install = build_frame[build][3];


			// 기둥이면
			if (frame == 0) {
				if (is_install == 0 ) {
					pillar[x][y] = 0;
					if (set_bo(x+1, y) == false || set_bo(x+1, y-1) == false )
						pillar[x][y] = 1;
				}

				if (is_install == 1 && set_pillar(x, y) == true)
					pillar[x][y] = 1;

				//System.out.println(build+"번째 , 기둥, pillar[x][y]=> "+pillar[x][y]+ "set_bo(x, y) :"+set_bo(x, y)+" , set_pillar(x, y):"+set_pillar(x, y));
			}
			else {
				if (is_install == 0 ) {
					bo[x][y] = 0;
					//if (set_pillar(x, y) == false || set_bo(x, y) == true)
					if (set_bo(x,y-1) == false || set_bo(x,y+1) == false)
						bo[x][y] = 1;
				}

				if (is_install == 1 && set_bo(x, y) == true)
					bo[x][y] = 1;
				System.out.println(x+", "+y);
				System.out.println(build+"번째 , 보, bo[x][y]=> "+bo[x][y]+"set_bo(x, y) :"+set_bo(x, y)+" , set_pillar(x, y):"+set_pillar(x, y));
			}
		}
		System.out.println("------pillar----");
		for(int i=0; i<pillar.length; i++) {
			for (int j=0; j<pillar.length; j++)
				System.out.print(pillar[i][j] + " ");
			System.out.println();
		}
		System.out.println("------bo----");
		for(int i=0; i<bo.length; i++) {
			for (int j=0; j<bo.length; j++)
				System.out.print(bo[i][j] + " ");
			System.out.println();
		}
		System.out.println();
		////
		
		int cnt=0;
		for(int i=0; i<bo.length; i++) {
			for (int j=0; j<bo.length; j++) {
				if(pillar[i][j] == 1) cnt++;
				if(bo[i][j] == 1) cnt++;
			}
		}
		int[][] answer = new int [cnt][3];
		int start = 0;
		for(int i=0; i<bo.length; i++) {
			for (int j=0; j<bo.length; j++) {
				if (pillar[j][i] == 1) {
					answer[start][0] = i;
					answer[start][1] = j;
					answer[start][2] = 0;
					start++;
				}else if (bo[j][i] == 1) {
					answer[start][0] = i;
					answer[start][1] = j;
					answer[start][2] = 1;
					start++;
				}
			}
		}

		for(int i=0; i<cnt ; i++) {
			for (int j=0; j<3; j++)
				System.out.print(answer[i][j]+" ");
		System.out.println();
		}
		
		return answer;
	}
	public static boolean set_pillar(int x, int y) {
		if (x == 0) {
			return true;
		}
		// 보의 한쪽 끝인지 확인
		if ( x+1 <pillar.length+1 )
			if( bo[x+1][y] == 1)
				return true;
		if ( bo[x][y] == 1)
			return true;
		if (x+1 < pillar.length+1 && y-1 >= 0 )
			if (bo[x+1][y-1] == 1)
				return true;
		if (y-1 >= 0 ) 
			if( bo[x][y-1] == 1) 
				return true;


		// 다른 기둥 위인지 확인
		if (x-1 >= 0)
			if (pillar[x-1][y] == 1) 
				return true;

		return false;
	}
	public static boolean set_bo(int x, int y) {

		// 한쪽 끝에 기둥있니 ? 
		if (x-1 >= 0) 
			if (pillar[x-1][y] == 1)
				return true;
		if (x-1 >= 0 && y+1 < bo.length+1)
			if (pillar[x-1][y+1] == 1)
				return true;

		// 양쪽끝이 다른 보와 연결?
		if ( y-1 >= 0 ) {
			if (bo[x][y-1] == 1) {
				if ( y+1 < bo.length+1) {
					if (bo[x][y+1] == 1)
						return true;
				}
			}
		}
		return false;
	}
}
