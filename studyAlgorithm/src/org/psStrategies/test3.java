package org.psStrategies;

import java.util.Arrays;
import java.util.Scanner;


public class test3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt(); // start
			arr[i][1] = sc.nextInt(); // end
		}
		Arrays.sort(arr, (o1,o2)->{
			if(o1[1]== o2[1])
				return Integer.compare(o1[0], o2[0]);
			else
				return Integer.compare(o1[1], o2[1]);
		});
		
		int max = 1;
		for(int i=0; i<n; i++) {
			int end = arr[i][1];
			int answer = 1;
			for(int j=i+1; j<n; j++) {
				int nextstart = arr[j][0];
				if(nextstart<end) {
					answer++;
				}
			}
			max = Math.max(max, answer);
		}
		System.out.println(max);
	}

}
