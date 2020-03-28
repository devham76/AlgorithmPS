package org.baekjoon;

import java.util.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class test12865 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		List<product> plist = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			plist.add(new product(sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(plist);
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			product p = plist.get(i);
			int weight = p.weight;
			for(int j=i+1; j<n; j++) {
				
			}
			
		}
	}

}

class product implements Comparable<product> {

	int weight;
	int value;

	product(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
	
	@Override
	public int compareTo(product arg0) {

		return this.weight - arg0.weight;
	}
}