package org.programmers;

public class Test42897_dp_thieves {

	public static void main(String[] args) {
		Test42897_dp_thieves t = new Test42897_dp_thieves();
		int[] money = {1,2,3,1};
		t.solution(money);

	}
    public int solution(int[] money) {
        int answer = 0;
        int idx = money.length-1;
        int[] dp1 = new int[money.length-1];
        int[] dp2 = new int[money.length];
        
        // �Ǿ��� ����, �ǵ� ������
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0],	money[1]);
        for(int i=2; i<money.length-1; i++)	// �ǵڴ� �������ϹǷ� dp1[2] ������ ���Ҽ��ִ�
        	dp1[i] = Math.max(money[i]+dp1[i-2], dp1[i-1]);
        
        // �Ǿ� ������, �ǵ� ����
        dp2[1] = money[1];
        for(int i=2; i<money.length; i++)	// �Ǿ��� ���� ���ϹǷ� dp2[0]�� �����Ҽ�����, dp2[3]���� ���Ҽ��ִ�
        	dp2[i] = Math.max(money[i]+dp2[i-2], dp2[i-1]);
        
        answer = Math.max(dp1[idx-1], dp2[idx]);
        System.out.println(answer);
        
        return answer;
    }
}
