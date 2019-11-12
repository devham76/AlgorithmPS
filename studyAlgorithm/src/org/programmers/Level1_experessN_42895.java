package org.programmers;

public class Level1_experessN_42895 {

	public static void main(String[] args) {
		solution(5 ,12);
	}
    public static int solution(int N, int number) {
    	dfs (N, number, 0, 0);
        return answer;
    }
    static int answer = -1;
    public static void dfs(int N, int number, int count, int current){
    	
    	if (count > 9) {
    		answer = -1;
    		return ;
    	}
    	if (current == number) {
    		// answer 값이 안정해져 있거나 answer보다 count가 더 최솟값이면 
    		if (answer == -1 || answer > count)
    			answer = count;
    		return ;
    	}
    	int nn = N;
    	for (int i = 0; i < 8 - count; i++) {
    		// 이전까지의 연산횟수 + 현재 이루어질 사칙연산 횟수(1) + nn을 만들어서 발생한 횟수(i)
    		// 맨처음의 nn은 N, 그 다음은 NN, NNN, NNNN..... ; 언제까지? 8 - 이전 연산 횟수 만큼 만들어서 연산한다. 
    		dfs(N, number, count+1+i, current+nn);
    		dfs(N, number, count+1+i, current-nn);
    		dfs(N, number, count+1+i, current/nn);
    		dfs(N, number, count+1+i, current*nn);
    		
    		nn = N*10 + N;	
    	}
    }
}
