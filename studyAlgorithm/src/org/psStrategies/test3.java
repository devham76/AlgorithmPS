package org.psStrategies;

import java.util.Arrays;
import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {
		// ---------
		// 방법 1.
		// ---------
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt(); // start
			arr[i][1] = sc.nextInt(); // end
		}
		Arrays.sort(arr, (o1, o2) -> {
			if (o1[1] == o2[1])
				return Integer.compare(o1[0], o2[0]);
			else
				return Integer.compare(o1[1], o2[1]);
		});

		int max = 1;
		for (int i = 0; i < n; i++) {
			int end = arr[i][1];
			int answer = 1;
			for (int j = i + 1; j < n; j++) {
				int nextstart = arr[j][0];
				if (nextstart < end) {
					answer++;
				}
			}
			max = Math.max(max, answer);
		}
		System.out.println(max);
		// ---------
		// 방법 2. 방문하고 있는 시간에 부스사용하고있으면 +1, 가장 많이 사용한 부스만큼 있어야 대기하지 않고 작업끝낼수있다.
		// ---------
		int[] arr2 = new int[161]; // 제일 늦게 끝나도 160을넘을수없다
		int max2 = -1;
		for (int i = 0; i < n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			for (int j = start; j < end; j++) {
				arr2[j]++;
				if(max2 < arr2[j])
					max2 = arr2[j];
			}
		}
	}

}
