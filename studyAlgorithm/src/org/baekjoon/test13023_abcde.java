package org.baekjoon;

import java.util.*;

public class test13023_abcde {
	
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 사람수
		int m = sc.nextInt(); // 관계수
		arr = new int[n];
		for (int i=0; i<m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			union(x, y);
		}
		
		for(Integer a: arr)
			System.out.print(a+" ");
	}
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		arr[y] = x;
	}
	private static int find(int x) {
		if(arr[x] == x) {
			return x;
		}
		else {
			return find(arr[x]);
		}
	}

}
