package org.programmers;

import java.util.*;

public class test42586 {

	public static void main(String[] args) {
		int[] p = { 99, 99, 99, 99 };
		int[] s = { 1, 1, 1, 1 };
		solution(p, s);
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> days = new LinkedList<>();
		for (int i = 0; i < progresses.length; i++) {
			int day = (100 - progresses[i]) / speeds[i];
			if ((100 - progresses[i]) % speeds[i] > 0)
				day++;

			System.out.println(day);
			days.add(day);
		}

		List<Integer> list = new ArrayList<>();
		int prev = days.poll();
		int num = 1;
		int idx = 0;
		while (!days.isEmpty()) {
			int next = days.poll();
			System.out.println("prev=" + prev + " next=" + next);
			if (prev >= next) {
				num++;
			} else {
				list.add(num);
				num = 1;
				prev = next;
			}
		}
		list.add(num);
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
			System.out.println(answer[i]);
		}
		return answer;

	}

}
