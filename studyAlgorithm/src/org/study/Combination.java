package org.study;

import java.util.*;
public class Combination {
/*
 * ���� : n �� �߿��� r �� ����
 * ���� : https://bcp0109.tistory.com/15?category=848939
 * */
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		boolean[] visited = new boolean[arr.length];
		
		/*
		 * ���� �������� �ε���  0 
		 * arr.length�� �߿��� 
		 * i=1 ; 1�� ���� arr.length�� ���� ���� ���̴�.
		 */
		for(int i=1; i<arr.length; i++)
			combination(arr, visited, 0, arr.length, i);		
	
	}
	
	/*
	 * ��Ʈ��ŷ ���
	 * combination(���� �迭, �������� Ȯ���ϴ� �迭, ���� ������, n����, r�� ����)
	 * */
	static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		
		// �̱�� �� ���� ��ŭ �� �̾Ѵٸ� print
		if(r==0) {
			print(arr, visited, n);
			return;
		}
		else {
			// ������ �ε��� ���� �迭�� ������ ������
			for(int i=start; i<n; i++) {
				// �湮 �� true ǥ��.
				visited[i] = true;						
				
				// i+1; �湮�� �ε��� �� ���� ���� ������ / n���߿� �� ���� �湮 �Ѱ� �����Ƿ� r-1���� �̴´�
				combination(arr, visited, i+1, n, r-1);	
				
				// �湮 �Ϸ� �� false ǥ��.
				visited[i] = false; 					
			}
		}
	}
	
	// �迭 ���
	static void print(int[] arr, boolean[] visited, int n) {
		for(int i=0; i<n; i++) {
			if(visited[i] == true)
				System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}
	
}
