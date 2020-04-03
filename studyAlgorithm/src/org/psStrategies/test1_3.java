package org.psStrategies;

import java.util.Arrays;
import java.util.Scanner;

public class test1_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 그룸개수 5
		int k = sc.nextInt(); // 매표소 개수 2
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		int[] box = new int[k];
		for(int i=0; i<n; i++) {
			box[0] += arr[i];
			Arrays.sort(box);
		}
		System.out.println(box[k-1]);
	}

}
