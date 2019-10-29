package org.baekjoon;

import java.util.Scanner;

public class test0908 {
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		String input = scn.nextLine();
		String[] strings = input.split(" ");
		int[] ints = new int[2];

		for(int i=0; i<strings.length; i++)
			ints[i] = Integer.parseInt(strings[i]);
		
		if (ints[0] < ints[1])
			System.out.println("<");
		else if (ints[0] > ints[1])
			System.out.println(">");
		else
			System.out.println("==");
		
	}

}
