package org.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class test1339 {

	public static void main(String[] args) {
		Map<Character, Integer> hm = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String str = sc.next();
			int len = str.length();
			int ten = 1;

			// 알파벳의 위치에 따라 값을 설정해준다.
			// ABC 이면 A:1000, B:100, C:1
			for (int idx = len - 1; idx >= 0; idx--) {
				char alphabet = str.charAt(idx);
				if (!hm.containsKey(alphabet)) {
					hm.put(alphabet, ten);
				} else {
					int sum = hm.get(alphabet);
					sum += ten;
					hm.replace(alphabet, sum);
				}
				ten *= 10;
			}
		}
		Iterator it = sortByValue(hm).iterator();
		int sum = 0;
		int number = 9;
		while (it.hasNext()) {
			char alphabet = (char) it.next();
			sum += hm.get(alphabet) * number--;
		}
		System.out.println(sum);
	}

	public static List sortByValue(final Map map) {
		List<Character> list = new ArrayList<>();
		list.addAll(map.keySet());

		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);

				return ((Comparable) v2).compareTo(v1);
			}
		});
		// Collections.reverse(list);
		return list;
	}

}
