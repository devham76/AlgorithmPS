package org.dataStructure;

public class LinkedListTest<T> {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.addLast(1);
		linkedList.addLast(2);
		linkedList.addLast(3);
		System.out.println(linkedList.toString());
	}

}

class ListNode<T> {
	private T data;
	public ListNode link;

	public ListNode(T data, ListNode link) {
		this.data = data;
		this.link = link;
	}
	public T getData() {
		return data;
	}
}

class LinkedList<T> {

	private ListNode head;
	private int size = 0;
	
	LinkedList(){
		// 일반적으로 head는 값을 갖지않고
		// 첫번째 노드를 가르키는 용도로 가진다
		head = new ListNode(null, null);
		size = 0;
	}
	// -- 첫번째 노드 삽입
	protected void addFirst(T data) {
		final ListNode newNode = new ListNode(data, null);

		newNode.link = head.link; // 새로운 노드의 link는 기존의 head를 가르친다
		head.link = newNode; // head는 새로운 노드로 지정

		size++;
	}

	// -- 마지막 노드 삽입
	protected void addLast(T data) {
		final ListNode newNode = new ListNode(data, null);

		// head에서 가르키는게 없다면
		if (head.link == null) {
			head.link = newNode;
		} else {
			
		}

		size++;
	}

	// -- 첫째 노드 삭제
	protected void removeFirst() {
		if(head != null) {
			ListNode head = head.link;
			
		}
	}
	public String toString() {
		StringBuffer result = new StringBuffer();
		ListNode node = head;
		if(node == null) {
			result.append("no data");
		}else {
			result.append(node.getData());
			node = node.link;
			while(node !=null) {
				result.append(", ");
				result.append(node.getData());
				node = node.link;
			}
		}
		return result.toString();
	}

}