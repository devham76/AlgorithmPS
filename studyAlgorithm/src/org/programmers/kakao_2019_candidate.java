package org.programmers;

import java.util.*;

public class kakao_2019_candidate {

	static Comparator<Integer> comp = new Comparator<Integer>() {
		// ������ 1�� �� ��Ʈ�� ����
		int countBits(int n) {
			int ret = 0;
			while (n != 0) {
				if( (n & 1) != 0) ++ret; 
				n = n >> 1; // �ϳ��� ���ش�.
			}
			return ret;
		}
		// 1�� ��Ʈ�� ���� ������� ����
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
	//��Ʈ������ ǥ���� �κ�����
	static boolean check(String[][] relation, int rowsize, int colsize, int subset) {
		// �ΰ��� ���� ���´�. (ab,ac,ad , bc,bd, cd)
		for (int a = 0; a < rowsize-1; ++a) {
			for (int b = a+1; b < rowsize; ++b) {
				boolean isSame = true;
				// k�� �Ӽ�, subset�� �ش��ϴ� �Ӽ��� ��
				for (int k = 0; k < colsize; ++k) {
					// k��° ��Ʈ�� �Ҵ� , subset�� 1 <<k�� 1�϶� 1����ȯ
					if ((subset & 1 << k) == 0) continue;

					if(relation[a][k].equals(relation[b][k]) == false) {
						isSame = false;
						break;
					}
				}
				// ������ �ȵȴ�. ���ϼ� x
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

		// 1�� ������ ������ŭ �������� ����Ʈ�Ѵ�.
		// ��� �κ������� ��Ʈ������ ǥ��
		for(int i=1; i< 1 << colsize; i++) {
			System.out.println(i);
			// ���ϼ� Ȯ��
			if(check(relation, rowsize, colsize, i) == true)
				candidates.add(i);
		}
		
		// �Ӽ��� ������ ���������� ����
		Collections.sort(candidates, comp);
		Comparator<Integer> comp = new Comparator<Integer>() {
			// ������ 1�� �� ��Ʈ�� ����
			int countBits(int n) {
				int ret = 0;
				while (n != 0) {
					if( (n & 1) != 0) ++ret; 
					n = n >> 1; // �ϳ��� ���ش�.
				}
				return ret;
			}
			// 1�� ��Ʈ�� ���� ������� ����
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
			// n �� ������ ���� �����Ѵ�
			for( Iterator<Integer> it = candidates.iterator(); it.hasNext(); ) {
				int c = it.next();
				// ���̶�� c�� n�� ��� �Ӽ��� ������ �ִ�
				if( (n & c) == n )
					it.remove();
			}
		}
		
		return answer;
		
	}
	
}
