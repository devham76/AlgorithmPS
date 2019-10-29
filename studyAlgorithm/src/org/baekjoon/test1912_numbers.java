package org.baekjoon;
import java.util.Scanner;

public class test1912_numbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] numbers = new int[size];
		
		for(int i=0; i<size; i++)
			numbers[i] = sc.nextInt();
	
		System.out.println(find(numbers, size));
	}
	
	static int find(int[] numbers, int size) {
		int[] amount = new int[size];
		
		amount[0] = numbers[0];	
		int max = amount[0];
		
		if (size == 1)
			return max;
		
		for (int i=1; i<size; i++) {
			amount[i] = Math.max(numbers[i]+amount[i-1], numbers[i]);
			
			if (amount[i] > max)
				max = amount[i];
		}
		return max;
	}

}
