package org.study;

import java.util.*;
/*
 *  ���� : n �� �߿��� r�� ����
 *  �ð����⵵�� O(n!)
 *  ���� ���� : https://www.acmicpc.net/problem/10974
 */

public class Permutation {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int[] output = new int[arr.length];
		boolean[] visited = new boolean[arr.length];
		perm(arr, output, visited, 0, arr.length, 3);
		
	}
	
	// ������ ��Ű�鼭 n���� r���� �̴� ���
	// ��� ���� : perm(arr, output, visited, 0, n, 3);
	static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		
		//- ���� ���̴� ���� �����̴�
		//- ��, ���� ������ ���� ������ ���ٸ� ����.
		if(depth == r) {
			print(output,r);
			return;
		}
		
		// 1. ��� ���Ҹ� ��ȸ�Ѵ�.
		for (int i=0; i<n; i++) {
			// 2. �湮���� ���� ���Ҹ� ã�´�
			if(visited[i] != true) {
				visited[i] 		= true;		// �湮ǥ�ø� �Ѵ�
				output[depth] 	= arr[i];	// ����� �迭�� �ش���� ��ġ�� �湮���� ���� ���� �� ����
				perm(arr, output, visited, depth+1, n, r);
				visited[i] 		= false;
			}
		}
	}
	
	// �迭 ���
	static void print(int[] arr, int r) {
        for(int i=0; i<r; i++)
            System.out.print(arr[i] + " ");
		System.out.println();
	}
}
