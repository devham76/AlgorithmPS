package org.kakao;
// ¿Ï·á
import java.util.LinkedList;

public class kakao_intern_2020_1 {

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		// result = 4
		solution(board, moves);

	}
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        LinkedList<Integer> basket = new LinkedList<Integer>();
        for (int i = 0; i < moves.length; i++) {
        	
        	for (int j = 0; j < board.length; j++) {
        		
        		if (board[j][ moves[i]-1 ] != 0) {
        			int doll = board[j][ moves[i]-1 ];
        			board[j][ moves[i]-1 ] = 0;
        			basket.add( doll );
        			if ( basket.size() > 1) {
        				int d1 = basket.get( basket.size() -2);
        				int d2 = basket.get( basket.size() -1);
        				if (d1 == d2) {
        					basket.remove( basket.size()-1 );
        					basket.remove( basket.size()-1 );
        					answer +=2;
        				}
        			}
        			break;
        		}
        	}
        }
        return answer;
    }

}
