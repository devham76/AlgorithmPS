package org.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1806 {

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
		
		int min = n;
		for(int i=0; i<n; i++) {
			int sum=0;
			for (int j=i; j<n; j++) {
				sum += arr[j];
				if(sum >= m) {
					min = Math.min(min, j-i+1);
					answer++;
					break;
				}
				
			}
		}
		if(answer == 0)
			min = 0;
		System.out.println(min);
	}

}