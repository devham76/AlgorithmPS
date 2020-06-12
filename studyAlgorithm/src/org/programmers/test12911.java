package org.programmers;

public class test12911 {

	public static void main(String[] args) {
		solution(78);
	}

	public static int solution(int n) {
		int answer = 0;
		String str = Integer.toBinaryString(n);
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1')
				count++;
		}

		answer = n + 1;
		while (true) {
			String str2 = Integer.toBinaryString(answer);
			int count2 = 0;
			for (int i = 0; i < str2.length(); i++) {
				if (str2.charAt(i) == '1')
					count2++;
			}
			if (count2 == count)
				break;
			
			answer++;
		}
		return answer;
	}
}
