package org.programmers;

public class test12904 {

	public static void main(String[] args) {
		solution("abcdcba");

	}

	public static int solution(String s) {
		int answer = 1;

		for (int i = 0; i < s.length()-1; i++) {
			if (i > s.length() / 2 && answer >= s.length() / 2)
				break;
			if(i < s.length()/2 && answer == s.length()- ((i-1)*2))
				break;
			
			System.out.println("->"+i);
			
			for (int j = i + 1; j < s.length(); j++) {

				if (s.charAt(i) == s.charAt(j)) {
					int start = i + 1, end = j - 1;

					boolean is_ok = true;
					while (start < end) {
						if (s.charAt(start++) != s.charAt(end--)) {
							is_ok = false;
							break;
						}
					}

					if (is_ok == true) {
						int count = j - i + 1;
						answer = Math.max(answer, count);
					}
				}
			}
		}
		System.out.println(answer);
		return answer;
	}
}
