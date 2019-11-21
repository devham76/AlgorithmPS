    // 틀린이유 : 더하는 작업을 비교할때마다 더해줬다 -> 시간초과
    // 해결 : 메모이제이션 방법을 이용해서 미리 더해놓고 더해놓은 값을 사용하자. (dp)
package org.programmers;
public class summercoding_49995_cookie {

	public static void main(String[] args) {
		int[] s = {1,2,4,5};
		solution(s);

	}
    public static int solution(int[] cookie) {
        int answer = 0;
        int[] sum = cookieSum(cookie);
        
        for (int i = 1; i < cookie.length; i++) {
        	int son1 = sum[i];	// 1~i 번째 까지의 바구니속 쿠키개수
        	
        	for (int j = i+1; j < cookie.length; j++) {
        		int son2 = sum[j] - son1; // i+1 ~ 번째 까지의 바구니속 쿠키개수
        		
        		// 답이 될수있는 아들2의 쿠키개수가 이미 구한 답보다 작거나
        		if (answer >= son2 ) continue;
        		
        		// 아들1의 바구니는 0~i , 1~i, 2~i...일 수 있다.
        		for (int k=0; k < i; k++) {
        			if (son2 == son1 - sum[k]) {
        				answer = Math.max(answer, son2);
        				break;
        			}
        		}
        	}
        }
        System.out.println(answer);
        return answer;
    }

    public static int[] cookieSum(int[] cookie) {
    	int sum[] = new int[cookie.length+1];
    	for (int i = 0; i < cookie.length; i++) {
    		sum[i+1] = sum[i] + cookie[i];
    	}
    	return sum;
    }
}
