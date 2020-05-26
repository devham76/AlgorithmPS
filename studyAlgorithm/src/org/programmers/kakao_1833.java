package org.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class kakao_1833 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int n, int[][] data) {
		int answer = 0;
		List<dot> list = new ArrayList<>();
		for (int i = 0; i < data.length; i++) {
			list.add(new dot(data[i][0], data[i][1]));
		}
		Collections.sort(list);
		for (int i = 0; i < data.length - 1; i++) {
			dot d1 = list.get(i);
			for (int j = i + 1; j < data.length; j++) {
				dot d2 = list.get(j);

				// 일직선상에 있을때
				if (d1.x == d2.x || d1.y == d2.y)
					continue;

				boolean is_ok = true;
				for (int k = i + 1; k < j; k++) {
					dot d3 = list.get(k);
					if (d2.x == d3.x) 
						break;

					if (d1.x == d3.x || d1.y == d3.y || d2.y == d3.y)
						continue;

					int big = d1.y, small = d2.y;
					if (d1.y < d2.y) {
						big = d2.y;
						small = d1.y;
					}

					if (big > d3.y && d3.y > small) {
						is_ok = false;
						break;
					}

				}
				if(is_ok == true)
					answer ++;
			}
		}
System.out.println(answer);
		return answer;
	}

	class dot implements Comparable<dot> {
		int x;
		int y;

		dot(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(dot d) {
			if (this.x == d.x)
				return Integer.compare(y, d.y);
			return Integer.compare(x, d.x);
		}

	}
}
