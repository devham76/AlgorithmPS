package org.baekjoon;

import java.util.Scanner;

public class test1149 {
	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
		  
		  int n = sc.nextInt();
		  int[][] list = new int[n][3];
		  int[][] result = new int[n][3];
		  int min = 0;
		  
		  for (int i=0; i<n; i++) {
			  for (int j=0; j<3; j++)
				  list[i][j] = sc.nextInt();
		  }
		  
		  if(n == 1) {
			  min = findMin(list[0][0], list[0][1], list[0][2]);
		  }
		  else {
				  result[0][0] = Math.min(list[0][1], list[0][2]) + list[1][0];
				  result[0][1] = Math.min(list[0][0], list[0][2]) + list[1][1];
				  result[0][2] = Math.min(list[0][0], list[0][1]) + list[1][2];
			  
			  if (n>2) {
				  for (int i=1; i<n-1; i++) {
					  result[i][0] = Math.min(result[i-1][1], result[i-1][2]) + list[i+1][0];
					  result[i][1] = Math.min(result[i-1][0], result[i-1][2]) + list[i+1][1];
					  result[i][2] = Math.min(result[i-1][0], result[i-1][1]) + list[i+1][2];
				  }
			  }
			  min = findMin(result[n-2][0],result[n-2][1],result[n-2][2]);
		  }
		  System.out.println(min);
	}
	static int findMin(int a, int b, int c) {
		int min = a;
		if( a > b) {
			if (b > c)
				min = c;
			else 
				min = b;
		}
		else {
			if (a > c)
				min = c;
		}
		return min;
	}

}
