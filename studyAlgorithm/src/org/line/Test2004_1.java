package org.line;

public class Test2004_1 {

	public static void main(String[] args) {
		String a = "hi";
		String a1 = "lint[hi]";
		String a2 = "if (Count of eggs is 4.) {Buy milk.}";
		String a3 = ">_<";
		String a4 = "if {(Co}unt <>o<f eggs is 4.) {Buy m>ilk.}";
		solution(a4);
	}

	public static int solution(String inputString) {
		int answer = -1;
		boolean is_possible = true;
		int[][] arr = new int[4][3];
		for (int i = 0; i < inputString.length(); i++) {
			char ch = inputString.charAt(i);

			if (ch == '(') {
				arr[0][0]++;
			} else if (ch == ')') {
				// 이미 모든 짝을 이뤘는데 )가 나올수없다.
				if (arr[0][1] >= arr[0][0]) {
					is_possible = false;
					break;
				} else
					arr[0][1]++;
			}

			else if (ch == '{') {
				arr[1][0]++;
			} else if (ch == '}') {
				// 이미 모든 짝을 이뤘는데 )가 나올수없다.
				if (arr[1][1] >= arr[1][0]) {
					is_possible = false;
					break;
				} else
					arr[1][1]++;
			}

			else if (ch == '<') {
				arr[2][0]++;
			} else if (ch == '>') {
				// 이미 모든 짝을 이뤘는데 )가 나올수없다.
				if (arr[2][1] >= arr[2][0]) {
					is_possible = false;
					break;
				} else
					arr[2][1]++;
			}

			else if (ch == '[') {
				arr[3][0]++;
			} else if (ch == ']') {
				// 이미 모든 짝을 이뤘는데 )가 나올수없다.
				if (arr[3][1] >= arr[3][0]) {
					is_possible = false;
					break;
				} else
					arr[3][1]++;
			}

		}

		if (is_possible == true) {
			answer = 0;
			for (int i = 0; i < 4; i++) {
				//System.out.println("괄호종류 i=" + i + " , 왼쪽쌍개수=" + arr[i][0] + " 오른쪽=" + arr[i][1]);
				answer += arr[i][0];
			}
		}
		System.out.println(answer);
		return answer;
	}
}
