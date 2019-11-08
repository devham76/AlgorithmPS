package org.study;

import java.util.ArrayList;
import java.util.Collections;

class trip implements Comparable<trip>{
	String country;
	int month;
		
	public trip(String country, int month) {
		this.country = country;
		this.month   = month;
	}

	public String getCountry() {
		return this.country;
	}
	
	@Override
	public int compareTo(trip t) {
		// ���� �̸��� �������� ��
		return country.compareTo(t.getCountry());
	}
}
public class TestComparator {
	public static void main(String[] args) {
	
		ArrayList<trip> tripList = new ArrayList<trip>();
		
		trip t1 = new trip("���ѹα�", 4);
		trip t2 = new trip("�߽���", 7);
		trip t3 = new trip("�̶�", 5);
		
		tripList.add(t1);
		tripList.add(t2);
		tripList.add(t3);
		
		Collections.sort(tripList);
		
		for (trip e:tripList)
			System.out.print(e.getCountry()+ " ");
		
		
	}
}
