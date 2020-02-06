 http://wookje.dance/2019/01/23/boj-2437/
	 메모리 초과 다시하기
	 풀이 잘 이해 안된다
	 //https://www.acmicpc.net/problem/2437
package org.tryAgain;

import java.util.*;
public class test2437_scale {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		List<Long> pick = new ArrayList<>();
		for(int i=0; i<N; i++) {
			arr[i]= sc.nextInt();
		}
		
		for (int i=1; i<N+1; i++) {
			fun(arr, pick, i, 0);
		}
		
		List<Long> sumList2 = new ArrayList<>(sumList);
		Collections.sort(sumList2);
		int check = 1;
		for (Long sum:sumList2) {
			if(sum != check) {
				System.out.println(check);
				break;
			}
			else
				check ++;
		}
	}
	static Set<Long> sumList = new HashSet<>();
	public static void fun(int[] arr, List<Long> pick, int count, int idx ) {
		
		if(count == 0) {
			//System.out.println("---");
			int sum = 0;
			for (Long p:pick) {
				//System.out.print(p+" ");
				sum += p;
			}
			sumList.add((long) sum);
			return;
		}
		
		for (int i=idx; i<arr.length; i++) {
			pick.add((long) arr[i]);
			fun(arr, pick, count-1, i+1);
			pick.remove(pick.size()-1);
		}
		
	}
}
