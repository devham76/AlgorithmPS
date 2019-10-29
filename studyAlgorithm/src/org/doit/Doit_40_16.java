package org.doit;
import java.util.Scanner;


public class Doit_40_16 {

	static void spira(int n) {
		int now = 1; // 현재 층
		
		for (now=1; now<=n; now++) {
			String re = "";
			for(int i=0; i<n-now; i++) {
				re += " ";
			}
			for(int j=0; j < (now-1)*2+1 ; j++) {
				re += "*";
			}
			System.out.println(re);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("단 입력 : ");
		int floor = sc.nextInt();
		
		spira(floor);
	}
}
