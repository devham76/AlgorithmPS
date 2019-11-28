package org.baekjoon;

import java.util.Scanner;

public class test10844_dp_easyStair {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		System.out.println(function(num));
	}
	public static int function (int num) {

		// n자리의 m으로 시작하는 계단의 개수 (m은 1~9)
		long[][] arr = new long[100][10];

		for (int i = 1; i < 10; i++) {

			// 1자리 숫자는 모두 1가지의 계단의 수를 가진다
			arr[0][i] = 1;

			// 2자리의 숫자의 계단의 수
			if(i == 9)
				arr[1][i] = 1;	// 98
			else
				arr[1][i] = 2; // (10,12), (21,23)...(87,89)
		}

		if (num <= 2 )
			return getSum(arr, num);

		// 3자리 수 이상이라면
		for (int i = 2; i < num; i++) {
			for (int j = 1; j < 10; j++) {

				if ( j == 1 )
					arr[i][j] = (arr[i-1][j+1] + arr[i-2][j]) % 1000000000;
				else if ( j == 9 )
					arr[i][j] = arr[i-1][j-1] % 1000000000;
				else
					arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1]) % 1000000000;	
			}
		}
		return getSum(arr, num);	
	}
	public static int getSum(long[][] arr, int num) {
		int answer = 0;
		for (int i = 1; i < 10; i++) {
			answer += arr[num-1][i];
		}
		return answer;
	}
}
