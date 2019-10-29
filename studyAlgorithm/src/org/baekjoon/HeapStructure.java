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
			// 노드가 한개 or  자식>부모일때
			while (p < 1 || heap.get(p/2) > heap.get(p)) {
				// 부모 노드 <-> 자식 노드
				int tmp = heap.get(p/2);	
				heap.set(p/2, heap.get(p));
				heap.set(p, tmp);
				p = p/2;
			}
		}
		
		public int delte() {
			if (heap.size() <=1)
				return 0; 
			int deleteItem = heap.get(1); // 삭제할 노드 = 루트노드
			
			// 루트노드 <- 마지막 노드
			heap.set(1, heap.get(heap.size() -1));
			heap.remove(heap.size()-1);
			
			int pos = 1;
			while ( (pos *2) < heap.size()) {
				int min 	= heap.get(pos*2);	// 왼쪽 자식
				int minPos	= pos * 2;			// 왼쪽 자식 인덱스
				
				if((  (pos*2+1) < heap.size()) 
					&& min > heap.get(pos*2+1)) {
					min 	= heap.get(pos*2 +1);
					minPos 	= pos*2	+	1;
				}
				
				//-- 현재 노드가 가장 작다면 끝
				if (heap.get(pos) < min)
					break;
				
				// 부모노드 자식노드 교환
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
		
		String[] name = new String[] {"이혜미","김우빈","박보검"};
		Arrays.sort(name);
		/*for (String e : name)
		System.out.print(e+" ");
		*/
		ArrayList<String> contury = new ArrayList<String>();
		contury.add("대한민국");
		contury.add("터키");
		contury.add("그리스");
		
		// Arrays.sort(contury); ->오류발생
		Collections.sort(contury);
		
		for(String e : contury)
			System.out.print(e+ " ");
	}

}
