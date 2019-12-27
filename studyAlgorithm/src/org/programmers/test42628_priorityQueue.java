package org.programmers;

import java.util.ArrayList;
import java.util.Collections;

public class test42628_priorityQueue {

	public static void main(String[] args) {
		test42628_priorityQueue t = new test42628_priorityQueue();
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		t.solution(operations);
		String[] o2 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		t.solution(o2);

	}
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        ArrayList<Integer> alist = new ArrayList<>();
        
        char commend;
        int insert;
        for(int i=0; i<operations.length; i++) {
        	commend = operations[i].charAt(0);
        	insert = Integer.parseInt(operations[i].substring(2));
        	
        	if(commend == 'I') {
        		alist.add(insert);
        		Collections.sort(alist);
        	}
        	else if (commend == 'D' && insert == -1 && alist.size() > 0) 	// ÃÖ¼Ú°ª»èÁ¦
        		alist.remove(0);
        	else if (commend == 'D' && insert == 1 && alist.size() > 0) 	// ÃÖ´ñ°ª»èÁ¦
        		alist.remove(alist.size()-1);
        		
        }
        if(alist.size() > 0) {
        	answer[1] = alist.get(0); 
        	answer[0] = alist.get(alist.size()-1);
        }

        	System.out.println(answer[0]+","+answer[1]);
        return answer;
    }
}
