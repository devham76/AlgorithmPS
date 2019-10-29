package org.programmers;

import java.util.*;

 class document implements Comparable<document>{

    int prioty;		// 우선순위, 클수록 우선순위가 높다.
    int location;	// 문서위치
    
    public document(int prioty, int location) {
    	this.prioty 	= prioty;
    	this.location 	= location;
    }
    int getPrioty() {
    	return this.prioty;
    }
    int getLocation() {
    	return this.location;
    }
    
	@Override
	//오름차순 정렬 -1,0,1
	public int compareTo(document target) {
		// 내 우선순위가 더 높으면 -1
		// 내 우선순위가 더 낮으면 1
		// 우선순위가 같으면 0
		if(this.prioty > target.prioty) return -1;
		else if (this.prioty < target.prioty) return 1;
    	return 0;
    }
	
    @Override
    public String toString() {
        return "우선순위 : " + prioty + ", 위치 : " + location;
    }
    
}
public class Test190919_document {

    static int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<document> dQ = new PriorityQueue<document>();

        int j = 1;
        for (int i : priorities) {
        	System.out.println("i : "+i+" j : "+j);
        	dQ.offer(new document(i, j++));

        }
        
        while(dQ.isEmpty()==false){
        	answer++;
        	document tempQ = dQ.poll();
			System.out.println(tempQ);
			if (tempQ.location == location+1) 
				break;
				
			
		}
        return answer;
    }
    
	public static void main(String[] args) {
		int[] array = {8, 10, 13, 17, 19}; 
		int answer;
		answer = solution(array, 3); // 정답은 1
		System.out.println("answer : "+answer);
	}
}
