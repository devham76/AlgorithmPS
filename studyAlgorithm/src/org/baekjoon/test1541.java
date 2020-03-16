package org.baekjoon;

import java.io.*;
import java.util.*;

/*
 * 나의 문제점 : 컴퓨팅적인 사고 부족
 * 해결 : 55-50+40 = 55 -(50+40) 이므로 + 인것들끼리 먼저 다 더하고 뺴준다.
 * */

public class test1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
	
		
		String[] arr = input.split("\\-");
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			int pluseSum = cal(arr[i]);
			if(i==0)
				pluseSum *= -1;
			sum -= pluseSum;
		}
		System.out.println(sum);
	}

	private static int cal(String input) {
		String[] arr = input.split("\\+");
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum += Integer.parseInt(arr[i]);
		}
		return sum;
	}

}
