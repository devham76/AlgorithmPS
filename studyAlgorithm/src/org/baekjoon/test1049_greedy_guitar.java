package org.baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class test1049_greedy_guitar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M =sc.nextInt();
		
		int[][] arr = new int[M][2];
		for(int i=0; i<M; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		arrySort(arr);
		int min = arr[0][1] * N;
		for(int i=0; i<M; i++) {
			int six = N / 6;
			int remain = N % 6;
			int upSix = remain == 0 ? six : (six+1);
		
			int num1 = arr[i][0] * upSix;
			int num2 = arr[i][0] * six + arr[0][1] * remain;
			
			min = Math.min(min, Math.min(num1, num2));
		
		}
		System.out.println(min);
		
	}

	private static void arrySort(int[][] arr) {

    	Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] arr1, int[] arr2) {
					return ((Comparable) arr1[1]).compareTo(arr2[1]);
			}
		});
    }
}

//Scanner sc = new Scanner(System.in);
//
//int N = sc.nextInt();
//int M =sc.nextInt();
//int Min = Integer.MAX_VALUE;
//
//int[] unit = new int[M];
//int[] pack = new int[M];
//for(int i=0; i<M; i++){
//	pack[i] = sc.nextInt();
//	unit[i] = sc.nextInt();
//}
//Arrays.sort(unit);
//Arrays.sort(pack);
//
////°¡Àå ½Ñ 6°³Â¥¸® ÆÑ ±¸¸Å vs °¡Àå ½Ñ ³¹°³ ±¸¸Å vs (°¡Àå½Ñ 6°³Â¥¸® ÆÑ + ³¹°³)
//Min = Math.min(((N/6)+1)*pack[0], N*unit[0]);    
//Min = Math.min(Min, ((N/6))*pack[0] + (N%6)*unit[0]);
//
//System.out.println(Min);