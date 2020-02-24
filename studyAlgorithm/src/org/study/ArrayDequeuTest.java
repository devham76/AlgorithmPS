package org.study;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDequeuTest {

	public static void main(String[] args) {

		ArrayDeque obj = new ArrayDeque();
		
		obj.add("���̹�");
		obj.addFirst("����");
		obj.offerFirst("īī��"); // t or f ��ȯ
		obj.offerLast("����"); // t or f ��ȯ
		
		// �˻�
		System.out.println("retrieving first element : "+obj.peekFirst());
		System.out.println("retrieving last element : "+obj.peekLast());
		
		// ����
		System.out.println("Removing first element : "+obj.pollFirst());
		System.out.println("Removing last element : "+obj.pollLast());
		
		// reverse traversal	// �� ��ȸ
		System.out.println("Remaining elements : ");
		Iterator it = obj.descendingIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
