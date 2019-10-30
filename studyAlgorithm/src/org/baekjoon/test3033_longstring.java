package org.baekjoon;

import java.util.Scanner;

public class test3033_longstring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numlength = sc.nextInt();
		String nums = sc.next();
		
		int max = 0;
		int cnt = 0;
		for (int i=0; i<numlength; i++) {
			String search = nums.substring(i, i+1);
			cnt = 0;
			for (int j=2; j<numlength-i; j++) {
				//System.out.println("search : "+search+ ", cnt:"+cnt+" , indexof:"+nums.indexOf(search, i+1)+", i:"+i);
				if( nums.indexOf(search, i+1)  > -1) {
					cnt++;
					search = nums.substring(i, i+j);
				}
				else {	
					break;
				}
			}
			if(max < cnt)
				max = cnt;
		}
		System.out.println(max);
	}

}
