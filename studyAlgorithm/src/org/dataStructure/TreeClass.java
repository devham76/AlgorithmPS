package org.dataStructure;

public class TreeClass {
	public static void main(String[] args) {

	}

}

class Tree {
	public Node root;
	
	public void setRoot(Node node) {
		this.root = node;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public Node createNode(Node left, int data, Node right) {
		Node node = new Node();
		node.data = data;
		node.left = left;
		node.right = right;
		
		return node;
	}
	
	// 전위순회 root left right
	public void preOrder(Node node) {
		if(node != null) {
			System.out.println(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

}

class Node {
	int data;
	Node left;
	Node right;
}