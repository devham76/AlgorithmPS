package org.study;

import java.util.*;

public class Trie {


	private TrieNode root;
	
	// -- 생성자 , 루트노드 생성
	public Trie() {
		root = new TrieNode(' ');
	}
	
	// -- 삽입
	public void insert(String word) {
		// 삽입하려는 문자가 모두 존재할때
		if(search(word) == true) return;
		
		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			TrieNode child = current.subNode(ch);
			if(child != null) {
				current = child;
			}
			else {
				// ch 문자가 있으면 그 노드 리턴
				current.childList.add(new TrieNode(ch));
				current = current.subNode(ch);
			}
			current.count++;
		}
		current.terminal = true;
	}
	
	// -- 검색
	public boolean search(String word) {
		TrieNode current = root;
		
		// 문자열을 문자배열로 쪼개서 비교
		for(char ch : word.toCharArray()) {
			// 해당 문자의 노드가 없으면 false
			if(current.subNode(ch) == null) 
				return false;
			// 해당 문자가 존재하면, 현재 노드에 서브 노드 저장해서 단계별로 내려감
			else 
				current = current.subNode(ch);
		}
		
		// a,p,p,l,e 가 있을때, 
		// word = apple 이면 true / word = appleb 이면 false
		if(current.terminal == true) return true;
		
		return false;
	}

	// -- Trie에 저장된 단어 목록 Iterator타입으로 반환
	public Iterator<String> iterator(){
		Set<String> elementsInTrie = new TreeSet<>();
		// 저장됨 데이터를 elementsIntrie에 저장
		recursiveCallPrint(root, "", elementsInTrie);
		Iterator<String> elementsInTrieSet = elementsInTrie.iterator();
	    
        return elementsInTrieSet;
	}
	private void recursiveCallPrint(TrieNode currNode,
			String key, Set<String> elementsInTrie) {
		if(currNode.terminal) {
			elementsInTrie.add(key);
		}
		LinkedList<TrieNode> children = currNode.childList;
        Iterator<TrieNode> childIter = children.iterator();

        String sKey = key;

        while (childIter.hasNext()) {
            TrieNode nextNode = childIter.next();
            // 문자열 합치기 (키+문자)
            String s = sKey + nextNode.nodeChar;
            // 재귀 호출 (다음 노드, 키값, 저장셋)
            recursiveCallPrint(nextNode, s, elementsInTrie);
        }
        
	}
	public void printWord() {

	    System.out.println("▶Elements in the TRIE are :");

	    Iterator<String> itr = iterator();
	    while (itr.hasNext()) {
	        System.out.println(itr.next());
	    }
	    System.out.println("===================");
	}

}

/*
 * 트라이 노드 정의
 * */
class TrieNode implements Comparable<TrieNode>{

	char nodeChar; 		// 문자저장
	boolean terminal; 	// 리프 노드 여부
	int count; 			// 해당 노드 사용수, 내 노드에 몇개의 가지가 있는지
	
	LinkedList<TrieNode> childList; // 자식 노드 리스트
	
	// constructor
	public TrieNode(char c) {
		childList = new LinkedList<>();
		terminal = false;
		nodeChar = c;
		count = 0;
	}
	
	boolean getTerminal() {
		return terminal;
	}
	
	// 해당 노드가 가지고 있는 자식 노드들중에서 입력받은 문자가 있으면 그 노드 리턴
	public TrieNode subNode(char nextChar) {
		// 자식 노드들이 있다면
		if(childList != null) {
			for(TrieNode eachChild:childList) {
				if(eachChild.nodeChar == nextChar) {
					return eachChild;
				}
			}
		}
		
		return null;
	}
	
	@Override
	public int compareTo(TrieNode other) {
		
		return Character.compare(this.nodeChar, other.nodeChar);
	}
	@Override
    public String toString() {
        return this.nodeChar+"("+this.terminal+") ";
    }
	
}
