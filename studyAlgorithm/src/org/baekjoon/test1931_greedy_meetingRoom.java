// https://www.acmicpc.net/problem/1931
package org.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class test1931_greedy_meetingRoom {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int meetingCnt = sc.nextInt();
		int[][] meeting = new int[meetingCnt][2];

		// 회의시간 입력
		for (int i = 0; i < meetingCnt; i++) {
			meeting[i][0] = sc.nextInt();
			meeting[i][1] = sc.nextInt();
		}
		Arrays.sort(meeting,(meeting1 , meeting2) -> meeting1[1]==meeting2[1] ? meeting1[0]-meeting2[0] : meeting1[1]-meeting2[1]); 
		// 끝나는 시간대로 정렬한다.
		// 만약 같으면 시작 시간으로 정렬한다. 
		// 끝나는 시간이 빠를수록 남아있는 시간이 많아진다.즉, 더 많은 회의를 할 수 있다.
		
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
