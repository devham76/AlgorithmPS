package org.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test7453_sumZero {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		long[][] arr = new long[4][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				arr[j][i] =  Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0; 
		for(int i=0; i<n; i++) {
			long sum = arr[0][i];
			
			for(int j=0; j<n; j++) {
				sum += arr[1][j];
				
				for(int k=0; k<n; k++) {
					sum += arr[2][k];
					
					for(int l=0; l<n; l++) {
						sum += arr[3][l];
						
						
						if(sum == 0)
							answer++;
						
						sum -= arr[3][l];
					}
					sum -= arr[2][k];
				}
				sum -= arr[1][j];
			}
			
		}
		System.out.println(answer);
	}

}
