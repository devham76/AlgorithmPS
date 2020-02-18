package org.baekjoon;

import java.util.*;


public class test9576_greedy_book {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		while(testCase>0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[M][2];
			for(int i=0; i<M; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
		
			Arrays.sort(arr, (o1,o2)->{
				if(o1[1] < o2[1])
					return -1;
				else if (o1[1]> o2[1])
					return 1;
				
				return Integer.compare(o1[0], o2[0]);
			});
			
		
			
			boolean[] visited = new boolean[N+1];
			int answer=0;
			for(int i=0; i<M; i++) {
				for(int j=arr[i][0]; j<=arr[i][1]; j++) {
					
					if(visited[j] == false) {
						answer++;
						visited[j] = true;
						break;
					}
				}
			}
			System.out.println(answer);
		
			testCase--;
		}
	}

}
