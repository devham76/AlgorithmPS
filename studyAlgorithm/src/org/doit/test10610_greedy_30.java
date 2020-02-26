package org.doit;

import java.io.*;
import java.util.*;

public class test10610_greedy_30 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		if(!N.contains("0")) System.out.println("-1");
		else {
			int[] numberCount = new int[10];
			int sum=0;
			for(int i=0; i<N.length(); i++) {
				int num = Integer.parseInt(N.charAt(i)+"");
				numberCount[num]++;
				sum += num;
			}
			
			// 각자리를 더한 값이 3의 배수이면 이 숫자는 3의 배수이다!!!
			if(sum  % 3 == 0) {
				// 가장 큰수를 구해야 하므로 제일 큰수부터 출력한다
				for(int i=9; i>=0;i--) {
					// 제일 큰 수의 개수만큼 출력한다
					for(int j=0; j<numberCount[i]; j++) {
						System.out.print(i);
					}
					
				}
			}
			else 
				System.out.println("-1");
		}
		

	}

}
