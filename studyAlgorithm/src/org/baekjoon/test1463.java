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
		fun2(num);
		for(int i=0; i<num+1; i++)
			System.out.print("arr["+i+"] :"+arr[num]+" ");
	}
	
	
	static int fun2(int num) {
		int ans = 0;
		while(num > 1) {
			
			if (num % 3 == 0) num = num/3;
			else {
				if ( (num -1) % 3 == 0 )  num -= 1;
				else if (num % 2 == 0) num = num/2;
				else num -= 1;
			}

			ans++;
			
		}
		System.out.println("-->"+ans);
		return ans;
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
