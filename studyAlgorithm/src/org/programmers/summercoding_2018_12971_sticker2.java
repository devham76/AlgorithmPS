// Ǯ�� ���� : https://aomee0880.tistory.com/94
// https://www.welcomekakao.com/learn/courses/30/lessons/12971
/* 
 �ذ� ��� : 
1. Math.max(���� ��ƼĿ ���� + ���罺ƼĿ-2�� dp , ���罺ƼĿ-1�� dp) �� �⺻ ��ȭ���� �ȴ�.
2. �����̹Ƿ� ù��° ��Ƽ���� ���ų� ���������� �ΰ����� �����ؾ� �Ѵ�.
3. ù���� ��ƼĿ�� ���ٸ�, ������ ��ƼĿ�� ���� ���� �ʴ´�.
4. ��ƼĿ�z 10���� ���� ������ �ִ�.
*/
package org.programmers;

public class summercoding_2018_12971_sticker2 {

	public static void main(String[] args) {
		int[] s1 = {14, 6, 5, 11, 3, 9, 2, 10};
		int[] s2 = {1, 3, 2, 5, 4};
		// 36 8
		solution(s1);
	}
    public static int solution(int sticker[]) {
    	int[] dp1 = new int[100001];
    	int[] dp2 = new int[100001];
    	
    	int len = sticker.length;
    	if (len == 1) return sticker[0];
    	
    	
    	// ù��° ��ƼĿ�� ����ٸ�
    	dp1[0] = sticker[0];
    	dp1[1] = dp1[0];
    	// ù��° ��ƼĿ ������, ������ ��ƼĿ�� ����� �� ����
    	// ��ƼĿ 4��° ���� ��ȿ , dp1[2] => ��ƼĿ 4��°�� dp
    	for (int i = 2; i < len-1; i++)
    		dp1[i] = Math.max(sticker[i]+dp1[i-2], dp1[i-1]);
    	
    	// ù��° ��ƼĿ �ȶ�´ٸ�
    	dp2[0] = 0;	// ��ƼĿ �Ѱ� ������ �������Ƿ� 0
    	dp2[1] = sticker[1]; // ��ƼĿ �ΰ� ������ �ι�° ����Ŀ ��´�.
    	// ��ƼĿ ����° ���� ��ȿ, dp2[2] => ��ƼĿ 3��°�� dp
    	for (int i = 2; i < len; i++)
    		dp2[i] = Math.max(sticker[i]+dp2[i-2], dp2[i-1]);
    	
    	// ū����ȯ ( ù��°��ƼĿ ������ ������ ��ƼĿ ������, ������ ��ƼĿ�� dp)
    	return Math.max(dp1[len-2], dp2[len-1]);
    } 

    
}
