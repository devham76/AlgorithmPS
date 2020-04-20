package org.programmers;

import java.util.Stack;

public class kakao_64061 {

	public static void main(String[] args) {
		int[][] b = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] m = {1,5,3,5,1,2,1,4};
		solution(b, m);
	}

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;

		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < moves.length; i++) {
			int move = moves[i];
			int depth = 0;
			int doll = 0;
			while (depth < board.length) {
				// 인형이 있다면, 인형을 꺼낸다
				if (board[depth][move - 1] != 0) {
					doll = board[depth][move - 1];
					board[depth][move - 1] = 0;
					break;
				} else // 인형이 없으면 한단계 아래로 내려간다.
					depth++;
			}

			// 잡은 인형이 있다면 추가
			if (doll != 0) {
				// 이전에 뽑은 인형이 있을때 맨위에 있는 인형과 현재 인형 비교. 
				if (st.size() > 0) {
					int topDoll = st.peek();
					if(topDoll == doll) {
						st.pop();
						answer += 2;
					}
					else
						st.add(doll);
				}
				else	// 이전에 잡힌 인형없음. 그냥 추가.
					st.add(doll);
			}
		}
		System.out.println(answer);
		return answer;
	}
}
