package org.baekjoon;

import java.util.Scanner;

public class test2884 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ù° �ٿ� �� ���� H�� M�� �־�����. (0 �� H �� 23, 0 �� M �� 59)
		// 45�������� 
		// next() => ������������ �޴´�. nextLine() => ���ٴ����� �޴´�.
		
		// �ð� �Է�
		Scanner scn = new Scanner(System.in);
		String input = scn.nextLine();
		
		// �Է¹��� �ð��� ��,������ �и�
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
