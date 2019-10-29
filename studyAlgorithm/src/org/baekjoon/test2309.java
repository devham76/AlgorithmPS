package org.baekjoon;

import java.util.*;

public class test2309 {
	
	static int is_finish = 0;
	public static void main(String[] args) {
		// Ǯ�� : 9�� �߿� 7���� �̾� 100�� �Ǵ� ������ ã��
		int[] arr = {20, 5, 26, 18, 10, 14, 25, 8, 13};
		
		/*Scanner std = new Scanner(System.in);
		int[] arr = new int[9];
		for (int i=0; i<9; i++ )
			arr[i] = std.nextInt();
		*/
		// 1. �����ķ� ����
		sort(arr, 0, arr.length-1);
		
		// 2. ���հ˻�
		boolean visited[] = new boolean[9];
		combination(arr, visited, 0, 9, 7);
		
	}
	
	//-- ����, start�� �������� n���߿� r���� �̴� ���� ����
	static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		// r���� ��� �̾Ҵٸ� �׵��� ���� 100�� �Ǵ��� �˻�.
		if(is_finish != 1 ) {
		if(r == 0) {
			check(arr, visited, n);
		}
		else {
			for( int i=start; i < n; i++) {
				visited[i] = true;
				combination(arr, visited, i+1, n, r-1);
				visited[i] = false;
			}
		}
		}
	}
	//-- �׵��� ���� 100�� �Ǵ��� �˻�
	static void check(int[] arr, boolean[] visited, int n) {
		int sum = 0;
		 Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i<n ; i++) {
			if( visited[i] == true) {
				sum += arr[i];
				q.add(arr[i]);
			}
		}
		
		
		// ���� 100�̸� ���� ���
		if(sum == 100) {
			while(!q.isEmpty())
				System.out.println(q.poll());
			
			is_finish = 1;
		}	
		
	}
	//-- ������
	static void sort(int[] arr, int left, int right) {
		int pl = left, pr = right;
		int pivot = arr[ (pl+pr) / 2];
		do {
			while(arr[pl] < pivot) pl++;
			while(arr[pr] > pivot) pr--;
			if(pl <= pr)
				swap(arr, pl++, pr--);
		}while (pl <= pr);
		
		if(left < pr)  sort(arr, left, pr);
		if(pl < right) sort(arr, pl, right);
	}
	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1]; a[idx1] = a[idx2]; a[idx2] = tmp;
	}
}
