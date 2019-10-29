package org.doit;
import java.util.Scanner;

public class BinsearchX {

	static int binSearch(int[] a, int n, int key) {
		int pl = 0; 		// �˻� ������ ù �ε���
		int pr = n - 1;		// �˻� ������ �� �ε���
		
		do {
			int pc = ( pl + pr ) / 2;
			if (a[pc] == key) {	// �˻�����
				if (a[pc] == a[pc-1])
					pr = pc - 1;
				else
					return pc;		
			}
			else if (a[pc] < key)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while (pl <= pr);
		
		return -1; 				// �˻�����
	}
	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		
		int[] x = {1,3,5,7,7,7,7,8,8,9,9};
		
		System.out.print("�˻��� �� : ");
		int ky = std.nextInt();
		
		int idx = binSearch(x, x.length, ky);
		
		if(idx == -1)
			System.out.println("�ش簪�� ã�� ���߽��ϴ�.");
		else
			System.out.println("x["+idx+"]�� �ֽ��ϴ�.");
	}
}
