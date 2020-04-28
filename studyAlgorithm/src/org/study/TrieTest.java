package org.study;

public class TrieTest {

	public static void main(String[] args) {
	     
        //자료구조에 저장할 데이터
       // String data[] = {"abcd","abcf", "bcd","a", "bcdefg", "defg", "aac", "baz", "foo", "foobar","자바"};
        
        Trie matcher = new Trie();

	    matcher.insert("abcd");
	    matcher.insert("abcf");
	    matcher.insert("bcd");

        //trie에 있는 데이터 콘솔에 나열.
        matcher.printWord(); 
        
       System.out.println(matcher.search("abcd"));
       
      
      
	}

}
