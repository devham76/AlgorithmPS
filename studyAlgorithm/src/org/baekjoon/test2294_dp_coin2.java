// 내풀이 틀렸음 . 아래에 정확할 풀이.
// https://m.blog.naver.com/PostView.nhn?blogId=occidere&logNo=220794872664&proxyReferer=https%3A%2F%2Fwww.google.com%2F
package org.baekjoon;

import java.util.Scanner;

public class test2294_dp_coin2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = sc.nextInt();
		int[] coins = new int[num];
		for (int i=0; i<num; i++)
			coins[i] = sc.nextInt();

		int answer = 0;
		while (sum > 0) {
			int is_exist = 0;
			for (int i=num-1; i >= 0; i--) {
				if (sum >= coins[i]) {
					is_exist = 1;
					sum -= coins[i];
					break;
				}
			}
			answer++;
			if ( is_exist == 0) {
				answer = -1;
				break;
			}
		}
		System.out.println(answer);

		int i,j, n=sc.nextInt(), k=sc.nextInt();
		int a[] = new int[n+1], d[] = new int[k+1];
		
		for( i = 1; i <= k; i++ ) d[i] = 10001; d[0] = 0;
		for( i = 1; i <= n; i++ ) a[i] = sc.nextInt();
		
		for( i = 1; i <=n; i++)
			for( j = a[i]; j <= k; j++)
				d[j] = Math.min(d[j], d[ j - a[i] ] +1);
		
		if (d[k] == 100001) d[k] = -1;
		System.out.println(d[k]);
		sc.close();
	}

}
