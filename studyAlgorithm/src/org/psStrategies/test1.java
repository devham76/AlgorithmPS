package org.psStrategies;

import java.util.Arrays;
import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 그룸개수 5
		int k = sc.nextInt(); // 매표소 개수 2
		int[] group = new int[n];
		int people = 0;
		for (int i = 0; i < n; i++) {
			group[i] = sc.nextInt();
			people += group[i];
		}
		Arrays.sort(group);
		int[] ticketbox = new int[k];
		for (int i = 0; i < k; i++) {
			ticketbox[i] = group[i];
		}

		int nowgroup = k - 1;
		int time = 0;

		while (people > 0) {
			time++;
			boolean is_possible = false;
			for (int i = 0; i < k; i++) {
				if (ticketbox[i] > 0) {
					System.out.println("ticketbox[" + i + "]=" + ticketbox[i] + " , nowgroup=" + nowgroup + " people="
							+ people + " time=" + time);
					is_possible = true;
					ticketbox[i]--;
					people--;

					if (ticketbox[i] == 0 && nowgroup < n - 1) {
						nowgroup++;
						ticketbox[i] = group[nowgroup];
					}
				}

			}
			if (is_possible == false)
				break;

		}
		System.out.println(time);

	}

}
