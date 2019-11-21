    // Ʋ������ : ���ϴ� �۾��� ���Ҷ����� ������� -> �ð��ʰ�
    // �ذ� : �޸������̼� ����� �̿��ؼ� �̸� ���س��� ���س��� ���� �������. (dp)
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
        	int son1 = sum[i];	// 1~i ��° ������ �ٱ��ϼ� ��Ű����
        	
        	for (int j = i+1; j < cookie.length; j++) {
        		int son2 = sum[j] - son1; // i+1 ~ ��° ������ �ٱ��ϼ� ��Ű����
        		
        		// ���� �ɼ��ִ� �Ƶ�2�� ��Ű������ �̹� ���� �亸�� �۰ų�
        		if (answer >= son2 ) continue;
        		
        		// �Ƶ�1�� �ٱ��ϴ� 0~i , 1~i, 2~i...�� �� �ִ�.
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
