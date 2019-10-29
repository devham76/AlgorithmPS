package org.baekjoon;

import java.util.*;
public class test11403 {

	static ArrayList<Integer>[] list;
	static int[][] result;
	static boolean[] visited;
	static int stage;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		result = new int[size][size];
		list = new ArrayList[size];
		for (int i=0; i<size; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				if (sc.nextInt() == 1) {
					int x = i;
					int y = j;
					
					list[i].add(j);
				}
			}
		}
		
		 for(stage=0; stage<size; stage++) {
		 
			visited = new boolean[size];
			dfs(stage);
		}
		
		 for(int i=0; i<size; i++) {
			 for(int e:result[i])
				 System.out.print(e+" ");
			 
			 System.out.println();
		 }
		 
		
	}
	static void dfs(int node) {
		
		if (list[node].isEmpty())
			return;
		
		for (int e:list[node]) {
			if (visited[e] == false) {
				visited[e] = true;
				result[stage][e] = 1;
				dfs(e);
			}
		}
		
	}

}
