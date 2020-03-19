package org.baekjoon;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class test1915 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int[][] map = new int[m+1][n+1];
		int[][] arr = new int[m+1][n+1];
		for(int i=1; i<=m; i++) {
			String str = sc.next();
			
			for(int j=1; j<=n; j++) {
				arr[i][j] = Integer.parseInt(str.charAt(j-1)+"");
			}
		}
		
		int answer = 0;
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				
				
				map[i][j] = Math.min(map[i-1][j], Math.min(map[i][j-1], map[i-1][j-1]) );
				map[i][j] = arr[i][j] == 0 ? 0 : map[i][j]+1;
				
				if(answer < map[i][j])
					answer = map[i][j];
				
				
			}
		}
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("--------------");
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(answer*answer);
	}

}
