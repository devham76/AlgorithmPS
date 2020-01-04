package org.study;

// https://4ngs.tistory.com/24
// 문자열을 하나씩 쪼개서 각각을 객체안의 배열에 넣고 
// 다음 문자를 다시 다음 객체의 배열에 넣는 것

import java.io.*;
public class trieEx {
/*
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		String[] str = null;
		int n=0,m=0;
		String[] nArr,mArr;
		TrieNode nRoot;
		
	}
	
*/

}
class TrieNode{
	TrieNode[] child;
	boolean isTerminal;
	TrieNode(){
		// 최대 26글자
		this.child = new TrieNode[26];
		// 문자열이 끝났는지 확인
		this.isTerminal = false;
	}
}