package org.programmers;

import java.util.*;

public class test42841_numberBaseball {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		test42841_numberBaseball t = new test42841_numberBaseball();
		t.solution(baseball);
	}
	boolean[] visited = new boolean[10];
    public int solution(int[][] baseball) {
        int answer = 0;
        
        List<String> numList = new ArrayList<>();
        // 가능한 세자리수를 모두 만든다
        makeNumList("", numList, 0);
        
        for(int[] turn : baseball) {
            numList = doGame(numList, String.valueOf(turn[0]), turn[1], turn[2]);
        }
        //System.out.println(numList.size());
        return answer;
    }
	private List<String> doGame(List<String> numList, String givenNum, int s, int b) {

		List<String> newNumList = new ArrayList<>();
		Iterator<String> numbers = numList.iterator();
        int strike = 0;
        int ball = 0;
        while (numbers.hasNext()) {
            String candidateNum = numbers.next();
            
            // 후보 숫자가 주어진 조건에 부합하는지 확인한다
            for(int i=0; i<3; i++) {
            	for (int j=0; j<3; j++) {
            		if( i==j && candidateNum.charAt(i) == givenNum.charAt(j)) strike++;
            		else if ( i!=j && candidateNum.charAt(i) == givenNum.charAt(j) ) ball++;
            	}
            }
            if (s==strike && b==ball)
            	newNumList.add(candidateNum);
            strike =0;
            ball = 0;
        }
        
		return newNumList;
	}
	private void makeNumList(String number, List<String> numList, int depth) {
		
		if(depth==3) {
			numList.add(number);
			return;
		}
		
		for (int i=1; i<10; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				//System.out.println(i);
				makeNumList(number+i, numList, depth+1);
				visited[i] = false;
			}
		}
		
	}
}
