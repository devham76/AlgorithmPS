package org.programmers;

import java.util.Arrays;

public class test43105_triangle {

	public static void main(String[] args) {
		test43105_triangle t = new test43105_triangle();
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(t.solution(triangle));

	}
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        int[][] dp = new int[len][len];
        
        dp[0][0] = triangle[0][0];
        
        for (int i=1; i<len; i++) {
        	for(int j=0; j<=i; j++) {
        		
        		if(j==0) dp[i][0] = dp[i-1][0] + triangle[i][0];
        		else if(j==i) dp[i][j] = dp[i-1][i-1] + triangle[i][i];
        		else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];

        		answer = Math.max(answer, dp[i][j]);
        	}
        }
        return answer;
    }
    // 다른사람 풀이
    public int solution2(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for (int j = 1; j < i; j++) 
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }

        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }
}
