package org.programmers;

import java.util.Arrays;

public class Level3_43237 {

	public static void main(String[] args) {
		int[] b = { 9, 8, 5, 6, 7 };
		solution(b, 5);
		int[] b2 = { 120, 110, 140, 150 };
		// solution(b2, 485);
	}

	public static int solution(int[] budgets, int M) {
		int answer = 0;
		int left = 0;
		int right = 0;

		// right : 예산들중 가장 큰 값
		for (int budget : budgets) {
			if (budget > right) {
				right = budget;
				// answer의 최대 값은 budgets의 요소의 최대값
			}
		}

		int middle = 0;

		// 최소금액이 최대금액 보다 작거나 클때까지 반복.
		while (left <= right) {
			long sum = 0;

			// 최소금액과 최대금액의 평균값.
			middle = (left + right) / 2;
			System.out.println("left=" + left + " right" + right + " middle=" + middle);

			for (int budget : budgets) {

				if (budget >= middle) {
					sum += middle;
				} else {
					sum += budget;
				}
			}

			// 예상 상한액을 적용했을때, 전체금액을 초과한다면 예상 상한액을 줄인다.
			if (sum > M) {
				right = middle - 1;
			} else {
				// middle을 적용하면 전체 금액을 감당할 수 있으므로 answer가 될수있다.
				answer = middle;
				// middle보다 더 큰 값이 가능한지 알아보기 위해 left = middle+1을 해준다.
				left = middle + 1;
			}
		}
		System.out.println(answer);
		return answer;
	}
}
