package org.programmers;

public class Level3_network_43162 {

	public static void main(String[] args) {
		int[][] c = { {1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int[][] c2 = {	{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		solution(3, c);
	}

	public static int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[][] visited = new boolean[n][n];
		for(int i=0; i<computers.length; i++) {
			// �ش��带 �湮���� �ʾҴٸ�, �ش����� ��Ʈ��ũ�� ��� �湮�� �Ŀ� +1
			if(visited[i][i] == false) {
				findWay(i, computers, visited);
				answer++;
			}
		}
		return answer;
	}
	
	// index���� ������ ��� ��带 �湮�մϴ� 
	public static void findWay(int index, int[][] computers, boolean[][] visited) {
		for(int j=0; j<computers.length; j++) { 			
			if( visited[index][j] == false && computers[index][j] == 1) {			
				visited[index][j] = visited[j][index] = true;
				findWay(j, computers, visited);
			}		
		}  			
	}
}
