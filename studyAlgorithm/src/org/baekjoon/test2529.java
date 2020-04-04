package org.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class test2529 {
	static List<String> list;
	static boolean[] visited;
	static char[] arr;
	static int k;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt(); // 부등호 개수
		arr = new char[k];
		visited = new boolean[10];
		
		for (int i = 0; i < k; i++) {
			arr[i] = sc.next().charAt(0);
		}

		list = new ArrayList<>();

		// 맨처음 들어갈수있는 숫자는 0~9이다.
		for (int num = 0; num <= 9; num++) {
			visited[num] = true;
			
			makeNum(0, num, num + "");

			visited[num] = false;
		}
		Collections.sort(list);
		
		System.out.println(list.get(list.size()-1)+"\n"+list.get(0));
	}

	
	// compareIdx : 부등호의 인덱스, num: 왼쪽의 숫자 , str: 지금까지 만든 숫자 정보 (0으로도 시작할수있으니까 string)
	// 내가 잘못한것 -> str로 상황마다 받고, str길이가 완성이 된경우 그것을 list로 넣으면됐다.
	private static void makeNum(int compareIdx, int num, String str) {
		// 지금까지 만든숫자 길이 == 부등호+1이면 끝.
		if (str.length() == k + 1) {
			list.add(str);
			return;
		}
		// 더이상 부등호가 없어도 끝.
		if (compareIdx >= k)
			return;

		// 오른쪽에 들어갈 숫자를 찾는다.
		for (int next = 0; next <= 9; next++) {
			// 왼쪽에서 사용한적없고, 부등호에 성립할때 해당 숫자를 방문한다.
			if (visited[next] == false && compareNum(arr[compareIdx], num, next) == true) {
				// 해당숫자를 뽑고
				visited[next] = true;
				// 해당숫자를 넣어서 문자열을 만들고 그 다음 숫자를 만들도록 함수 호출.
				makeNum(compareIdx + 1, next, str + next);
				// 뽑은 해당숫자를 다서 복귀시켜서, 다음번 조합을 만들수 있도록한다.
				visited[next] = false;
			}
		}
	}

	public static boolean compareNum(char compare, int num1, int num2) {
		if (compare == '<' && (num1 < num2)) {
			return true;
		}

		if (compare == '>' && (num1 > num2)) {
			return true;
		}

		return false;
	}

}
