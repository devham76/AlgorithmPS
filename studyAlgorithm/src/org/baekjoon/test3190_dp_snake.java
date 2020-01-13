package org.baekjoon;

import java.util.*;

public class test3190_dp_snake {
	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int  N = sc.nextInt();
		int[][] board = new int[N][N];
		
		// ��� �ڸ� �Է�
		int AppleNum = sc.nextInt();
		for(int i=0; i<AppleNum; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			board[x][y] = 1;
		}
		
		// ���� �ٲ�� ���� �Է�
		int changeNum = sc.nextInt();
		HashMap<Integer, Character > changeInfo = new HashMap<>();
		for(int i=0; i<changeNum; i++) {
			changeInfo.put(sc.nextInt(), sc.next().charAt(0));
		}
	
		int time = 0;
		// ���� �þ�� �پ��� �ϹǷ� ������ ������ linkedlist�� ����
		LinkedList<dot> snake = new LinkedList<dot>();
		// ���� ������ġ 
		snake.add(new dot(0,0));
		board[0][0] = 2;
		// ���� ������ �ʿ��� �͵�
		int currentD = 1;
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		while(true) {
			// ���� �Ǿ� ��ǥ�� ���Ѵ�
			int snakeSize = snake.size();
			int headx = snake.get(snakeSize-1).x;
			int heady = snake.get(snakeSize-1).y;
			
			// 90�� ȸ�� �Ѵٸ� 
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
			
			// �̵�
			headx += dx[currentD]; heady += dy[currentD];
			time++;
			
			// �Ӹ� �̵� �Ŀ� ���� �ε����� ��
			if(headx<0 || headx>=N ||heady<0 || heady>=N )
				break;
			
			// �Ӹ� �̵� �Ŀ� �ڽ��� ���� �ε����� ��
			if( board[ headx ][heady] == 2) {
				break;
			}
			// �Ӹ� �̵� �Ŀ� ����� ���ٸ� ���� ����
			else if (board[ headx ][ heady ] != 1) {
				board [ snake.get(0).x ] [snake.get(0).y] = 0;
				snake.remove(0);
			}
			
			// �̵��� ����ġ �߰�
			snake.add(new dot(headx, heady));
			board[ headx ][ heady ] = 2;	
			
		}
		System.out.println(time);
	}
}
