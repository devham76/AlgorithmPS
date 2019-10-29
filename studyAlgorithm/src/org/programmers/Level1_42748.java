package org.programmers;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/42748
//k번째수구하기
public class Level1_42748 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
		int[] s = solution(array, commands);
	}
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i=0; i<commands.length; i++) {
        	
        	// 1. 이렇게 대체 할 수 있음. int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
        	int[] tmpArr = new int[commands[i][1]-commands[i][0]+1];
        	for(int j=0; j<tmpArr.length; j++) {
        		tmpArr[j] = array[ commands[i][0] + j -1];
        	}
        	
        	// 2.
        	Arrays.sort(tmpArr);
        	// 3.
        	answer[i] = tmpArr[commands[i][2]-1];
        }
        return answer;
    }
}
