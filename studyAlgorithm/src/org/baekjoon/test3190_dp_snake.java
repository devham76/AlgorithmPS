package org.baekjoon;

import java.util.*;

public class test3190_dp_snake {
	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int  N = sc.nextInt();
		int[][] board = new int[N][N];
		
		// 사과 자리 입력
		int AppleNum = sc.nextInt();
		for(int i=0; i<AppleNum; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			board[x][y] = 1;
		}
		
		// 방향 바뀌는 정보 입력
		int changeNum = sc.nextInt();
		HashMap<Integer, Character > changeInfo = new HashMap<>();
		for(int i=0; i<changeNum; i++) {
			changeInfo.put(sc.nextInt(), sc.next().charAt(0));
		}
	
		int time = 0;
		// 뱀을 늘어났다 줄었다 하므로 삭제가 쉽도록 linkedlist로 구현
		LinkedList<dot> snake = new LinkedList<dot>();
		// 뱀의 현재위치 
		snake.add(new dot(0,0));
		board[0][0] = 2;
		// 방향 설정에 필요한 것들
		int currentD = 1;
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		while(true) {
			// 뱀의 맨앞 좌표를 구한다
			int snakeSize = snake.size();
			int headx = snake.get(snakeSize-1).x;
			int heady = snake.get(snakeSize-1).y;
			
			// 90도 회전 한다면 
			if( changeInfo.containsKey(time) ) {
				if(changeInfo.get(time) == 'L') 
					currentD++;
				else
					currentD--;
				
				if (currentD == -1)
					currentD = 3;
				else if (currentD == 4)
					currentD = 0;
			}
			
			// 이동
			headx += dx[currentD]; heady += dy[currentD];
			time++;
			
			// 머리 이동 후에 벽을 부딪히면 끝
			if(headx<0 || headx>=N ||heady<0 || heady>=N )
				break;
			
			// 머리 이동 후에 자신의 몸과 부딪히면 끝
			if( board[ headx ][heady] == 2) {
				break;
			}
			// 머리 이동 후에 사과가 없다면 꼬리 삭제
			else if (board[ headx ][ heady ] != 1) {
				board [ snake.get(0).x ] [snake.get(0).y] = 0;
				snake.remove(0);
			}
			
			// 이동한 뱀위치 추가
			snake.add(new dot(headx, heady));
			board[ headx ][ heady ] = 2;	
			
		}
		System.out.println(time);
	}
}
