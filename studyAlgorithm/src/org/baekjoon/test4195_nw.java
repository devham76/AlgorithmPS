package org.baekjoon;

import java.util.*;

public class test4195_nw {

	static int[] parent ;
	static int[] count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		while(test_case > 0) {
			test_case--;
			
			// 친구관계
			int F = sc.nextInt();
			// 사람수의 최대 = 친구관계 x 2
			parent = new int[F*2];
			// 네트워크속 사람 수
			count = new int[F*2];
			
			for(int i=0; i<F*2; i++) {
				parent[i] = i;
				count[i] = 1;
			}
			int num = 0;
			Map<String, Integer> hm = new LinkedHashMap<>();	//key순서보장
			for(int i=0; i<F; i++){
				String f1 = sc.next();
				String f2 = sc.next();
				
				// 새로운 사람이라면, 사람에게 번호 부여
				if (!hm.containsKey(f1)) 
					hm.put(f1, num++);
				
				if (!hm.containsKey(f2))
					hm.put(f2, num++);
				
				// 사람의 번호로 부모찾기
				int f_num1 = hm.get(f1);
				int f_num2 = hm.get(f2);
			
				union(f_num1, f_num2);
				for(Integer p:parent) {
					System.out.print(p+" ");
				}
			}
			
			Iterator<String> keys = hm.keySet().iterator();
			while(keys.hasNext()) {
				String key = keys.next();
				System.out.println(key+", "+hm.get(key));
			}
			
			for(Integer p:parent) {
				System.out.print(p+" ");
			}
		}
	}

	private static void union(int f_num1, int f_num2) {
		f_num1 = find(f_num1);
		f_num2 = find(f_num2);
		
		// 부모가 같으면 같은 네트워크에 속해있으므로
		// 부모의 네트워크 개수 반환
		// 그게 아니라면 두 네트워크 합쳐서 반환
		if(f_num1 != f_num2) {
			parent[f_num2] = f_num1; // f_num1이 부모가된다.
			count[f_num1] += count[f_num2];	// f_num1은 f_num2의 네트워크를 차지한다.
			count[f_num2] = 1; // f_num2는 꼬리가 되므로 자기 자신하나.
		}
		System.out.println(count[f_num1]);
	}

	private static int find(int f_num) {
		// 내 부모가 나이면 나를 반환
		if(parent[f_num] == f_num) {
			return f_num;
		}
		// 내 부모의 최종 부모를 찾아 반환
		else {
			return parent[f_num] = find(parent[f_num]);
		}
	}

}
