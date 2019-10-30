package org.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

// ��ȭ��ȣ ��� , https://www.acmicpc.net/problem/5052
public class test5052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int now = 0;
		String[] answer = new String[testCase];
		while(testCase != now) {

			int phoneCnt = sc.nextInt();
			String[] phone = new String[phoneCnt];
			for (int i=0; i<phoneCnt; i++)
				phone[i] = sc.next();

			Arrays.sort(phone);
			for (int i=0; i<phoneCnt-1; i++) {
				int clength = phone[i].length();
				int nlength = phone[i+1].length();
				
				// �տ� �ִ°���  �ڿ��ִ°Ϳ� ���Եȴٸ�
				if (nlength > clength) {
					if(phone[i+1].indexOf(phone[i]) > -1) {
						answer[now] = "NO";
						break;
					}
				}
			}
			now++;
		}
		for (String a:answer)
			System.out.println(a);
	}
}
