package org.psStrategies;

public class Chapter6_boggle {

	/**
	 * 문제 ID;BOGGLE 난이도 하
	 * 5x5 크기의 알파벳 격자에 상하좌우/대각선으로 인접한 칸들의 글자를 이어서 단어를 찾아내는 게임이다.
	 * 입력받은 단어를 찾으면 true, 그렇지 못하면 false를 반환하라
	 */
	public static void main(String[] args) {
		char[][] board = {
				{'N','N','N','N','S'},
				{'N','E','E','E','N'},
				{'N','E','Y','E','N'},
				{'N','E','E','E','N'},
				{'N','N','N','N','N'},
		};
		String word = "YES";
		boolean answer = false;
		// 게임판 위에서 단어의 첫글자가 시작되는 곳을 찾는다.
		for( int x = 0; x < board.length; x++) {
			for ( int y = 0; y < board.length; y++) {
				if (board[x][y] == word.charAt(0)) {
					if( hasWord(x, y, board, word) ) 
						answer = true; break;
				}
			} 
		}
		
		System.out.println(answer);
	}
	// 인접 8칸
	static int[] dx = {-1, -1, -1, 1, 1, 1, 0, 0};
	static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 1};
	public static boolean hasWord(int x, int y, char[][] board, String word) {
		
		// 기저 사례 : 입력이 잘못되거나 / 범위를 벗어나면 기저사례!!!!!
		// 기저 사례 1 : 검색 범위가 게임 판을 벗어날때 실패
		if (x < 0 || x >= board.length || y < 0 || y >= board.length)
			return false;
		// 기저 사례 2 : 입력이 잘못 됬을때 실패
		if (board[x][y] != word.charAt(0))
			return false;
		// 기저 사례 3 : 입력이 잘됐고, 단어 길이가 1이라면 성공.
		if (word.length() == 1)
			return true;
		// 인접한 8칸을 검색한다
		for (int direction = 0; direction < 8; direction++) {
			int nextX = x + dx[direction], nextY = y + dy[direction];
			if ( hasWord(nextX, nextY, board, word.substring(1)) )
				return true;
		}
		return false;
	}
}
