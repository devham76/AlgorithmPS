	package org.baekjoon;

import java.util.Scanner;

public class test11058 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = N;
		if(N >= 7) {
			
			for(int i=2; i <= (N-1)/2 ; i++) {
				System.out.println(i+" * "+(N-1-i)+"="+i * (N-1-i));
				answer = Math.max(answer, i * (N-1-i));
			}
		}
		System.out.println(answer);

	}

}
