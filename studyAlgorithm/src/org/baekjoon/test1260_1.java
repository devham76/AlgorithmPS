package org.baekjoon;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test1260_1 {

	static boolean[] visited;	
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int node = sc.nextInt();	// ��� ����
		int line = sc.nextInt();	// ���� ����
		int start = sc.nextInt();		// ���� ���
		
		// ��� ���� ��ŭ ��������Ʈ�� ������ش�. �ε��� �򰥸��� �����ϱ� ���� +1 ���ش�.
		list = new ArrayList[node+1];	
		// ��������Ʈ �ʱ�ȭ
		for (int i=1; i< node+1; i++)
			list[i] = new ArrayList<Integer>();
			
		// ���� ������ŭ �Է��� ��� �´�.
		for (int i=0; i < line; i++) {
			 int x = sc.nextInt();
			 int y = sc.nextInt();
			 
			 // �ڽ��� ��忡�� �� �� �ִ� ��带 �߰����ش�.
			 list[x].add(y);
			 list[y].add(x);
		}
		
		// ������ ��尡 �ΰ� �̻��϶� ���� ���ں��� �湮 �ϹǷ�, ������������ ���� ���ش�.
		for (int i=1; i<node+1; i++)
			Collections.sort(list[i]);
		
		// ����� �湮 ���θ� ǥ���ϴ� �迭. false�� �ʱ�ȭ ���ش�. �ε��� ȥ�� ������ ���� node+1 ���ش�.
		visited = new boolean[node+1];
		dfs(start);
		System.out.println();
		
		// ��� �湮 ���� ǥ�� �迭 �ʱ�ȭ
		visited = new boolean[node+1];
		bfs(start);
		
		sc.close();
	}
	
	static void bfs(int start) {
		// bfs�� ť�� �ذ�.
		Queue<Integer> qu = new LinkedList<Integer>();
		
		// ù��° ��带 �湮�Ѵ�.
		qu.add(start); 
		visited[start] = true;
		
		// ť�� �ְ�(�湮) ���鼭 , ť�� �������� �ݺ��Ѵ�.
		while (!qu.isEmpty()) {
				// ť���� ��� �Ѱ��� ����.
				int out = qu.poll();
				System.out.print(out+ " ");
				// ���� ����� ���� ��带 �湮
				for (int x : list[out]) {
					// ������带 �湮������ ������ �湮ǥ�� ��, ť�� ����
					if(visited[x] == false) {
						visited[x] = true;
						qu.add(x);
					}
				}
				
			
		}
	}

	static void dfs(int start) {
		
		// �湮������ �Լ� ����
		if (visited[start] == true)
			return;
		
		// �湮ǥ��
		visited[start] = true; 
		System.out.print(start+" ");
		
		// �湮�� ���� ������ ��带 �湮�Ѵ�.
		for (int i : list[start]) {
			// ������带 �湮�������� �湮�Ϸ� ����.
			if (visited[i] == false)
				dfs(i);
		}
	}
	
}
