package org.baekjoon;

import java.util.Scanner;

public class test1932 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sc = new Scanner(System.in);
		  
		  int n = sc.nextInt();
		  int[][] list = new int[n+1][n+1];
		  int max = 0;
		  for (int i=1; i<=n; i++) {
			  for (int j=1; j<=i; j++) {
				  list[i][j] = sc.nextInt();
				  
				  // 1. 왼쪽 대각선
				  if(j==1) list[i][1] = list[i][1] + list[i-1][1];
				  // 2. 오른쪽 대각선
				  else if(i==j) list[i][j] = list[i][j] + list[i-1][j-1];
				  // 3. 대각선이 아니라면 부모중에 큰값과 더한다.
				  else
					  list[i][j] = list[i][j] + Math.max(list[i-1][j-1], list[i-1][j]);
				  
				  if (list[i][j] > max)
					  max = list[i][j];
			  }
		  }
		  System.out.println(max);
	}

}
