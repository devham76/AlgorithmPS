package org.programmers;
import java.util.*;
public class Test0921_skilltree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		solution(skill, skill_trees);
	}
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
    	Queue<Character> sQ = new LinkedList<Character>();
    	Queue<Character> stQ = new LinkedList<Character>();
    	Queue<Character> tmpQ = new LinkedList<Character>();
    	
    	for(int i=0; i<skill_trees.length; i++) {
    		System.out.println("start");
    		sQ.clear();
    		stQ.clear();
    		for(int j=0; j<skill.length(); j++)
    			sQ.offer(skill.charAt(j));

    		System.out.println("---");
    		
    		for(int j=0; j<skill_trees[i].length(); j++) {
    			System.out.print(skill_trees[i].charAt(j)+" ");
        		stQ.offer(skill_trees[i].charAt(j));
    		}
    		
    		
			Character firstSkill = sQ.poll();
			Character treesSkill = stQ.poll();  	
			System.out.println(" ");
    		while(!stQ.isEmpty()) {
    			System.out.print("firstSkill =>"+firstSkill+" / treesSkill=>"+treesSkill+" \n");
    			if (firstSkill != treesSkill) {
    				firstSkill = sQ.poll(); 
    				treesSkill = stQ.poll();  	
    				tmpQ.offer(treesSkill);
    			}else {
    				tmpQ.poll();
    			}
    			
    			if(firstSkill == treesSkill) {
    				firstSkill = sQ.poll();
    				stQ.poll();
    			}
    			else
    				treesSkill = stQ.peek();
    		}
    		
        	if(!sQ.isEmpty())
        		System.out.println("실패");
        	else if(sQ.isEmpty() || (sQ.isEmpty()&&stQ.isEmpty()))
        		System.out.println("성공");
        }
        return answer;
    }

}
