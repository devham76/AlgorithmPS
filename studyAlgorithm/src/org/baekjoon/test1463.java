package org.baekjoon;

import java.util.Scanner;

public class test1463 {

	static int arr[] = new int[1000001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;
		System.out.println("--");
		fun(num);
		for(int i=0; i<num+1; i++)
			System.out.print("arr["+i+"] :"+arr[num]+" ");
	}
	
	static int fun(int num) {
		
		if (num == 1)
			return 0;
		
		if (num % 2 == 0) {
			arr[num] = fun(num/2) + 1;
		}
		else if (num %3 == 0) {
			arr[num] = fun(num/3) +1;
		}
		else
			arr[num] = fun(num-1) +1;
		
		return arr[num];
	}

}
