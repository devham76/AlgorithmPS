package org.psStrategies;

public class Chapter6_boggle {

	/**
	 * ���� ID;BOGGLE ���̵� ��
	 * 5x5 ũ���� ���ĺ� ���ڿ� �����¿�/�밢������ ������ ĭ���� ���ڸ� �̾ �ܾ ã�Ƴ��� �����̴�.
	 * �Է¹��� �ܾ ã���� true, �׷��� ���ϸ� false�� ��ȯ�϶�
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
		// ������ ������ �ܾ��� ù���ڰ� ���۵Ǵ� ���� ã�´�.
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
	// ���� 8ĭ
	static int[] dx = {-1, -1, -1, 1, 1, 1, 0, 0};
	static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 1};
	public static boolean hasWord(int x, int y, char[][] board, String word) {
		
		// ���� ��� : �Է��� �߸��ǰų� / ������ ����� �������!!!!!
		// ���� ��� 1 : �˻� ������ ���� ���� ����� ����
		if (x < 0 || x >= board.length || y < 0 || y >= board.length)
			return false;
		// ���� ��� 2 : �Է��� �߸� ������ ����
		if (board[x][y] != word.charAt(0))
			return false;
		// ���� ��� 3 : �Է��� �ߵư�, �ܾ� ���̰� 1�̶�� ����.
		if (word.length() == 1)
			return true;
		// ������ 8ĭ�� �˻��Ѵ�
		for (int direction = 0; direction < 8; direction++) {
			int nextX = x + dx[direction], nextY = y + dy[direction];
			if ( hasWord(nextX, nextY, board, word.substring(1)) )
				return true;
		}
		return false;
	}
}
