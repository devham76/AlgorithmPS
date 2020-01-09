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
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
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
					// 현재 자리보다 큰숫자가 뒤에 있는지 살피고, 있다면 가장 큰 숫자를 가져온다
					for (int i = idx + 1; i < number.length; i++) {
						if (number[idx] < number[i] && max <= number[i]) {
							max = number[i];
							maxIdx = i;
						}
					}

					// 큰 숫자가 있다면 현재 자리와 변경한다,
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
