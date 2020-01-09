package org.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class test1244_maxReward {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		/*
		 * ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		 */
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (int test_case = 1; test_case <= T; test_case++) {

			String[] tmp = br.readLine().split(" ");
			int[] number = new int[tmp[0].length()];
			for (int i = 0; i < number.length; i++) {
				number[i] = tmp[0].charAt(i) - '0';
				hashSet.add(number[i]);
			}
			int change = Integer.parseInt(tmp[1]);

			int tmpInt;
			int idx = 0;
			for (int i = 0; i < number.length; i++)
				System.out.print(number[i]);
			
			System.out.println();
			while (change > 0) {
				if (idx == number.length) {
					if(hashSet.size() != number.length) {
						break;
					}
					tmpInt = number[idx-1];
					number[idx-1] = number[idx - 2];
					number[idx - 2] = tmpInt;
					change--;
					
				} 
				else {
					int max = number[idx];
					int maxIdx = idx;
					// ���� �ڸ����� ū���ڰ� �ڿ� �ִ��� ���ǰ�, �ִٸ� ���� ū ���ڸ� �����´�
					for (int i = idx + 1; i < number.length; i++) {
						if (number[idx] < number[i] && max <= number[i]) {
							max = number[i];
							maxIdx = i;
						}
					}

					// ū ���ڰ� �ִٸ� ���� �ڸ��� �����Ѵ�,
					if (max > number[idx]) {
						tmpInt = number[idx];
						number[idx] = max;
						number[maxIdx] = tmpInt;
						change--;
					}
					idx++;
				}

			}
			System.out.print("#"+test_case+" ");
			for (int i = 0; i < number.length; i++)
				System.out.print(number[i]);
			System.out.println();
			
		}
	}

}
