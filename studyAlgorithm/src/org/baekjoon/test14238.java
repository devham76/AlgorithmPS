package org.baekjoon;

import java.util.Scanner;

public class test14238 {
	static int length;
	static boolean[][][][] dp;
	static char S[];
	static final int NOT_EXIST = -1;
	static int A = 0, B = 0, C = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		length = str.length();
		// dp[x][c][b][a] : x까지의 a,b,c를 사용해서 만들수있는지 확인한다.
		dp = new boolean[length][length][length][length];
		S = new char[length];

		for (int i = 0; i < length; i++) {
			switch (str.charAt(i)) {
			case 'A':
				A++;
				break;
			case 'B':
				B++;
				break;
			case 'C':
				C++;
				break;

			}
		}

		if (solve(0, 0, 0, 0)) {
			System.out.println(new String(S));
		} else {
			System.out.println(NOT_EXIST);
		}
	}

	private static boolean solve(int x, int c, int b, int a) {
		//System.out.println("x=" + x + " c=" + c + " b=" + b + " a=" + a + " string=" + new String(S));

		if (x == length) {
			return true;
		}

		// x자리 까지 a,b,c 를 사용해서 가능한지 확인했었기 때문에 또 확인 하지 않는다.
		if (dp[x][c][b][a] == true)
			return false;

		// x위치에서 A를 a개 B를 b개 C를c개 사용해서 문자열 만들수있는지 확인할것이므로 true
		dp[x][c][b][a] = true;
		
		// X위치에 C,B,A가 들어갈수있는지 확인한다.
		// 남아있는 C개수가있는지 확인 후 사용.
		if (C > c) {
			// 이전, 이이전에 사용했는지 확인후 아니라면 시도해본다.
			if ((x >= 2 && (S[x - 1] != 'C' && S[x - 2] != 'C')) || 
					(x == 1 && S[x - 1] != 'C') || x == 0) {
				S[x] = 'C';
				if (solve(x + 1, c + 1, b, a))
					return true;
			}
			else	// 규칙에 의해 검사 못했으므로  다시 false해준다.
				dp[x][c][b][a] = false;

		}

		// 남아있는 B개수가있는지 확인 후 사용.
		if (B > b) {
			// 이전에 사용했는지 확인하고 아니라면 시도한다.
			if ((x >= 1 && S[x - 1] != 'B') || x == 0) {
				S[x] = 'B';
				if (solve(x + 1, c, b + 1, a))
					return true;
			}else
				dp[x][c][b][a] = false;
		}

		// 남아있는 A개수가있는지 확인 후 사용.
		if (A > a) {
			// 아무때나 시도 가능.
			S[x] = 'A';
			if (solve(x + 1, c, b, a + 1))
				return true;
		}

		return false;
	}

}
