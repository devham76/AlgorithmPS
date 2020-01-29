// �ٽ��Ұ� �ФФ�
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
    private int[][] memo; // memoization ���̺�
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
            //�̹� �������� ã�� ����
            return memo[leftInd][rightInd];
        } 
        if (right[rightInd] < left[leftInd]) {
            // ������ ī�尡 �� �۴ٸ� ������ ī�带 ������ �����ش�
            int currAns = helper(leftInd, rightInd+1) + right[rightInd];

            // ����� ���� memoization ���̺� ����
            memo[leftInd][rightInd] = currAns;
            return currAns;
        }
        else {
            // ����ī�常 �����ų� ������ī��� ����ī�带 �Ѵ� ������ �� ���� �������� ���
            int currAns = Math.max(helper(leftInd + 1, rightInd + 1),
            helper(leftInd + 1, rightInd));

            // �������� memoization ���̺� ����
            memo[leftInd][rightInd] = currAns;
            return currAns;
        }
    }
 
}
