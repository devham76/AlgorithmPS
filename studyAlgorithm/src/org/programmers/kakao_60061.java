package org.programmers;

import java.util.*;

/*
 내가 시도한 풀이 : 보와 기둥을 1,2로 정하고 설치가 되면 해당 숫자를 넣는식으로 했다.
 문제점 : 두가지를 한꺼번에 저장하려니까 복잡했다.
 해결방법 : 보와 기둥 배열을 각각 사용한다.
 
 내가 시도한 풀이 : 보나 기둥을 삭제 할때 삭제 할수 있는지 확인하고 삭제한다
 문제점 : 다양한 조건을 확인해줘야 하므로 복잡하다.
 해결방법 : 조건의 배열크기 자체가 작고, 효율성을 따지는 문제가 아니므로, 일단삭제하고 -> 구조물전체를 돌면서 여전히 설치 가능한지 확인한다.
 
 배운점 : 
 1. 문제 그대로 코드를 작성하면 된다. 언제나 정답은 문제에 !!!!
 2. 기능별로 함수를 나누면서 작성해보자
 3. 두가지의 큰 경우의 수가 있으므로 이럴땐 배열 자체를 두개로 나눠보자.
 
 
 참고 
 - https://leveloper.tistory.com/100
 - https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EA%B8%B0%EB%91%A5%EA%B3%BC-%EB%B3%B4-%EC%84%A4%EC%B9%98-Java
 - https://programmers.co.kr/learn/courses/30/lessons/60061
 * */
public class kakao_60061 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static final int PILLAR = 0;
	static final int BEAM = 1;
	static final int DESTRUCT = 0;
	static final int CONSTRUCT = 1;

	boolean[][] pillars, beams; // 기둥, 보

	public int[][] solution(int n, int[][] build_frame) {
		int structureCount = 0;

		pillars = new boolean[n + 3][n + 3];
		beams = new boolean[n + 3][n + 3];

		for (int[] frame : build_frame) {
			int x = frame[0] + 1;
			int y = frame[1] + 1;

			int structureType = frame[2];
			int commandType = frame[3];

			if (commandType == CONSTRUCT) {
				if (structureType == PILLAR && canConstructPillar(x, y)) {
					pillars[x][y] = true;
					structureCount++;
				}
				if (structureType == BEAM && canConstructBeam(x, y)) {
					beams[x][y] = true;
					structureCount++;
				}
			} else if (commandType == DESTRUCT) {
				// 일단 삭제
				if (structureType == PILLAR) {
					pillars[x][y] = false;
				} else if (structureType == BEAM) {
					beams[x][y] = false;
				}

				if (canDestruct(structureType, n)) {
					structureCount--;
					continue;
				}

				// 삭제 할수 없으면 다시 설치
				// 삭제하고, 남아있는 구조물을 여전히 그자리에 설치할수 있는지 확인한다.
				if (structureType == PILLAR) {
					pillars[x][y] = true;
				} else if (structureType == BEAM) {
					beams[x][y] = true;
				}
			}
		}

		int index = 0;
		int[][] answer = new int[structureCount][3];
		for (int i = 1; i <= n + 1; ++i) {
			for (int j = 1; j <= n + 1; ++j) {
				if (pillars[i][j])
					answer[index++] = new int[] { i - 1, j - 1, PILLAR };
				if (beams[i][j])
					answer[index++] = new int[] { i - 1, j - 1, BEAM };
			}
		}
		return answer;
	}


	private boolean canDestruct(int structureType, int n) {
		for (int i = 1; i <= n + 1; ++i) {
			for (int j = 1; j <= n + 1; ++j) {
				if (pillars[i][j] && !canConstructPillar(i, j)) {
					return false;
				}
				if (beams[i][j] && !canConstructBeam(i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean canConstructBeam(int x, int y) {
		// 보 설치가능조건
		// 설치하려는곳이 기둥의 끝이거나, 내 오른쪽끝이 기둥의 끝이거나, 양쪽에 보가 설치 되어있다면
		return pillars[x][y - 1] || pillars[x + 1][y - 1] || (beams[x - 1][y] && beams[x + 1][y]);
	}

	private boolean canConstructPillar(int x, int y) {
		// 기둥 설치가능 조건
		// 바닥에 있거나 , 내아래에 기둥이 있거나, 내자리에서 부터 보가 설치되어있거나, 내자리 왼쪽에서 부터 보가 설치 되어있을때 
		return y == 1 || pillars[x][y - 1] || beams[x][y] || beams[x - 1][y];
	}

}
