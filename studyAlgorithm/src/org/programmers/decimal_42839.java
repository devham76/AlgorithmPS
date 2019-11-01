package org.programmers;

import java.util.ArrayList;
import java.util.Scanner;

public class decimal_42839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();

		solution(input);
		
	}
	static ArrayList<Integer> finalNumber = new ArrayList<>();
    public static int solution(String numbers) {
        int answer = 0;
		int[] list = new int[numbers.length()];
		for (int i=0; i<numbers.length(); i++)
			list[i] = Integer.parseInt(numbers.charAt(i)+"");
		
		boolean[] visited = new boolean[numbers.length()];
		// 소수구하기
		for (int i=1; i<=numbers.length(); i++) {
			permutation(list, visited, 0, i);
		}
		
		//for (int e:finalNumber)
			//System.out.println(e);
		
        return answer;
    }
    // list배열에서  peekCnt개수 만큼 뽑는다. 뽑히면 visited는 true
    public static void permutation(int[] list, boolean[] visited, int start, int peekCnt) {
    	// 더이상 뽑을 개수가 없으면
    	if(peekCnt == 0) {
    		print(list, visited);
    	}
    	
    	for (int i=start; i<list.length; i++) {
    		//System.out.println("permutation [i] :"+i+", visited:"+visited[i]);
    		if(visited[i] == false) {
    			visited[i] = true;
    			permutation(list, visited, i+1, peekCnt-1);
    			visited[i] = false;
    		}
    		
    	}
    }
    public static void print(int[] list, boolean[] visited) {
    	String number = "";
    	for (int i=0; i<list.length; i++) { 		
    		if (visited[i] == true)
    			System.out.print(list[i]+" ");
    	}
    	System.out.println();

    	
    	
    }
    
}
