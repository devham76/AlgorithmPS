package org.baekjoon;

import java.io.*;
import java.util.*;

public class test2875_greedy_CompetitionOrIntern {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 여학생수
		int M = Integer.parseInt(st.nextToken());	// 남학생수
		int K = Integer.parseInt(st.nextToken());	// 필요인턴수
		
		int team = Math.min(N/2, M);
		int remain = (N- (team*2)) + (M-team);
		int needIntern = K-remain;
		System.out.println(team+", "+remain+", "+needIntern);
		if(team == 0 )
			System.out.println(0);
		else if(needIntern<=0)
			System.out.println(team);
		else {
			float ni = (float) needIntern;
			System.out.println((int) (team - Math.ceil(ni/3)));
		}

	}

}
