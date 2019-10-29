package org.programmers;

import java.util.*;

 class document implements Comparable<document>{

    int prioty;		// �켱����, Ŭ���� �켱������ ����.
    int location;	// ������ġ
    
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
	//�������� ���� -1,0,1
	public int compareTo(document target) {
		// �� �켱������ �� ������ -1
		// �� �켱������ �� ������ 1
		// �켱������ ������ 0
		if(this.prioty > target.prioty) return -1;
		else if (this.prioty < target.prioty) return 1;
    	return 0;
    }
	
    @Override
    public String toString() {
        return "�켱���� : " + prioty + ", ��ġ : " + location;
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
		answer = solution(array, 3); // ������ 1
		System.out.println("answer : "+answer);
	}
}
