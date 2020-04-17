다시 최소공배수 이용....
package org.programmers;

public class Level2_62048 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public long solution(int w,int h) {
		long answer = 0;
		// 항상 w<h이게 한다.
		if(w>h) {
			int tmp = h;
			h = w;
			w = h;
		}
		if(w == h) {
			answer = w*w - w;
		}
		else {
			int minus = (h-1) / 4;
			minus++;
			minus = minus * w;
			if(h%4 == 3)
				minus += 2;
			System.out.println();
			answer = w*w - minus;
			
		}
		return answer;
	}
}
