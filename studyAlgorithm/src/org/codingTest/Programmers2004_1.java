package org.codingTest;

public class Programmers2004_1 {

	public static void main(String[] args) {
		String p = "82195";
		String s = "64723";
		solution(p, s);

	}

	public static int solution(String p, String s) {
		int answer = 0;
		for (int i = 0; i < p.length(); i++) {
			int org = Integer.parseInt(p.charAt(i) + "");
			int ans = Integer.parseInt(s.charAt(i) + "");

			int diff = 0;

			diff = Math.abs(org - ans);

			System.out.println("ans ="+ans+" org="+org);
			if (diff > 5) {
				diff = 1;
				
				
				if (ans < 5) {
					ans += 10;
					while (true) {
						if((--ans) % 10 == org) break;
						diff++;
					}
					
				} else if (ans > 5) {
					System.out.println("--> "+(ans + 1) % 10 );
					while (true) {
						if((++ans) % 10 == org) break;
						diff++;
					}
				}
			}

			System.out.println(diff);
			answer += diff;
		}
		System.out.println(answer);
		return answer;
	}
}
