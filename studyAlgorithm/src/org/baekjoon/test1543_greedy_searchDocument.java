package org.baekjoon;

import java.util.Scanner;

public class test1543_greedy_searchDocument {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String document = sc.nextLine();
		String word = sc.nextLine();
		int len = word.length();
		System.out.println(len);
		int max=0;
		for(int start=0; start<document.length(); start++) {

			System.out.println("----start :"+start+"---");
			int count=0;
			for(int i=start; i<document.length();) {
				System.out.println("i :"+i+" ,i+len"+ (i+len));
				if(i+len <= document.length()) {
					System.out.println(document.substring(i, i+len-1));
					if(document.substring(i, i+len).equals(word)) {
						count++;
						i+=start+len;
					}
					else 
						i++;
				}
				else
					i++;
			}
			max = Math.max(max, count);
		}
		
		System.out.println(max);
	}

}
