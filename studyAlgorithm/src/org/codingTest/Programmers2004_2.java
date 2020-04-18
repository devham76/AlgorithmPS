package org.codingTest;

public class Programmers2004_2 {

	public static void main(String[] args) {
		int[][] o = { { 5, -1, 4 }, { 6, 3, -1 }, { 2, -1, 1 } };
		String[] m = { "go", "go", "right", "go", "right", "go", "left", "go" };
		solution(o, 1, 0, m);

	}

	public static int solution(int[][] office, int r, int c, String[] move) {
		int answer = office[r][c];
		office[r][c] = 0;

		// 북쪽부터 시작 right이면 +1 left이면 -1
		int[] nx = { -1, 0, 1, 0 };
		int[] ny = { 0, 1, 0, -1 };

		int idx = 0;
		for (String command : move) {

			if (command.equals("right")) {
				idx = (idx + 1) % 4;
			} else if (command.equals("left")) {
				idx = idx - 1;
				idx = idx == -1 ? 3 : idx;
			} else if (command.equals("go")) {
				int newr = r + nx[idx];
				int newc = c + ny[idx];
				
				if(newr < 0 || newr >= office.length || newc < 0 || newc >= office.length)
					continue;
				
				if(office[newr][newc] != -1) {
					// 먼지 흡입
					answer += office[newr][newc];
					office[newr][newc] = 0;
					
					// 현재 위치 등록
					r = newr;
					c = newc;
				}
			}
			
		}

		System.out.println(answer);
		return answer;
	}
}
