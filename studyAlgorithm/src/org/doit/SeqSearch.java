package org.doit;

import java.util.Scanner;
/*
 * 
 		���� �˻�
 *
 */
public class SeqSearch {
	
	// ��ڼ��� n�� �迭 a���� key�� ���� ��Ҹ� ���� �˻��մϴ�.
	static int seqSearch(int[] a, int n, int key) {
		
		for (int i=0; i<n; i++) {
			if (a[i] == key) return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		
		System.out.println("��ڼ� : ");
		int num = std.nextInt();
		int[] x = new int[num];
		
		for (int i=0; i<num; i++) {
			System.out.print("x[" + i +"] : ");
			x[i] = std.nextInt();
		}
		
		System.out.println("�˻��� �� : ");
		int ky = std.nextInt();
		
		int idx = seqSearch(x, num, ky);
		
		if(idx == -1)
			System.out.println("�˻����� ã�� ���߽��ϴ�.");
		else
			System.out.println(ky + "�� x[" + idx + "]�� �ֽ��ϴ�.");
	}
}
