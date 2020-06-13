package org.codingTest;

import java.io.*;
import java.util.*;

public class s2020_1 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();


		HashSet<Integer> hs = new HashSet<>();
		List<Integer> list = new LinkedList<>();
		int answer = 0;
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if (!hs.contains(num)) {
				hs.add(num);
			} else {
				list.add(num);
			}
		}
		answer = hs.size() - 1;
		while (list.size() > 0) {
			hs.clear();
			int i = 0;
			while (i < list.size()) {
				if (!hs.contains(list.get(i))) {
					hs.add(list.get(i));
					list.remove(i);
				}else {
					i++;
				}
			}
			answer += hs.size() - 1;
		}
		System.out.println(answer);
	}
}
