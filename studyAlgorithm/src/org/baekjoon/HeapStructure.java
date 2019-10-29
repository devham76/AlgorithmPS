package org.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HeapStructure {

	public static class Heap {
		List<Integer> heap;
		
		public Heap() {
			heap = new ArrayList<Integer>();
			heap.add(0);
		}
	
	
		
		public void insert(int n) {
			heap.add(n);
			int p = heap.size()-1;
			// ��尡 �Ѱ� or  �ڽ�>�θ��϶�
			while (p < 1 || heap.get(p/2) > heap.get(p)) {
				// �θ� ��� <-> �ڽ� ���
				int tmp = heap.get(p/2);	
				heap.set(p/2, heap.get(p));
				heap.set(p, tmp);
				p = p/2;
			}
		}
		
		public int delte() {
			if (heap.size() <=1)
				return 0; 
			int deleteItem = heap.get(1); // ������ ��� = ��Ʈ���
			
			// ��Ʈ��� <- ������ ���
			heap.set(1, heap.get(heap.size() -1));
			heap.remove(heap.size()-1);
			
			int pos = 1;
			while ( (pos *2) < heap.size()) {
				int min 	= heap.get(pos*2);	// ���� �ڽ�
				int minPos	= pos * 2;			// ���� �ڽ� �ε���
				
				if((  (pos*2+1) < heap.size()) 
					&& min > heap.get(pos*2+1)) {
					min 	= heap.get(pos*2 +1);
					minPos 	= pos*2	+	1;
				}
				
				//-- ���� ��尡 ���� �۴ٸ� ��
				if (heap.get(pos) < min)
					break;
				
				// �θ��� �ڽĳ�� ��ȯ
				int tmp = heap.get(pos);
				heap.set(pos, heap.get(minPos));
				heap.set(minPos, tmp);
				pos = minPos;
			}
			return deleteItem;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] name = new String[] {"������","����","�ں���"};
		Arrays.sort(name);
		/*for (String e : name)
		System.out.print(e+" ");
		*/
		ArrayList<String> contury = new ArrayList<String>();
		contury.add("���ѹα�");
		contury.add("��Ű");
		contury.add("�׸���");
		
		// Arrays.sort(contury); ->�����߻�
		Collections.sort(contury);
		
		for(String e : contury)
			System.out.print(e+ " ");
	}

}
