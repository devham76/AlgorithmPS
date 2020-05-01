package org.programmers;

import java.util.ArrayList;
import java.util.List;

public class kakao_17679 {

	public static void main(String[] args) {
		String[] b = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		//solution(4, 5, b);
		String[] b2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF","TMMTTJ"};
		solution(6, 6, b2);
		
	}

	public static int solution(int m, int n, String[] board) {
		int answer = 0;
		char[][] cboard = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				cboard[i][j] = board[i].charAt(j);
			}
		}

		int[] nx = { 0, 0, 1, 1 };
		int[] ny = { 0, 1, 1, 0 };

		List<Integer> xlist, ylist;
		
		while (true) {
			int cnt = 0;	
			xlist = new ArrayList<>();
			ylist = new ArrayList<>();
			// m : 높이 , n : 폭
			//--------------------------------
			// 1. 사라질 블록의 왼쪽위 정보를 수집한다.
			//--------------------------------
			for (int x = 0; x < m - 1; x++) {
				for (int y = 0; y < n - 1; y++) {
					char c = cboard[x][y];
					boolean is_same = true;
					// 해당 블록과 주변의 세가지 블록 검사
					for (int i = 1; i < 4; i++) {
						char nextC = cboard[x + nx[i]][y + ny[i]];
						if (c != nextC || nextC == '0') {
							is_same = false;
							break;
						}
					}

					// 사라질수 있는 블록의 시작점을 입력
					if (is_same == true) {
						xlist.add(x);
						ylist.add(y);
					}
				}
			}


			//--------------------------------
			// 2. 블록 4개를 없애면서 없어진 블록의 개수를 센다.
			//--------------------------------
			for (int i = 0; i < xlist.size(); i++) {
				// 해당 블록을 포함한 4면을 0으로 만든다.
				for (int j = 0; j < 4; j++) {
					int x = xlist.get(i) + nx[j];
					int y = ylist.get(i) + ny[j];
				
					if (cboard[x][y] != '0') {
						cnt++;
						cboard[x][y] = '0';
					}
				}

			}
			

			//--------------------------------
			// 3. 없어진 블록을 매꾼다.
			//--------------------------------
			for (int i = 0; i < xlist.size(); i++) {
				
				// 아래 두개
				for (int j = 2; j < 4; j++) {
					boolean is_ok = true;
					int x = xlist.get(i) + nx[j];
					int y = ylist.get(i) + ny[j];
					int diff = 0;
					int dx = x;
					while (cboard[dx][y] == '0') {
						diff++;
						dx--;
						if(dx < 0) {
							is_ok = false;
							break;
						}
					}
					if(is_ok == false)
						continue;
					if (diff == 0) {
						continue;
					}
					for (int k = 0; x - diff - k >= 0; k++) {
						cboard[x - k][y] = cboard[x - diff - k][y];
						cboard[x - diff-k][y] = '0';
					}
					
					
				}

			}
			
			if(cnt == 0)
				break;
			
			answer+= cnt;
		}
		System.out.println("answer ==>"+answer);
		return answer;
	}
}
