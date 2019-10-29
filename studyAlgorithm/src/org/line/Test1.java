package org.line;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int messageNum  = sc.nextInt();
        int consumerNum = sc.nextInt();

        Queue<Integer> message  = new LinkedList<Integer>();
        int[] consumer = new int[consumerNum];
        
        for(int i=0; i<messageNum; i++) {
        	int n = sc.nextInt();
        	message.add(n);
        }
        for(int i=0; i<consumerNum; i++)
        	consumer[i] = 0;

        for(int i=0; i<consumerNum; i++) {
        	consumer[i] = message.poll();
        }
        
        
        int time = 1;
        while(true) {
        	int all=0;
        	for(int i=0; i<consumerNum; i++) {
        		
        		if(consumer[i] != 0) {
        			consumer[i]--;
        			if(consumer[i]==0 && !message.isEmpty()) 
        				consumer[i] = message.poll();
        		}
        		else if(consumer[i] == 0 && !message.isEmpty()){
        			consumer[i] = message.poll();
        		}
        		all += consumer[i];

        	}
        	time++;
        	if(all==0)
        		break;
        }
        System.out.println("----");
        System.out.println("time ; "+time);
        
        for(int i=0; i<consumerNum; i++) {
        	System.out.println("consumer["+i+"] :"+consumer[i]);
        
        }
	}


}
