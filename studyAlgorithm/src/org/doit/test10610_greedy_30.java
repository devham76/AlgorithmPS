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
			
			// ���ڸ��� ���� ���� 3�� ����̸� �� ���ڴ� 3�� ����̴�!!!
			if(sum  % 3 == 0) {
				// ���� ū���� ���ؾ� �ϹǷ� ���� ū������ ����Ѵ�
				for(int i=9; i>=0;i--) {
					// ���� ū ���� ������ŭ ����Ѵ�
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
