package org.study;

// https://4ngs.tistory.com/24
// ���ڿ��� �ϳ��� �ɰ��� ������ ��ü���� �迭�� �ְ� 
// ���� ���ڸ� �ٽ� ���� ��ü�� �迭�� �ִ� ��

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
		// �ִ� 26����
		this.child = new TrieNode[26];
		// ���ڿ��� �������� Ȯ��
		this.isTerminal = false;
	}
}