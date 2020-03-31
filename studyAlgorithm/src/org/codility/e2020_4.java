package org.codility;

public class e2020_4 {

	public static void main(String[] args) {
		int[] A = {1,2,3,4};// 오류발생...
		// 요소 하나를 제거해서 high, low, hight, low 만들기
		// 처음부터 만들수있으면 0, 하나만 제거하면 안될때 -1
		// 틀린듯. 1,3,2,5,8  / 1,2,4 일때 이상
		
		
		int answer = 0;
		for (int remove = -1; remove < A.length; remove++) {
			int prev = -1;
			boolean is_possible = true;
			//System.out.println("remove="+remove);
			
			for (int i =0; i < A.length - 1; i++) {
				//System.out.println("remove="+remove+" , i="+i);
				if(remove == i) continue;
				
				int cur = i;
				int next = i+1;
				if(next == remove) next++;
				
				System.out.println("reomve="+remove+" i="+i+" CUR="+cur+" next="+next);
				System.out.println(A[cur] + " , " + A[next] + " prev=" + prev);
				if (A[cur] > A[next]) {
					if (prev == -1 || prev == 0) {
						prev = 1;
						continue;
					}

					if (prev == 1) {
						is_possible = false;
						break;
					}
				} else if (A[cur] < A[next]) {
					if (prev == -1 || prev == 1) {
						prev = 0;
						continue;
					}

					if (prev == 0) {
						is_possible = false;
						break;
					}
				}
			}

			//System.out.println("is possible = " + is_possible);
			// 처음부터 완벽
			if(remove == -1 && is_possible == true) {
				answer = -2;
				break;
			}
				
			if(is_possible == true)
				answer++;
			
		}
		if(answer == 0)
			System.out.println(-1);
		else if(answer == -2)
			System.out.println(0);
		else
			System.out.println(answer);

	}

}
