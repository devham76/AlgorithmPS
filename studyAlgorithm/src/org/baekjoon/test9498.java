package org.baekjoon;

import java.util.Scanner;
public class test9498 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * ���� ������ �Է¹޾� 90 ~ 100���� A, 80 ~ 89���� B, 70 ~ 79���� C, 60 ~ 69���� D, ������ ������ F�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * ù° �ٿ� ���� ������ �־�����. ���� ������ 0���� ũ�ų� ����, 100���� �۰ų� ���� �����̴�.
 * */
		Scanner scn = new Scanner(System.in);
		int score = scn.nextInt();
		
		if (score>=90)
			System.out.println("A");
		else if (score >=80 && score<=89)
			System.out.println("B");
		else if (score >=70 && score<=79)
			System.out.println("C");
		else if (score >=60 && score<=69)
			System.out.println("D");
		else 
			System.out.println("F");
	}

}
