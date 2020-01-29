// 다시할것 ㅠㅠㅠ
//https://velog.io/@ptm0304/%EC%B9%B4%EB%93%9C%EA%B2%8C%EC%9E%84
// https://www.welcomekakao.com/learn/courses/30/lessons/42896
package org.programmers;

import java.util.Arrays;

public class test42896_dp_cardGame {

	public static void main(String[] args) {
		test42896_dp_cardGame t = new test42896_dp_cardGame();
		int[] left = {3, 2, 5};
		int[] right = {2, 4, 1};
		t.solution(left, right);

	}
    private int[][] memo; // memoization 테이블
    private int[] left;
    private int[] right;
    public int solution(int[] left, int[] right) {
        memo = new int[left.length][right.length];
        for (int i = 0; i < left.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        this.left = left;
        this.right = right;
        return helper(0,0);
    }

    public int helper(int leftInd, int rightInd) {
        if (left.length == leftInd || right.length == rightInd) {
            return 0;
        }
        if (memo[leftInd][rightInd] != -1) {
            //이미 최적값을 찾은 상태
            return memo[leftInd][rightInd];
        } 
        if (right[rightInd] < left[leftInd]) {
            // 오른쪽 카드가 더 작다면 오른쪽 카드를 버리고 더해준다
            int currAns = helper(leftInd, rightInd+1) + right[rightInd];

            // 계산한 값을 memoization 테이블에 저장
            memo[leftInd][rightInd] = currAns;
            return currAns;
        }
        else {
            // 왼쪽카드만 버리거나 오른쪽카드와 왼쪽카드를 둘다 버리고 그 둘중 최적값을 계산
            int currAns = Math.max(helper(leftInd + 1, rightInd + 1),
            helper(leftInd + 1, rightInd));

            // 최적값을 memoization 테이블에 저장
            memo[leftInd][rightInd] = currAns;
            return currAns;
        }
    }
 
}
