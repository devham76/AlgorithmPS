package org.programmers;

public class Level3_12979 {

	public static void main(String[] args) {
		int[] s = { 9 };
		solution(16, s, 2);
	}

	public static int solution(int n, int[] stations, int w) {

		int ans = 0;
		int idx = 0;
		int location = 1;

		while (location <= n) {
			if (idx < stations.length && location >= stations[idx] - w) {
				location = stations[idx] + w + 1;
				idx++;
			} else {
				location += 2 * w + 1;
				ans++;
			}
		}
		return ans;
	}
}
