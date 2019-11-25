package org.programmers;
// https://programmers.co.kr/learn/courses/30/lessons/12980
public class summercoding_2017_12980 {
	
	// Ư���� ���� ������ n������ �����غ��� 
	// 1~5000 �Ǵ� 5000~1�� ���� �ΰ��� ��� ��� ������ ����.

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
        	if (n%2 == 0) { // �ִ��� x2�� ���ִ°� �����ϴ�.
        		n = n/2;
        	}else {
        		n = n-1;	// 2�� �������� ������ �ּ����� ������ 1�� ���ش�.
        		ans = ans+1;		// 1��ŭ ���͸� �Ҹ�
        	}
        }
        return ans;
    }
    // https://lkhlkh23.tistory.com/149
    public int solution2(int n) {
    	// 2������ ��� 1�� ������ �����ش�.
    	// 1�� 2�� �������� ������ �����, 1��ŭ ���ư��� �ϴϱ� 1�� ������ ����.
    	return Integer.bitCount(n);
    }
   
}
