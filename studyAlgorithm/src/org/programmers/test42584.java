package org.programmers;

public class test42584 {

	public static void main(String[] args) {
		int[] p = { 5, 4, 3, 2, 2 };
		solution(p);

	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			int num = 0;
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[i] <= prices[j])
					num++;
				else {
					num = 1;
					break;
				}
			}
			answer[i] = num;
			System.out.println(num);
		}

		return answer;
	}
}
