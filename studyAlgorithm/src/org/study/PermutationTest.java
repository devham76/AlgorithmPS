package org.study;

import java.util.*;
public class PermutationTest {
	public static void main(String[] args) {
	
		//N�� �־����� ��, 1���� N������ ���� �̷���� ������ ���������� ����ϴ� ���α׷��� �ۼ��Ͻÿ�
		Scanner std = new Scanner(System.in);
		int num = std.nextInt();
		
		int arr[] 			= makeArray(num);		// ���� �迭
		int output[] 		= new int[num]; 		// ����� �迭
		boolean visited[] 	= new boolean[num]; 	// �湮�˻� �迭
		perm(arr, output, visited, num, 0, num);	// arr�迭���� num���� ������ �̴´�.
	}
	
	//---------------------------
	//-- static�� ���� �Լ����� ȣ���ϹǷ� �ش� �Լ��� static�̿��� �Ѵ�.
	//---------------------------
	static int[] makeArray(int num) {
		int[] array = new int[num];
		for (int i=0; i<num; i++) {
			array[i] = i+1;
		}
		return array;
	}
	
	//---------------------------
	/*
	 * num   ; ���� �迭 ��ü����
	 * depth ; ���� ����� ����
	 * pick  ; ���� ����  
	 * */
	//---------------------------
	static void perm(int[] arr, int[] output, boolean[] visited, int num, int depth, int pick) {
	
		// ����� ���� , �� output�� ���� ������ ���������� ������ print�Ѵ�.
		if (depth == pick) {
			print(output, pick);
		}
		
		for (int i=0; i<num; i++) {
			// �ش� ���ڸ� �湮���� �ʾҴٸ�
			if(visited[i] == false) {
				visited[i] 		= true;			// �湮ǥ��
				output[depth]	= arr[i];		// ����� �迭�� �ش� ���� �ڸ��� �湮���� �ʴ� ���Ҹ� ����
				// ���� �Ŀ� �Ѵܰ� ���� ���� �̵� �Ͽ� output�� ���߰�
				perm(arr, output, visited, num, depth+1, pick);
				visited[i] 		= false;		// �Ѵܰ� ���� ��� ������ ������ �θ���� ������ arr[]�� ���� ���Ҹ� �ش� �ڸ��� ������ �ִ�.
			}
		}
	}
	
	//---------------------------
	//-- �迭 ���� ����Ʈ �Լ�
	//---------------------------
	static void print(int[] output, int pick) {
		for (int i=0; i<pick; i++) {
			System.out.print(output[i]+" ");
		}
		System.out.println("");
	}
	
}

