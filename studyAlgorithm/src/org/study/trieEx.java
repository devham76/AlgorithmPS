package org.study;
// https://4ngs.tistory.com/24
public class trieEx {

	public static void main(String[] args) {

	}
	
	static class TrieNode {
		TrieNode[] child;
		// 특정 문자열이 여기서 끝이 났나요? 하고 체크한다.
		boolean isTerminal;
		
		public TrieNode() {
			this.child = new TrieNode[26];
			this.isTerminal = false;
		}
	}

}
