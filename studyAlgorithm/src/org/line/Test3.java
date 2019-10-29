package org.line;
import java.util.ArrayList;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] persons = new int[num][2];
        
        
        for(int i=0; i<num; i++) {
        	persons[i][0] = Integer.parseInt(sc.next());
        	persons[i][1] = Integer.parseInt(sc.next());
        }
        
        int time = 0;
        int[] timeList = new int[150];
        
        int isOver=0;
        while (isOver!=num) {
        	for(int i=0; i<num; i++) {
        		if(persons[i][0]<= time && persons[i][1]>=time) {
        			if(persons[i][0] == persons[i][1]) {
            			isOver++;
            		}
        			else {
        				persons[i][0]++;			
        				timeList[time]++;
        			}
        		}
        	}
        	time++;
        }
         
        int max = 0;
        for(int i=0; i<timeList.length;i++) {
        	if(max < timeList[i])
        		max = timeList[i];
        }
    }

}
