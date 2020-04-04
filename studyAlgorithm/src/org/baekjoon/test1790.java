package org.baekjoon;

import java.util.Scanner;

public class test1790 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long k = sc.nextInt();

		long cnt = 1;
		long numCnt = 9;
		long sum = cnt * numCnt;

		if (k < 10) {
			System.out.println(k);
			return;
		}

		while (k > sum) {
			cnt++;
			numCnt = numCnt * 10;
			sum = sum + (cnt * numCnt);
		}

		sum = sum - (cnt * numCnt);
		long diff = k - sum;

		long location = (diff - 1) / cnt;
		long idx = (diff - 1) % cnt;
		int ten = 0;
		// 2자리이면 10, 3자리이면 20
		while(--cnt>0) {
			ten += cnt*10;
		}
		
		long original = ten + location;
		String or = original+"";
		System.out.println(or.charAt((int) idx));
	}

}
