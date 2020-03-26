package org.baekjoon;

import java.util.*;

public class test12886_ston {

	static Queue<int[]> q;
	static HashSet<String> hs;

	// 큐에 배열형태도 넣을수있다
	// hashset을 이용하면, 중복된 값을 체크할수있다.
	// 오름차순으로 정리하면 첫번째 값이 무조건 제일 작으므로, (1,2) (1,3) 1을 기준으로 삼아 새로운 배열 만들수있다 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] stone = new int[3];
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			stone[i] = sc.nextInt();
			sum += stone[i];
		}

		if (sum % 3 != 0)
			System.out.println(0);
		else {
			Arrays.sort(stone);
			q = new LinkedList<>();
			hs = new HashSet<>();
			q.offer(stone);
			bfs();
		}
	}

	private static void bfs() {

		while (!q.isEmpty()) {
			int[] stone = q.poll();

			// 셋이 같으면 끝.
			if (stone[0] == stone[1] && stone[1] == stone[2]) {
				System.out.println("1");
				return;
			}

			for (int i = 1; i < 3; i++) {
				int[] newStone = stone.clone();

				newStone[i] = stone[i] - stone[0];
				newStone[0] = stone[0] * 2;
				Arrays.sort(newStone);

				String str = "";
				for (int j = 0; j < 3; j++)
					str += newStone[j] + "";

				// 해당 패턴이 처음 이면 큐와 해쉬셋에 입력한다
				if (!hs.contains(str)) {
					q.offer(newStone);
					hs.add(str);
				}

			}

		}
		System.out.println("0");

	}

}