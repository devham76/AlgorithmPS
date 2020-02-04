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
        
        // 맨앞을 포함, 맨뒤 불포함
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0],	money[1]);
        for(int i=2; i<money.length-1; i++)	// 맨뒤는 불포함하므로 dp1[2] 까지만 구할수있다
        	dp1[i] = Math.max(money[i]+dp1[i-2], dp1[i-1]);
        
        // 맨앞 불포함, 맨뒤 포함
        dp2[1] = money[1];
        for(int i=2; i<money.length; i++)	// 맨앞은 포함 안하므로 dp2[0]은 설정할수없고, dp2[3]까지 구할수있다
        	dp2[i] = Math.max(money[i]+dp2[i-2], dp2[i-1]);
        
        answer = Math.max(dp1[idx-1], dp2[idx]);
        System.out.println(answer);
        
        return answer;
    }
}
