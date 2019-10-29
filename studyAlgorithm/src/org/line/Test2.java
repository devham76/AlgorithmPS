package org.line;


import java.util.*;
import java.util.stream.Collectors;
/*
 *  순열 : n 개 중에서 r개 선택
 *  시간복잡도는 O(n!)
 *  연습 문제 : https://www.acmicpc.net/problem/10974
 */
import java.util.stream.Stream;

public class Test2 {

	public static List<Integer> quickSort(List<Integer> list) {
	    if (list.size() <= 1) return list;
	    int pivot = list.get(list.size() / 2);

	    List<Integer> lesserArr = new LinkedList<>();
	    List<Integer> equalArr = new LinkedList<>();
	    List<Integer> greaterArr = new LinkedList<>();

	    for (int num : list) {
	        if (num < pivot) lesserArr.add(num);
	        else if (num > pivot) greaterArr.add(num);
	        else equalArr.add(num);
	    }

	    return Stream.of(quickSort(lesserArr), equalArr, quickSort(greaterArr))
	            .flatMap(Collection::stream)
	            .collect(Collectors.toList());
	}

	static int location;
	static int now = 0;
	public static void main(String[] args) {
		List<Integer> insertArr = new LinkedList<Integer>();
		
        Scanner sc = new Scanner(System.in);
        String insertNum = sc.nextLine();
        String[] insertNums = insertNum.split(" ");

        for(int i=0; i< insertNums.length; i++)
        	insertArr.add(Integer.parseInt(insertNums[i]));

		insertArr = quickSort(insertArr);
		int[] arr = new int[insertArr.size()];
		int[] output = new int[insertArr.size()];
		boolean[] visited = new boolean[insertArr.size()];
		
		for(int i=0; i<insertArr.size(); i++)
			arr[i] = insertArr.get(i);
		
		location = sc.nextInt();
		
		perm(arr, output, visited, 0, arr.length, 3);
		
	}
	
	static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		
		//- 현재 깊이는 뽑은 개수이다
		//- 즉, 뽑은 개수와 뽑을 개수가 같다면 종료.
		if(depth == r) {
			now++;
			if (now == location)
			print(output,r);
			return;
		}
		
		// 1. 모든 원소를 순회한다.
		for (int i=0; i<n; i++) {
			// 2. 방문하지 않은 원소를 찾는다
			if(visited[i] != true) {
				visited[i] 		= true;		// 방문표시를 한다
				output[depth] 	= arr[i];	// 결과값 배열의 해당깊이 위치에 방문하지 않은 원소 값 대입
				perm(arr, output, visited, depth+1, n, r);
				visited[i] 		= false;
			}
		}
	}
	
	// 배열 출력
	static void print(int[] arr, int r) {
        for(int i=0; i<r; i++)
            System.out.print(arr[i] + " ");
		System.out.println();
	}
}

