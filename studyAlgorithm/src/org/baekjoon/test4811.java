package org.baekjoon;

import java.util.Scanner;

public class test4811 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		while(test_case > 0) {
			test_case--;
			int n = sc.nextInt();
			// 2n일 동안 먹는다
			long[][] pillArray = new long[2*n+1][2*n+1];
			int full = n-1; // 처음에 반알을 먹으므로 전체는 -1
			int half = 1; // 처음에 반알을 먹으므로 반알짜리가 하나 생긴다.
			
			System.out.println(n+" : "+pillCnt(full, half, pillArray));
			
			for(int i=0; i<2*n+1; i++) {
				for(int j=0; j<2*n+1; j++) {
					System.out.print(pillArray[i][j]+" ");
				}
			}
		}

	}

	private static long pillCnt(int full, int half, long[][] pillArray) {
		
		if(full > 0 ) {
			if(pillArray[full][half] != 0)
				return pillArray[full][half];
		}
		
		// 전체 알약이 없으면 반알씩 먹는방법뿐이므로 return 1
		if( full == 0) {
			pillArray[full][half] = 1;
			return 1;
		}
		else {
			long sum = 0;
			// 전체의 반을 먹음면 전체-1 반짜리+1
			sum += pillCnt(full-1, half+1, pillArray);
			// 반쪽짜리가 있으면
			if(half > 0)
				sum += pillCnt(full, half-1, pillArray);
			
			pillArray[full][half] = sum;
			return pillArray[full][half];
		}
	}

}
