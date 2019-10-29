package org.programmers;

// https://programmers.co.kr/learn/courses/30/lessons/49993#fn1

public class wintercoding_2018_49993 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// "CBD"	["BACDE", "CBADF", "AECB", "BDA"]	2
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		solution(skill, skill_trees);
	}
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for ( int i=0; i<skill_trees.length; i++ ) {
        	System.out.println(skill_trees[i]);
        	boolean isOk = true;
        	
        	for ( int j=0; j<skill.length()-1; j++ ) {
        		int s1 = skill_trees[i].indexOf( skill.charAt(j) );
        		int s2 = skill_trees[i].indexOf( skill.charAt(j+1) );
        		System.out.println("j : "+j+" / s1:"+s1+" s2:"+s2);
        		
        		// case 1: 마지막 원소가 -1일땐 마지막 안본다.
        		if (j == skill.length()-2 && s2 == -1) {
        			isOk = true;
        		} 
        		// case 2: 첫번째 원소가 -1일땐 거짓.
        		else if (j==0 && s1 == -1 && s1 < s2) {
        			isOk=false; break;
        		}
        		// case 3: 위치를 비교한다.
        		else {
        			if ( s1 > s2 ) {	
        				isOk=false; break;
        			}
        			else {
        				isOk=true;
        			}
        		}
        	}
        	
        	if(isOk == true) { 
        		System.out.println("--->"+skill_trees[i]);
        		answer++;
        	}
        }
        System.out.println(answer);
        return answer;
    }
}
//-- 풀이 : https://m.blog.naver.com/PostView.nhn?blogId=yongyos&logNo=221572139348&categoryNo=39&proxyReferer=https%3A%2F%2Fwww.google.com%2F
/*
 public int solution(String skill, String[] skill_trees) {
	/* 1 
	int answer = skill_trees.length;
	int beforeIdx = 0, currentIdx = 0;
	
	for (int i = 0; i < skill_trees.length; i++) {
		/* 2 
		beforeIdx = skill_trees[i].indexOf(skill.charAt(0));
		
		/* 3 
		for (int j = 1; j < skill.length(); j++) {
			/* 4 
			currentIdx = skill_trees[i].indexOf(skill.charAt(j));
			/* 5 
			if((beforeIdx > currentIdx && currentIdx != -1) || (beforeIdx == -1 && currentIdx != -1)) {
				answer--;
				break;
			} 
			/* 6 
			beforeIdx = currentIdx;
		}
	}

	return answer;
}
 * */
