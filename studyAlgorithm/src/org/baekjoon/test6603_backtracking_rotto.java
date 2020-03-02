package org.baekjoon;

import java.io.*;
import java.util.*;

public class test6603_backtracking_rotto {
	public static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = br.readLine();
			if(str.equals("0"))
				return;
			StringTokenizer st = new StringTokenizer(str);
			int n = Integer.parseInt(st.nextToken());
			arr = new int[n];
			for(int i=0; i<arr.length; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			List<Integer> list = new ArrayList();
			for(int i=0; i<=arr.length-6; i++) {
				list.add(arr[i]);
				fun(list, i+1);
				list.remove(0);
			}
			System.out.println();
			
		}
		

	}

	private static void fun(List<Integer> list, int idx) {
		if(list.size() == 6) {
			for(int l:list) {
				System.out.print(l+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=idx; i<arr.length; i++) {
			list.add(arr[i]);
			fun(list, i+1);
			list.remove(list.size()-1);
		}
			
		
	}

}
