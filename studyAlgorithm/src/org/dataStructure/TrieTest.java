package org.dataStructure;

public class TrieTest {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("DEV");
		trie.insert("DEAR");
		trie.insert("DESERVE");
		trie.insert("DRIVE");
		
		System.out.println(trie.contains("DEAR"));
		System.out.println(trie.contains("DESERT"));
		
		//trie.delete("DESERT");
		//trie.delete("DE");
		
		trie.delete("DEAR");
		System.out.println(trie.contains("DEAR"));

	}

}
// https://the-dev.tistory.com/2