package org.doit;
import java.util.Scanner;

public class Doit_61_2 {

	static void swap(int[] a, int idx1, int idx2) {
		int box = a[idx1]; a[idx1] = a[idx2]; a[idx2] = box;
	}
	static void swapprint(int[] a, int idx1, int idx2) {
		
		for(int i=0; i<a.length; i++)
			System.out.print(a[i] + " ");
		
		int box = a[idx1]; a[idx1] = a[idx2]; a[idx2] = box;
		System.out.println("\na[" + idx1 + "]과(와) a[" + idx2 + "]를 교환합니다.");
	}
	static void reverse(int[] a) {
		for (int i=0; i<a.length/2; i++) {
			//swap(a, i, a.length-i-1);
			swapprint(a, i, a.length-i-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		
		System.out.print("how long ? : ");
		int num = std.nextInt();
		
		int[] x = new int[num];
		
		for (int i=0; i<num; i++) {
			System.out.println("x[" + i + "] = ");
			x[i] = std.nextInt();
		}
		
		reverse(x);
		/*
		for(int i=0; i<x.length; i++)
			System.out.println(x[i]);
		*/
	}
}
