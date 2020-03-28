package org.baekjoon;

import java.util.Scanner;

public class test1495 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 노래개수
		int s = sc.nextInt(); // 시작 볼륨
		int m = sc.nextInt(); // 최대볼륨
		int[] volumes = new int[n + 1];
		boolean[][] dp = new boolean[n + 1][m + 1];
		for (int i = 1; i <= n; i++)
			volumes[i] = sc.nextInt();

		dp[0][s] = true; // 0번째 노래의 볼륨은 5이다.
		int max = -1;
		
		for (int song = 1; song <= n; song++) {
			for (int volume = 0; volume <= m; volume++) {
				//System.out.println("vol="+volume+", volumes[song]="+volumes[song]+" 이전="+dp[song - 1][volume]);
				if (dp[song - 1][volume] == true) {
					if (volume - volumes[song] >= 0 ) {
						dp[song][ volume - volumes[song] ] = true;
					}
					if (volume + volumes[song] <= m) {
						dp[song][ volume + volumes[song] ] = true;
					}				
					
				}
			}
		}
		
		for (int volume = 0; volume <= m; volume++) {
			if (dp[n][volume] == true)
				max = Math.max(volume, max);
		}
		System.out.println(max);
	}

}
