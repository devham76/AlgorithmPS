package org.study;

/*
 *  ����Ʈ��
 */
public class TreeBinarySearch {

	// ���� ���� ��Ʈ���� ����
	private TreeNode root = new TreeNode();

	public TreeNode insertKey(TreeNode root, int x) {
		TreeNode p = root;
		// ���� x�� ���ο� ��带 �����.
		TreeNode newNode = new TreeNode(x);
		
		
		// Ʈ���� ���ٸ� ���ο� ��尡 Ʈ���� �ȴ�
		if(p==null) {
			return newNode;
		}
		// �θ� ������ > ���ο� ����� ������ �̸�
		// �θ��� �����ڽĿ� ���ο��带 �Է��Ѵ�
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
	
	// ����Ʈ�� �Է½� �θ�� ���� �Է��Ѵ�
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

	// ��->��
	public void inorder(TreeNode root) {
		// Ʈ���� ������� �ʴٸ�
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
