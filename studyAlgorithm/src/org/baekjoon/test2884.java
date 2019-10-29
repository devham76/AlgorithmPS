package org.baekjoon;

import java.util.Scanner;

public class test2884 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 첫째 줄에 두 정수 H와 M이 주어진다. (0 ≤ H ≤ 23, 0 ≤ M ≤ 59)
		// 45분전으로 
		// next() => 엔터직전까지 받는다. nextLine() => 한줄단위로 받는다.
		
		// 시간 입력
		Scanner scn = new Scanner(System.in);
		String input = scn.nextLine();
		
		// 입력받은 시간을 시,분으로 분리
		String[] string_time = input.split(" ");
		int hour = Integer.parseInt(string_time[0]);
		int min = Integer.parseInt(string_time[1]);
		
		
		if (min < 45) {
			min = min-45+60;
			if (hour > 1)
				hour--;
			else
				hour = 23;
		}
		else
			min = min-45;
		
		System.out.println(hour + " " + min);
				
	}

}
