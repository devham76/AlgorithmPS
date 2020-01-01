package org.programmers;

public class test12913_land {

	public static void main(String[] args) {
		test12913_land t = new test12913_land();
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		t.solution(land);
	}
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][4];
        
        for(int i=0; i<4; i++)
        	dp[0][i] = land[0][i];
        
        for(int i=1; i<land.length; i++) {
        	for(int j=0; j<4; j++) {
        		dp[i][j] = land[i][j] + findMax(i-1,j,dp);
        	}
        }
        
        answer = findMax(dp.length-1, 4, dp);
        return answer;
    }
    public static int findMax(int row, int except,int[][] dp) {
    	int result = 0;
    	for(int i=0; i<4; i++) {
    		if(i == except) 
    			continue;
    		else {
    			result = Math.max(result, dp[row][i]);	
    		}
    	}
    	return result;
    }
}
