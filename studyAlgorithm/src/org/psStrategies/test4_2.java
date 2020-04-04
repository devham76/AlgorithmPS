package org.psStrategies;

import java.util.Scanner;

public class test4_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 책상 개수
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int cnt = 0;
		int max = 0;
		// 1. 1 0 0 0 1 양쪽에 사람이 있는경우
		int i = 0;
		for (i = 0; i < n; i++) {
			if (arr[i] == 1) {
				break; // 첫번째 1의 위치를 찾았다.
			}
		}

		for (i = i + 1; i < n; i++) {
			if (arr[i] == 0) {
				cnt++;
			} else {
				// 사람이 있으면, 사람을 만나기 전까지 빈 책상의 개수를 센다.
				int temp = cnt % 2 == 0 ? cnt / 2 - 1 : cnt / 2;
				max = Math.max(max, temp);
				cnt = 0;
			}
		}

		// 2. 0 0 0 0 1 왼쪽에 사람이 없는 경우
		cnt = 0;
		for (i = 0; i < n; i++) {
			// 빈자리 개수 센다.
			if (arr[i] == 0)
				cnt++;
			else // 사람이 있으면 끝낸다.
				break;
		}
		max = Math.max(max, cnt);

		// 3. 1 0 0 0 0 오른쪽에 사람이 없는 경우 --> 2번과 반대.
		cnt = 0;
		for (i = n - 1; i >= 0; i--) {
			// 빈자리 개수 센다.
			if (arr[i] == 0)
				cnt++;
			else // 사람이 있으면 끝낸다.
				break;
		}
		max = Math.max(max, cnt);
		// 0 0 0 0 0 0 1 0 일 경우에는 2번과3번 둘다 해당된다.
		
		System.out.println(max);
	}

}
