package org.study;

/*
 *  이진트리
 */
public class TreeBinarySearch {

	// 값이 없는 빈트리를 생성
	private TreeNode root = new TreeNode();

	public TreeNode insertKey(TreeNode root, int x) {
		TreeNode p = root;
		// 값이 x인 새로운 노드를 만든다.
		TreeNode newNode = new TreeNode(x);
		
		
		// 트리가 없다면 새로운 노드가 트리가 된다
		if(p==null) {
			return newNode;
		}
		// 부모 데이터 > 새로운 노드의 데이터 이면
		// 부모의 왼쪽자식에 새로운노드를 입력한다
		else if (p.data > newNode.data) {
			p.left = insertKey(p.left, x);
			return p;
		}
		else if (p.data < newNode.data) {
			p.right = insertKey(p.right, x);
			return p;
		}
		else {
			return p;
		}
	}
	
	// 이진트리 입력시 부모와 값을 입력한다
	public void insertBST(int x) {
		root = insertKey(root, x);
	}
	
	public TreeNode searchBST(int x) {
		TreeNode p = root;
		while(p!=null) {
			if(x<p.data) 
				p = p.left;
			else if (x>p.data)
				p = p.right;
			else 
				return p;
		}
		return p;
	}

	// 왼->오
	public void inorder(TreeNode root) {
		// 트리가 비어있지 않다면
		if(root != null) {
			inorder(root.left);
			System.out.println(root.data+ " ");
			inorder(root.right);
		}
	}
	
	public void printBST() {
		inorder(root);
		System.out.println();
	}
}
