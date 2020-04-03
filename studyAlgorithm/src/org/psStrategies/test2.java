package org.psStrategies;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class test2 {
	static int stop;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[3];
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		stop = sc.nextInt();
		Arrays.sort(arr);
		visited = new boolean[3];
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < 3; i++) {
			list.add(arr[i]);
			visited[i] = true;
			makenum(i + 1, list);
			list.remove(list.size()-1);
			visited[i] = false;
		}
	}

	private static void makenum(int idx, List<Integer> list) {
		//System.out.println("idx="+idx+" size="+list.size()+" stop="+stop);
		if (list.size() == 3) {
			
			if (stop == 1) {
				//System.out.println("answer!!");
				for (Integer l : list)
					System.out.print(l);
				
			}
			stop--;
			
			return;
		}

		for(int i=0; i<3; i++) {
			if(visited[i] == false) {
				list.add(arr[i]);
				visited[i] = true;
				makenum(i + 1, list);
				list.remove(list.size()-1);
				visited[i] = false;
			}
		}
	}

}
