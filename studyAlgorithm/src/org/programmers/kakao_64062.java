package org.programmers;

public class kakao_64062 {

	public static void main(String[] args) {
		int[] s1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 
				21, 22, 23, 24 };
		int[] s = {10,9,8,7,6,5,4,3,2,1};
		
		solution(s, 3);

	}

	public static int solution(int[] stones, int k) {
		int min = 300000000;
		int maxIdx = 0;
		int start=0;
		for (; start <= stones.length - k; start++) {
			int max = 0;
			System.out.println("start="+start);
			for (int i = start; i < start + k; i++) {
				if (max <= stones[i]) {
					max = stones[i];
					maxIdx = i;
				}
			}
			start = maxIdx+k-1;
			System.out.println("maxIdx="+maxIdx+" max="+max);
			if(min > max)
				min = max;

		}

		System.out.println(min);
		return min;
	}
}
