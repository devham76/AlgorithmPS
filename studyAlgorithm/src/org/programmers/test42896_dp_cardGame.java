// 다시할것 ㅠㅠㅠ
// https://www.welcomekakao.com/learn/courses/30/lessons/42896
package org.programmers;

public class test42896_dp_cardGame {

	public static void main(String[] args) {
		test42896_dp_cardGame t = new test42896_dp_cardGame();
		int[] left = {3, 2, 5};
		int[] right = {2, 4, 1};
		t.solution(left, right);

	}
	static int[] Left,Right;
	static int[][] dp;
    public int solution(int[] left, int[] right) {
        int answer = 0;
        Left = new int[left.length];
        Right = new int[right.length];
        dp = new int[left.length][left.length];
        for(int i=0; i<left.length; i++) {
        	Left[i] = left[i];
        	Right[i] = right[i];
        	for(int j=0; j<left.length; j++) 
        		dp[i][j] = -1;
        	
        }
        
        
        System.out.println(fun(0, 0, 0));
        return answer;
    }
    public static int fun (int l, int r, int sum) {
    	int result1,result2,result3, result;
    	

    	System.out.println("l: "+l+" , r:"+r+ " , sum:"+sum+" dp[l][r]"+dp[l][r]+" / left:"+Left[l]+", right:"+Right[r] );    
    	if(l == Left.length-1 || r == Right.length-1) {
    		return sum;
    	}
    	if(dp[l][r] > -1)
    		return dp[l][r];
    	
    	int nextL = l+1;
    	int nextR = r+1;
    	if (Left[l] > Right[r]) {
    		//System.out.println("l: "+l+" , r:"+r+ " , sum:"+sum+", Right[r]:"+Right[r]);
    		//result += Math.max(fun(l, nextR, sum+Right[r]), Math.max( fun(nextL,nextR,sum), fun(nextL, r,sum)) ); 
    		dp[l][r] =  Math.max( dp[l][r], dp[l][r] +fun(l, nextR, sum+Right[r])); 
    		dp[l][r] =  Math.max( dp[l][r],  dp[l][r] +fun(nextL,nextR,sum));
    		dp[l][r] =  Math.max( dp[l][r],  dp[l][r] +fun(nextL, r,sum)) ; 
    		//System.out.println(result1+", "+result2+", "+result3);
    		//dp[l][r] = Math.max(result1, Math.max(result2,result3));
    	}
    	else {
    		//System.out.println("l: "+l+" , r:"+r+ " , sum:"+sum);
    		dp[l][r] =  Math.max( dp[l][r], dp[l][r] + fun(nextL,nextR,sum));
    		dp[l][r] =  Math.max( dp[l][r], dp[l][r] + fun(nextL, r,sum)); 
    		//System.out.println(result1+", "+result2);
    		//dp[l][r] = Math.max(result1,result2);
    	}
    	
    	System.out.println(dp[l][r]);
    	return dp[l][r];
    }
}
