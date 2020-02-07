package org.tryAgain;
// ����
// https://www.acmicpc.net/problem/1700

import java.util.*;

public class test1700_greedy_multiTap {

	public static void main(String[] args) {
		int answer=0;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] machine = new int[K];
		for(int i=0; i<K; i++) {
			machine[i] = sc.nextInt();
		}

		boolean[] check = new boolean[3];
		List<Integer> tap = new ArrayList<>();
		tap.add(machine[0]);
		for (int i=1; i<machine.length; i++) {
			

			
			boolean is_exist = false;
			// �ǿ� �̹� �����ִ��� Ȯ��
			for(int j=0; j<tap.size();j++) {
				if(tap.get(j) == machine[i]) {
					is_exist = true;
					break;
				}
			}
			
			// �̹� ���������� ��
			if(is_exist == true)
				continue;
			
			// �̹� �����ִ°� �ƴϰ�, �ǿ� ���ڸ��� �ִٸ� �ȴ´�
			if(tap.size() < N) {
				tap.add(machine[i]);
				continue;
			}
			
			int maxSubIdx=0 ,maxTapIdx=0;
			// �̹� �����ִ°� �ƴϰ�, �ǿ� ���ڸ��� ���ٸ� 
			// ������� ����� ���� �������� ���� �ɰ��� ����
			for(int tapIdx=0; tapIdx<N; tapIdx++) {
				// ���ʿ��� �����Ѵٸ� ������ ���Ѵ밪�̴�
				int maxIdx = Integer.MAX_VALUE;
				
				for(int subIdx = i+1; subIdx<machine.length; subIdx++) {
					// ���ʿ��� ���� ������
					if(tap.get(tapIdx) == machine[subIdx]) {
						maxIdx = subIdx;
						break;
					}
					
				}
				// ���� �������� ���� ���� ã�´�
				if(maxSubIdx < maxIdx) {
					maxSubIdx = maxIdx;
					maxTapIdx = tapIdx;
				}
			}
			tap.set(maxTapIdx, machine[i]);
			answer++;
		}
		System.out.println(answer);
	}

}
