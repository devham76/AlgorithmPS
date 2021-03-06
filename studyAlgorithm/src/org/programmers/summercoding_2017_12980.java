package org.programmers;
// https://programmers.co.kr/learn/courses/30/lessons/12980
public class summercoding_2017_12980 {
	
	// 특정한 수로 나누면 n진수를 생각해보고 
	// 1~5000 또는 5000~1로 가는 두가지 방법 모두 생각해 보자.

	public static void main(String[] args) {
		summercoding_2017_12980 s1 = new summercoding_2017_12980();
		
		s1.solution3(5000);
		//s1.solution2(5000);
	}
	 public int solution3(int n) {
		 int ans = 0;
		 while (n != 0) {
			 if (n%2 != 0) {
				++ans;
			 }
			 n = n/2;
		 }
		 return ans;
	 }
	
	//https://n1tjrgns.tistory.com/182
    public int solution1(int n) {
        int ans = 0;
        
        while (n!=0) {
        	if (n%2 == 0) { // 최대한 x2를 해주는게 유리하다.
        		n = n/2;
        	}else {
        		n = n-1;	// 2로 나눠지지 않으면 최소한의 걸음인 1을 빼준다.
        		ans = ans+1;		// 1만큼 배터리 소모
        	}
        }
        return ans;
    }
    // https://lkhlkh23.tistory.com/149
    public int solution2(int n) {
    	// 2진법의 결과 1의 갯수를 세어준다.
    	// 1은 2로 나눠지지 않을때 생기고, 1만큼 나아가야 하니까 1의 개수가 정답.
    	return Integer.bitCount(n);
    }
   
}
