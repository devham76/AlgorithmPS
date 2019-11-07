package org.programmers;

public class Level2_targetNumber_43165 {

	public static void main(String[] args) {
		int[]  n = {1,1,1,1,1};
		int target = 3;
		solution(n, target);

	}
	static int answer = 0;
    public static int solution(int[] numbers, int target) {
       
        
        fun(numbers, target, 0, 0);
        System.out.println(answer);
        return answer;
    }
    public static void fun(int[] numbers, int target, int cnt, int current) {
    	if(cnt == numbers.length) {
    		if(current == target)
    			answer++;
    	}
    	else {
    	fun(numbers, target, cnt+1, current+numbers[cnt]);
    	fun(numbers, target, cnt+1, current-numbers[cnt]);
    	}
    }
}
