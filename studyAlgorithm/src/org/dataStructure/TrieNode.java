package org.dataStructure;

import java.util.HashMap;
import java.util.Map;

// 자식노드맵 + 현재 노드가 마지막 글자인지 여부 (한 단어가 완성되는 시점임을 알 수 있다)
public class TrieNode {

	// 자식 노드 맵
	private Map<Character, TrieNode> childNodes = new HashMap<>();
	
	// 마지막 글자인지 여부
	private boolean isLastChar;


	Map<Character, TrieNode> getChildNodes(){
		return this.childNodes;
	}
	
	boolean isLastChar() {
		return this.isLastChar;
	}
	
	void setIsLastChar(boolean isLastChar) {
		this.isLastChar = isLastChar;
	}
}
