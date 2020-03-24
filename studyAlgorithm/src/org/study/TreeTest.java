package org.study;

public class TreeTest {

	public static void main(String[] args) {
		TreeBinarySearch bst = new TreeBinarySearch();
		
		bst.insertBST(1);
		bst.insertBST(9);
		bst.insertBST(4);
		bst.insertBST(5);
		bst.insertBST(6);
		
		bst.insertBST(7);
		bst.insertBST(2);
		bst.insertBST(3);
		bst.insertBST(10);
		
		System.out.println("Binary Tree >>>");
		bst.printBST();
		
		System.out.println("Is There '90'?>>>");
		TreeNode p1 = bst.searchBST(90);
		if(p1 != null)
			System.out.println(p1.data+"  exist");
		else
			System.out.println("no");
		
		System.out.println("Is There '10'?>>>");
		TreeNode p2 = bst.searchBST(10);
		if(p2 != null)
			System.out.println(p2.data+"  exist");
		else
			System.out.println("no");
		
		

	}

}
