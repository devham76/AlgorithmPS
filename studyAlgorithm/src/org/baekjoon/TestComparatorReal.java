package org.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class TestComparatorReal {
	public static void main(String[] args) {
	
		ArrayList<trip> tripList = new ArrayList<trip>();
		
		trip t1 = new trip("대한민국", 4);
		trip t2 = new trip("가나", 7);
		trip t3 = new trip("이란", 5);
		
		tripList.add(t1);
		tripList.add(t2);
		tripList.add(t3);
		
		Collections.sort(tripList, new Comparator<trip>() {
			@Override
			public int compare(trip arg0, trip arg1) {
				return arg0.getCountry().compareTo(arg1.getCountry());
			}
		});
		
		for (trip e:tripList)
			System.out.print(e.getCountry()+ " ");
		
		
	}
}
