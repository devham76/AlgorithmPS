package org.programmers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Level2_42626 {

	public static void main(String[] args) {
		int[] s = { 1, 2, 3, 9, 10, 12 };
		solution(s, 7);

	}

	public static int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(Integer s:scoville) {
			pq.offer(s);
		}
		
		Iterator it2 = pq.iterator();
		while(it2.hasNext()) {
			int a = (int) it2.next();
			System.out.print(a+" ");
		}
		System.out.println();
		
		while (pq.peek() < K) {
			int one = pq.poll();
			int two = pq.poll();
			
			int newS = one + two*2;
			System.out.println("-> "+newS);
			pq.offer(newS);
			
			
			Iterator it = pq.iterator();
			while(it.hasNext()) {
				int a = (int) it.next();
				System.out.print(a+" ");
			}
			System.out.println();
			
			answer++;
		}
		System.out.println(answer);
		return answer;
	}

}
