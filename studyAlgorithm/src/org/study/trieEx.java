package org.study;
// https://4ngs.tistory.com/24
public class trieEx {

	public static void main(String[] args) {

	}
	
	static class TrieNode {
		TrieNode[] child;
		// Ư�� ���ڿ��� ���⼭ ���� ������? �ϰ� üũ�Ѵ�.
		boolean isTerminal;
		
		public TrieNode() {
			this.child = new TrieNode[26];
			this.isTerminal = false;
		}
	}

}
