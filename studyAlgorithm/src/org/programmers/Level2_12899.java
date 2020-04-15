package org.programmers;

public final class Level2_12899 {

	public static void main(String[] args) {

		solution(16);
	}
	/*
	 * 다른분 풀이
	 * 굳이 배열을 만들필요없음 !!
	String answer = "";
        int rmd;

        while(n>0){
            rmd = n%3;
            n = n/3;

            if(rmd == 0){
                n -= 1;
                rmd = 4;
            }

            answer = rmd + answer;
        }

        return answer;
	 * */

	public static String solution(int n) {
		String answer = "";
		String[] dp = new String[n + 3];
		dp[1] = "1";
		dp[2] = "2";
		dp[3] = "4";

		if (n > 3) {

			int lastNum = (n-1) % 3;
			
			int lastBase = (n-1) / 3;

			int base = 1;
			int now = 4;
			while (now <= lastBase) {
				for (int i = 1; i < 4; i++) {
					dp[now++] = dp[base] + dp[i];
				}
				++base;

			}
			answer = dp[lastBase] + dp[lastNum+1];
		}
		else {
			answer = dp[n];
		}
		System.out.println(answer);
		return answer;
	}

	public static String solution2(int n) {
		String[] dp = new String[n + 3];
		dp[1] = "1";
		dp[2] = "2";
		dp[3] = "4";

		int base = 1;
		int now = 4;
		while (now <= n) {
			for (int i = 1; i < 4; i++) {
				dp[now++] = dp[base] + dp[i];
			}
			++base;

		}
		System.out.println(dp[n]);
		return dp[n];
	}
}
