package org.programmers;

import java.util.*;

public class kakao_2019_candidate {

	static Comparator<Integer> comp = new Comparator<Integer>() {
		// 각각의 1로 된 비트를 센다
		int countBits(int n) {
			int ret = 0;
			while (n != 0) {
				if( (n & 1) != 0) ++ret; 
				n = n >> 1; // 하나씩 없앤다.
			}
			return ret;
		}
		// 1의 비트가 작은 순서대로 정렬
		public int compare (Integer a, Integer b) {
			int x = countBits(a), y = countBits(b);
			if (x > y)
				return 1;
			else if (x < y)
				return-1;
			else
				return 0;
		}
	}
	
	public static void main(String[] args) {
		for(int i=1; i< 1 << 4; i++) {
			System.out.println();
		}
		System.out.println( 1 << 4);

	}
	//비트형으로 표현된 부분집합
	static boolean check(String[][] relation, int rowsize, int colsize, int subset) {
		// 두개씩 쌍을 짓는다. (ab,ac,ad , bc,bd, cd)
		for (int a = 0; a < rowsize-1; ++a) {
			for (int b = a+1; b < rowsize; ++b) {
				boolean isSame = true;
				// k는 속성, subset에 해당하는 속성만 비교
				for (int k = 0; k < colsize; ++k) {
					// k번째 비트를 켠다 , subset과 1 <<k가 1일때 1을반환
					if ((subset & 1 << k) == 0) continue;

					if(relation[a][k].equals(relation[b][k]) == false) {
						isSame = false;
						break;
					}
				}
				// 구분이 안된다. 유일성 x
				if(isSame == true) return false;
			}
		}

		return true;
	}

	public static int solution(String[][] relation) {
		int answer = 0;
		int rowsize = relation.length;
		int colsize = relation[0].length;
		List<Integer> candidates = new LinkedList<Integer>();

		// 1을 원소의 개수만큼 왼쪽으로 시프트한다.
		// 모든 부분집합을 비트형으로 표현
		for(int i=1; i< 1 << colsize; i++) {
			System.out.println(i);
			// 유일성 확인
			if(check(relation, rowsize, colsize, i) == true)
				candidates.add(i);
		}
		
		// 속성의 순서가 적은순으로 정렬
		Collections.sort(candidates, comp);
		Comparator<Integer> comp = new Comparator<Integer>() {
			// 각각의 1로 된 비트를 센다
			int countBits(int n) {
				int ret = 0;
				while (n != 0) {
					if( (n & 1) != 0) ++ret; 
					n = n >> 1; // 하나씩 없앤다.
				}
				return ret;
			}
			// 1의 비트가 작은 순서대로 정렬
			public int compare (Integer a, Integer b) {
				int x = countBits(a), y = countBits(b);
				if (x > y)
					return 1;
				else if (x < y)
					return-1;
				else
					return 0;
			}
		}
		
		while (candidates.size() != 0) {
			int n = candidates.remove(0);
			++ answer;
			// n 을 포함한 모든걸 삭제한다
			for( Iterator<Integer> it = candidates.iterator(); it.hasNext(); ) {
				int c = it.next();
				// 참이라면 c는 n의 모든 속성을 가지고 있다
				if( (n & c) == n )
					it.remove();
			}
		}
		
		return answer;
		
	}
	
}
