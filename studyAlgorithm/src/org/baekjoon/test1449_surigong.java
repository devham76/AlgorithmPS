package org.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class test1449_surigong {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N 	= sc.nextInt();
		int L 	= sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		int start = 0;
		int tape = 1;
		boolean need_more;
		while(true) {
			need_more = false;
			for(int i=start+1; i<arr.length; i++) {
				if(arr[i]-arr[start] + 1 > L) {
					start = i;
					need_more = true;
					tape++;
					break;
				}
			}
			if(need_more == false)
				break;
			
		}
		System.out.println(tape);
	}

}
