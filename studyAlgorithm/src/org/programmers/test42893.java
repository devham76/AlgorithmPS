package org.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class test42893 {
	public static void main(String[] args) {
		solution("17");
	}
	static HashSet<Integer> hs;
	static boolean[] visited;
	static int[] num;
	static int answer=0;
	public static int solution(String numbers) {
        num = new int[numbers.length()];
        for(int i=0; i<numbers.length(); i++) {
        	num[i] = Integer.parseInt(numbers.charAt(i)+"");
        }
        
        hs = new HashSet<>();
        visited = new boolean[numbers.length()];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<numbers.length();i++) {
        	if(num[i] == 0)
        		continue;
        	
        	visited[i] = true;
        	list.add(num[i]);
        	
        	make_num(list);
        	
        	visited[i] = false;
        	list.remove(list.size()-1);
        }
        return answer;
    }
	private static void make_num(ArrayList<Integer> list) {
		StringBuilder sb = new StringBuilder();
		for(Integer l:list) {
			sb.append(l);
		}
		
		int numInt = Integer.parseInt(new String(sb));
		if(!hs.contains(numInt)) {
			hs.add(numInt);
			if(is_possible(numInt))
				answer++;
		}
		
		for(int i=0; i<num.length;i++) {
			if(visited[i] == true)
				continue;
			
			visited[i] = true;
			list.add(num[i]);
			make_num(list);
			visited[i] = false;
			list.remove(list.size()-1);
		}
		
	}
	public static boolean is_possible(int number) {
		if(number==1)
			return false;
		
		for(int i=2; i<number; i++) {
			if(number % i == 0)
				return false;
		}
		return true;
	}
}
