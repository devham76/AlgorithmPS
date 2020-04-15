package org.programmers;

public class Level2_12973 {

	public static void main(String[] args) {
		String s = "baaaaa";
		solution(s);
	}

	public static int solution(String s) {
		int answer = 0;
		if (s.length() % 2 == 1) {
			answer = 0;
		} else {
			StringBuilder str = new StringBuilder(s);
			StringBuilder newstr;
			boolean is_possible = false;
			while (str.length() > 0) {
				is_possible = false;
				newstr = new StringBuilder();
				int idx = 0;
				while (idx < str.length()) {

					if (idx == str.length() - 1) {
						newstr.append(str.charAt(idx));
						break;
					}

					if (str.charAt(idx) == str.charAt(idx + 1)) {
						idx = idx + 2;
						is_possible = true;
					} else {
						newstr.append(str.charAt(idx));
						idx++;
					}
				}
				if(is_possible == false) {
					str = new StringBuilder();
					break;
				}
				str = new StringBuilder(newstr);
				System.out.println(newstr);
			}

			if(is_possible == true) {
				answer = 1;
			}
		}

		System.out.println(answer);
		return answer;
	}
}
