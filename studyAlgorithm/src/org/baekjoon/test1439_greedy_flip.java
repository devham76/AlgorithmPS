package org.baekjoon;

import java.util.*;

public class test1439_greedy_flip {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] st = sc.next().split("");
		int[] list = new int[st.length];
		int[] arr = new int[2];
		for(int i=0; i<st.length;i++)
			list[i] = Integer.parseInt(st[i]);
		
		arr[list[0]] = 1;
		int before = list[0];
		for(int i=1; i<st.length; i++) {
			if(before != list[i]) {
				arr[list[i]] ++;
			}	
			before = list[i];
		}
		System.out.println(Math.min(arr[0], arr[1]));
	}

}
