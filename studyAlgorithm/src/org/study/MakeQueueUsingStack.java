package org.study;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MakeQueueUsingStack {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		Stack<Integer> s = new Stack();

		Stack<Integer> s1 = new Stack();
		Stack<Integer> s2 = new Stack();
		
		for(int i=1; i<4; i++) {
			q.add(i);
			s.push(i);

			s1.push(i);
		}
		
		System.out.println("큐 출력값");
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		System.out.println("스택 출력값");
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
		
		//------------------------
		while(!s1.isEmpty()) {
			int num = s1.pop();
			s2.push(num);
		}
		System.out.println("스택2 출력값");
		while(!s2.isEmpty()) {
			System.out.println(s2.pop());
		}
	}

}
