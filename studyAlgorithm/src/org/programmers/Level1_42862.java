package org.programmers;

import java.util.ArrayList;

// https://programmers.co.kr/learn/courses/30/lessons/42862
// Ã¼À°º¹ ¹®Á¦
public class Level1_42862 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lost = {1, 2, 3, 5, 6, 7, 10, 11, 12, 14, 15, 16, 19, 20};
		int[] reserve = { 1, 2, 6, 7, 8, 9, 11, 15, 18, 19};
		int n = 20;
		solution(n, lost, reserve);
	}
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        int recovery = 0;
        int ridx = 0;
       
        
       
        for(int i=0; i<lost.length; i++) {
        	for(int j=0; j<reserve.length; j++) {
        		if(lost[i] == reserve[j]) {
        			lost[i] = -1;reserve[j]=-1;recovery++;
        		}
        	}
        }
        
        for(int e : lost)
        System.out.print(e+" ");

        System.out.println();
        for(int e : reserve)
        System.out.print(e+" ");  
        System.out.println();

        for (int i=0; i<lost.length; i++) {
        	int help = lost[i];
        	for(int j=0; j<reserve.length; j++) {
        		System.out.println("reseve ; "+reserve[j]+" / help;"+help);
        		if(reserve[j] == help-1 || reserve[j] == help+1) {
        			reserve[j] = -1; lost[i] = -1; recovery++;
        			break;
        		}
        	}
        }
        
        for(int e : lost)
        System.out.print(e+" ");

        System.out.println();
        for(int e : reserve)
        System.out.print(e+" ");  
        answer = n-lost.length+recovery;
        System.out.println("answer  ;"+answer);
        return answer;
    }
}
