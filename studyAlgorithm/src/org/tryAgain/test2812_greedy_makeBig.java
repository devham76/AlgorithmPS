package org.tryAgain;

import java.io.*;
import java.util.*;

public class test2812_greedy_makeBig {

	public static void main(String[] args) throws IOException {

		int n,k;
		String s;
		char[] temp;
		Deque<Integer> dq = new LinkedList<Integer>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		s = br.readLine();
		
		for (int i=0; i<n; i++) {
			
			// k : 제거할 수 , 큐가 비어있지않을때  / 새로들어올 수가 마지막 숫자보다 작거나 같을때까지 마지막 숫자 삭제
			while (k>0 && !dq.isEmpty() && dq.peekLast() < s.charAt(i) - '0') {
				dq.removeLast(); 
				--k;	// 숫자를 제거 했으므로 k--해준다
			}
			
			dq.addLast(s.charAt(i) - '0');
		}
		
		while(!dq.isEmpty() && n-k > 0) {
			bw.write(String.valueOf(dq.pollFirst()));
			++k;
		}
		bw.flush();
		bw.close();
	}

}
