package org.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test14391_paperpeice {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int map[][] = new int[n][m];
		
		int sumR = 0;
		int sumC = 0;
		int idx = (int) Math.pow(10, n);
		for(int x=0; x<n; x++) {
			idx /= 10;
			String string = br.readLine();
			sumR += Integer.parseInt(string);
			for(int y=0; y<m; y++) {
				map[x][y] = Integer.parseInt(string.charAt(y)+"");
				sumC += map[x][y] * idx;
			}
		}
		
		System.out.println(Math.max( sumR, sumC ));
	}

}
