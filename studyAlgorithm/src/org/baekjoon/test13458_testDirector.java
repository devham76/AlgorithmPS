package org.baekjoon;

import java.util.Scanner;

public class test13458_testDirector {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] testor = new int[n];
		for (int i=0; i<n; i++)
			testor[i] = sc.nextInt();
		
		int[] director = new int[2];
		director[0] = sc.nextInt();
		director[1] = sc.nextInt();
		
		// 큰 값이 나올 수 있으므로 long으로 선언해야한다 !!!조심 !!
		long answer = 0;
		for (int i=0; i<n; i++) {
			//System.out.println(Math.ceil((testor[i] - director[0]) / (double)director[1]));
			int second = (int) Math.ceil((testor[i] - director[0]) / (double)director[1]);
			//System.out.println("second : "+second);
			second = second > 0 ? second : 0;
			answer += second+1;
		}
		System.out.println(answer);
	}

}
