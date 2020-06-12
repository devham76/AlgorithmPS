package org.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class test42629 {

	public static void main(String[] args) {
		int[] d = { 4, 10, 15 };
		int[] s = { 20, 5, 10 };
		solution(4, d, s, 30);
	}

	public static int solution(int stock, int[] dates, int[] supplies, int k) {
		int answer = 0;

		// 공급 받은 양이 많은 순으로 추가
		Queue<Integer> suppliesQ = new PriorityQueue<>(Comparator.reverseOrder());

		int index = 0;
		for (int i = 0; i < k; i++) {
			if(index < dates.length && i == dates[index]) {
				suppliesQ.add(supplies[index++]);		
			}
			
			if(stock==0) {
				stock = suppliesQ.poll();
				answer++;
			}
			stock--;
		}
		System.out.println(answer);
		return answer;
	}
}
