// https://www.acmicpc.net/problem/1931
package org.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class test1931_greedy_meetingRoom {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int meetingCnt = sc.nextInt();
		int[][] meeting = new int[meetingCnt][2];

		// ȸ�ǽð� �Է�
		for (int i = 0; i < meetingCnt; i++) {
			meeting[i][0] = sc.nextInt();
			meeting[i][1] = sc.nextInt();
		}
		Arrays.sort(meeting,(meeting1 , meeting2) -> meeting1[1]==meeting2[1] ? meeting1[0]-meeting2[0] : meeting1[1]-meeting2[1]); 
		// ������ �ð���� �����Ѵ�.
		// ���� ������ ���� �ð����� �����Ѵ�. 
		// ������ �ð��� �������� �����ִ� �ð��� ��������.��, �� ���� ȸ�Ǹ� �� �� �ִ�.
		
		int count = 0;
		int prevFinish = -1;
		for (int i = 0; i < meeting.length; i++) {
			if (meeting[i][0]>= prevFinish) {
				count++;
				prevFinish = meeting[i][1];
			}
		}
		System.out.println(count);

	}
}
