// Ç®ÀÌ : https://zoonvivor.tistory.com/114
package org.baekjoon;

import java.util.Scanner;

public class test9465_dp_sticker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		while (testCase != 0) {
			int num = sc.nextInt();
			int[][] sticker = new int[2][num];
			
			for( int i = 0; i < num; i++)
				sticker[0][i] = sc.nextInt();
			for( int i = 0; i < num; i++)
				sticker[1][i] = sc.nextInt();
			getMax(num, sticker);
		}
	}
	public static void getMax(int num, int[][] sticker) {
		boolean[][] visited = new boolean[2][num];
		int max = 0;
		for( int i = 0; i < num; i++) {
			if (visited[0][i] == false) {
				int sum1 = sticker[1][i];
				if (i+1 < num)
					sum1 += sticker[0][i+1];
				
				for (int j = 0; j < num; j++) {
					if(visited[1][j] == false) {
						int sum2 = sticker[0][j];
						if (j+1 < num)
							sum2 += sticker[1][j+1];
						
						System.out.println("sum1:"+sum1+" , sum2:"+sum2);
						if (sum1 > sum2) {
							max += sticker[1][j];
							if (j+1 < num) visited[1][j+1] = true; 
							visited[0][j] = true;
							continue;
						}
						else if (sum1 < sum2) {
							max += sticker[0][i];
							if (i+1 < num) visited[0][i+1] = true; 
							visited[1][i] = true;
							continue;
						}
						else {
							if(sticker[0][i] > sticker[1][j]) {
								max += sticker[0][i];
								if (i+1 < num) visited[0][i+1] = true; 
								visited[1][i] = true;
								continue;
							}
							else {
								max += sticker[1][j];
								if (j+1 < num) visited[1][j+1] = true; 
								visited[0][j] = true;
								continue;
							}
						}
					
						
					}
					
				}
				System.out.println("max->"+max);
			}
			
		}
		System.out.println(max);
	}
}

/*
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Main {
 
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // BufferedReader br = new BufferedReader(new
        // InputStreamReader(System.in));
 
        int Testcase = Integer.parseInt(br.readLine());
        int[][] arr;
        int[][] dp;
        String[] str;
        for (int t = 0; t < Testcase; t++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N+1][2];
            dp = new int[N+1][2];
            for (int i = 0; i < 2; i++) {
                str = br.readLine().split(" ");
                for (int j = 1; j <=N; j++) {
                    arr[j][i] = Integer.parseInt(str[j-1]);
                }
            }
            
            dp[1][0] = arr[1][0];
            dp[1][1] = arr[1][1];
            for(int i=2; i<=N; i++){
                dp[i][0] = Math.max(dp[i-1][1],dp[i-2][1] ) + arr[i][0];
                dp[i][1] = Math.max(dp[i-1][0],dp[i-2][0] ) + arr[i][1];
            }
            System.out.println(Math.max(dp[N][0], dp[N][1]));
        }
    }
}
*/