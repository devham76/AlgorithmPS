package StreamLambda;

import java.util.Arrays;

public class Cal {

	public static void main(String[] args) {

		// 익명클래스
		Calculator calc = new Calculator() {

			@Override
			public int plusOne(int n) {
				return n + 1;
			}

		};

		int n = 3;
		System.out.println(calc.plusOne(n));

		Calculator calc2 = (num1) -> {
			return num1 + 1;
		};
		System.out.println(calc2.plusOne(4));

		Calculator calc3 = num2 -> {
			return num2 + 1;
		};
		System.out.println(calc3.plusOne(5));

		int[] arr = new int[5];
		Arrays.setAll(arr, i -> ((int) Math.random() * 100));
		for (Integer a : arr)
			System.out.print(a + " ");
		
		System.out.println();
		
		printCalc(100, v -> v + 1);
		printCalc(101, v -> v * 2);
	}

	public static void printCalc(int n, Calculator cal) {
		System.out.println("printCal ->" + cal.plusOne(n));
	}

}
