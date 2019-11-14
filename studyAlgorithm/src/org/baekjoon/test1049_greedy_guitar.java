package org.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class test1049_greedy_guitar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M =sc.nextInt();
		int Min = Integer.MAX_VALUE;

		int[] unit = new int[M];
		int[] pack = new int[M];
		for(int i=0; i<M; i++){
			pack[i] = sc.nextInt();
			unit[i] = sc.nextInt();
		}
		Arrays.sort(unit);
		Arrays.sort(pack);

		//°¡Àå ½Ñ 6°³Â¥¸® ÆÑ ±¸¸Å vs °¡Àå ½Ñ ³¹°³ ±¸¸Å vs (°¡Àå½Ñ 6°³Â¥¸® ÆÑ + ³¹°³)
		Min = Math.min(((N/6)+1)*pack[0], N*unit[0]);    
		Min = Math.min(Min, ((N/6))*pack[0] + (N%6)*unit[0]);

		System.out.println(Min);
	}

}
