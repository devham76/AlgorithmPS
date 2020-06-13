package org.codingTest;

import java.util.Scanner;

public class s2020_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int idx = 0;
		int[] stack = new int[15];

		int type;
		while (count-- > 0) {
			type = sc.nextInt();

			if (type == 0) { // push
				int source = sc.nextInt();
				if (idx >= 10)
					System.out.println("overflow");
				else
					stack[idx++] = source;

			} else if (type == 1) { // pop
				if (idx <= 0)
					System.out.println("underflow");
				else {
					if (idx == 10)
						idx = 9;
					if (idx == 1)
						idx = 0;
					stack[idx--] = 0;
				}

			} else { // end
				break;
			}
		}

		for (Integer s : stack) {
			if (s == 0)
				break;
			System.out.print(s + " ");
		}
	}

}
