package org.codingTest;

public final class Lesson2_CyclicRotation {

	public static void main(String[] args) {
		int[] A = {3, 8, 9, 7, 6};
		
		solution(A, 3);
	}
	public static int[] solution(int[] A, int K) {
		int[] answer = new int[A.length];
		int len = A.length;
		for(int i=0; i<A.length; i++) {
			answer [ (i+K) % len ] = A[i];
		}
		return answer;
	}
}
