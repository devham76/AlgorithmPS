package org.programmers;

public class Test0921 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(124);

	}
	static int solution(int n) {
		System.out.println("n==>"+n);
		int answer = 0;
		while(true){
			answer += n % 10;
			n = n / 10;
			if(n==0) break;
		}
		return answer;
	}
}
