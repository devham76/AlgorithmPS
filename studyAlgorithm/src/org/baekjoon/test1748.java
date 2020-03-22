package org.baekjoon;

import java.util.Scanner;

public class test1748 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int multi = 10;
		int idx = 1;
		int sum=0;
		while(true) {
			
			if (n > multi) {
				sum += (multi - multi/10)*idx;
			}
			else {
				sum += (n-(multi/10)+1) * idx;
				if(n == multi) sum++;
				break;
			}
			idx++; 			// 자리수
			multi *= 10;	// 10의배수
			
			
		}
		System.out.println(sum);
	}

}
