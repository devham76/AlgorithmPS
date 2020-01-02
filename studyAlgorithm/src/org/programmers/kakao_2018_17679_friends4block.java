package org.programmers;

public class kakao_2018_17679_friends4block {

	public static void main(String[] args) {
		kakao_2018_17679_friends4block k = new kakao_2018_17679_friends4block();
		String[] board = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" };
		k.solution(6, 6, board);
	}

	public int solution(int m, int n, String[] board) {
		int answer = 0;
		char[][] boards = new char[m][n];
		int[][] visited = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				boards[i][j] = board[i].charAt(j);
			}
		}

		int round = 0;
		boolean is_delete = true;

		while (is_delete == true) {
			is_delete = false;
			round++;
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (boards[i][j] == boards[i][j + 1] && boards[i + 1][j] == boards[i + 1][j + 1]
							&& boards[i][j] == boards[i + 1][j]) {
						
						visited[i][j] = round;
						visited[i][j + 1] = round;
						visited[i + 1][j] = round;
						visited[i + 1][j + 1] = round;
						is_delete = true; // 게임판의 변동이 있음을 표시
					}
				}
			}

			print(m,n,boards, visited);
			System.out.println("-------------r--------------------");
			
			down(m,n,boards);
			
			print(m,n,boards, visited);
			if(round == 3)
			is_delete = false;
			//System.out.println("is_delete:"+is_delete);
		}


		//print(m,n,boards, visited);
		return answer;
	}
	public static void down(int m, int n, char[][] map) {
	    
	    for (int i = m-1; i >= 0 ; i--) {
	        for (int j = 0; j < n; j++) {
	            if(map[i][j] == '.') continue;
	            
	            int nx = i;
	            char c = map[i][j];
	            map[i][j] = '.';
	            while(true) {
	                if(nx+1 >= m || map[nx+1][j] != '.') break;
	                nx++;
	            }
	            map[nx][j] = c;
	        }
	    }
	    
	}

	public static void print(int m,int n, char[][] b, int[][] v) {
		
		System.out.println("----board");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("----visited");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}
	}
}
