package org.important;

import java.util.*;
public class kakao_2019_Tree_findWay {

	public static void main(String[] args) {
		// 이진탐색트리 문제
		int[][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1},{1, 3}, {8, 6}, {7, 2}, {2, 2}};
		kakao_2019_Tree_findWay k = new kakao_2019_Tree_findWay();
		k.solution(nodeinfo);
	}
	
	// ����� ���� / id:���Ե� ����, x,y���� ���� �Է��Ѵ�
	class Node{
		Node(int id, int x, int y){
			this.id = id;
			this.x = x;
			this.y = y;
		}
		int id;
		int x,y;
		Node left;
		Node right;
	}
	
	// answer�� ��ȸ�ϴ� ������ ������ ������ �������ش�.
	int idx;
	// List : ������ �ִ�
	List<Node> Nodes = new ArrayList<Node>();
	
	// y���� ������ �켱�̰�, y���� ���ٸ� x���� ������ �켱�̴�
	Comparator<Node> Comp = new Comparator<Node>() {
		public int compare(Node a, Node b) {
			if(a.y == b.y)
				return a.x - b.x;	// x�� ���� ���� ������ �´�
			
			return b.y - a.y;
		}
	};
	/*
	 *�׳� sort�ε� ��������
	Nodes.sort((node1,node2) -> 
		(node1.y == node2.y) ? 
			(node1.x - node2.x) : (node1.y - node2.y));

	*/
	
	void addNode(Node parent, Node child) {
		if(child.x < parent.x) {
			if(parent.left == null)
				parent.left = child;
			else	// 부모의 자식에 자식을 추가
				addNode(parent.left, child);
		}
		else {
			if(parent.right == null)
				parent.right = child;
			else
				addNode(parent.right, child);
		}
	}
	
	void preorder(int[][] answer, Node node) {
		if (node == null) return;
		answer[0][idx++] = node.id;
		preorder(answer, node.left);
		preorder(answer, node.right);
	}
	void postorder(int[][] answer, Node node) {
		if (node == null) return;
		postorder(answer, node.left);
		postorder(answer, node.right);
		answer[1][idx++] = node.id;
	}
	
	//-------
	//-- ����
	//-------
    public int[][] solution(int[][] nodeinfo) {
    	int size = nodeinfo.length;
    	
    	//-- 1. x,y���� ���� ��带 ����Ʈ�� �ִ´�
    	// �ԷµǴ� ���� ����Ʈ�� �Է��Ѵ�
    	// ���ĵ��� ���� ���·� list�� �����ȴ�
    	for (int i=0; i<size; ++i) {
    		Nodes.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
    	}
    	
    	// y�� ��������, y�� ������ x�� ������������ �����Ѵ�
    	Nodes.sort(Comp);
    	
    	//-- 2. ����� Ʈ���� �����Ѵ�
    	// Ʈ���� ��Ʈ�� ù��° ��尡 �ȴ�.
    	Node root = Nodes.get(0);
    	for (int i=1; i<size; ++i) {
    		// �θ��� , ���ο� ���
    		addNode(root, Nodes.get(i));
    	}
    	
    	int[][] answer = new int[2][size];
    	preorder(answer, root);
    	idx = 0;
    	postorder(answer, root);
    	
    	
    	//------
    	// �� Ȯ�ο�
    	for (int i=0; i<size; ++i) {
    		System.out.print(Nodes.get(i).id+ " ");
    	}
    	System.out.println();
    	for (int j=0; j<2; ++j) {
    		for (int i=0; i<size; ++i) {
    			System.out.print(answer[j][i]+ " ");
    		}
    		System.out.println();
    	}
    	
        return answer;
    }

}
