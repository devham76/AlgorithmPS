package org.programmers;

public class Level1_tile_43104 {

	public static void main(String[] args) {
		System.out.println( solution2(5) );
	}    
	public static long solution(int N) {
        long answer = 0;
        long tile[] = new long[80];
        tile[0] = 1;
        tile[1] = 1;
        getTile(tile, 2, N);
        
        answer = tile[N-1] * 4 + tile[N-2] * 2;
        return answer;
    }
	
	public static void getTile(long tile[], int current, int goal) {
		if (current == goal)
			return;
		tile[current] = tile[current-1] + tile[current-2];
		getTile(tile, current+1, goal);
	}
	public static long solution2(int N) {
        long answer = 0;
        long tile[] = new long[80];
        tile[0] = 1;
        tile[1] = 1;
        for (int i = 2; i < N; i++)
        	tile[i] = tile[i-1] + tile[i-2];
        answer = tile[N-1] * 4 + tile[N-2] * 2;
        return answer;
	}
}
