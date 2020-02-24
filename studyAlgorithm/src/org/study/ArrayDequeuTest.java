package org.study;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDequeuTest {

	public static void main(String[] args) {

		ArrayDeque obj = new ArrayDeque();
		
		obj.add("네이버");
		obj.addFirst("라인");
		obj.offerFirst("카카오"); // t or f 반환
		obj.offerLast("쿠팡"); // t or f 반환
		
		// 검색
		System.out.println("retrieving first element : "+obj.peekFirst());
		System.out.println("retrieving last element : "+obj.peekLast());
		
		// 삭제
		System.out.println("Removing first element : "+obj.pollFirst());
		System.out.println("Removing last element : "+obj.pollLast());
		
		// reverse traversal	// 역 순회
		System.out.println("Remaining elements : ");
		Iterator it = obj.descendingIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
