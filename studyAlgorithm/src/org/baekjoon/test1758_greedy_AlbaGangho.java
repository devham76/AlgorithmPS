package org.baekjoon;

import java.io.*;
import java.util.*;

public class test1758_greedy_AlbaGangho {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Long[] arr = new Long[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextLong();
		}
		
		Arrays.sort(arr,Collections.reverseOrder());
		Long answer = 0L;
		for(int i=0; i<n; i++) {
			//System.out.println(arr[i] +" , "+ (arr[i] - i));
			if(arr[i] - i > 0) {
				answer += arr[i] - i;
			}
		}
		System.out.println(answer);
	}

}
