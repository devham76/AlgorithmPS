package org.baekjoon;

import java.io.*;
import java.util.*;

public class test2003_numSum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		int[] arr = new int[n];
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0; i<n; i++) {
			int sum=0;
			for (int j=i; j<n; j++) {
				sum += arr[j];
				if(sum >= m) {
					if(sum == m)
						answer++;
					
					break;
				}
				
			}
		}
		System.out.println(answer);
	}

}
