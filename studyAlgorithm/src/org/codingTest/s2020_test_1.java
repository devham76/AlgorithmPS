package org.codingTest;

import java.text.DecimalFormat;
import java.util.Scanner;

public class s2020_test_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += sc.nextInt();
		}

		DecimalFormat format = new DecimalFormat();
		format.applyLocalizedPattern("0.00");
		String avg = format.format(sum / 3);
		System.out.print(avg);
		float result = Float.parseFloat(avg);
		if (result >= 90)
			System.out.print(" A");
		else if (result >= 80)
			System.out.print(" B");
		else if (result >= 70)
			System.out.print(" C");
		else if (result >= 60)
			System.out.print(" D");
		else
			System.out.print(" F");
	}

}
