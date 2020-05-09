package org.programmers;

public class kakao_60062 {

	public static void main(String[] args) {		

	}


	private int n, num = 0;
	private boolean finish = false;
	private int[] weak, dist, choice;
	private int[][] rotateWeak;

	public  int solution(int n, int[] weak, int[] dist) {
		this.n = n;
		this.weak = weak;
		this.dist = dist;
		// 수리가 필요한 부분의 시작점을 다르게 하는 배열을 만든다.
		setWeak();

		for (int i = 1; i <= dist.length; i++) {
			num = i;
			choice = new int[num];
			permutation(0, new boolean[dist.length]);
			if (finish == true)
				break;
		}
		return (finish) ? num : -1;
	}

	private void permutation(int depth, boolean[] visit) {
		if (finish == true)
			return;
		if (depth == num) {
			check();
			return;
		}

		for (int i = 0; i < dist.length; i++) {
			if (!visit[i]) {
				choice[depth] = dist[i];
				visit[i] = true;
				permutation(depth + 1, visit);
				visit[i] = false;
			}
		}

	}

	private void check() {
		for (int[] weak : rotateWeak) {
			int idx = 0, start = 0;
			boolean[] visit = new boolean[weak.length];

			while (idx != num) {
				int i = start;
				int value = choice[idx++];

				for (int j = start; j < weak.length; j++) {
					if (!(weak[i] <= weak[j] && weak[j] <= weak[i] + value))
						break;
					visit[j] = true;
					start++;
				}
			}

			// weak의 모든 지점을 방문했으면 true, 함수종료
			if (isFinish(visit)) {
				finish = true;
				return;
			}
		}

	}

	// weak의 모든지점을 방문해야한다.
	public boolean isFinish(boolean[] visit) {
		for (boolean bool : visit) {
			if (!bool)
				return false;
		}
		return true;
	}

	// weak를 0 ~ n-1번 회전하여 rotateWeak에 저장
	// ex . n=12, weak = [1,5,6,10]
	// [1, 5, 6, 10] , [5, 6, 10, 13], [6, 10, 13, 17], [10, 13, 17, 18]
	private void setWeak() {
		int len = weak.length;
		rotateWeak = new int[len][len];

		for (int i = 0; i < len; i++) {
			rotateWeak = rotate(weak, i);
		}

	}

	// weak의 idx번째가 맨앞에 온다.
	private int[][] rotate(int[] weak, int idx) {
		int len = weak.length;
		int[] result = new int[len];

		for (int i = 0; i < len; i++) {
			if (i + idx < len)
				result[i] = weak[i + idx];
			else
				result[i] = weak[i + idx - len] + n;
		}
		return null;
	}
}
