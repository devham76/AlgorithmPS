package org.line;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] locations = new int[num];
        
        for(int i=0; i<num; i++) {
        	locations[i] = Integer.parseInt(sc.next());
        }

        int[][] seat = new int[num][2];
        
        for(int i=1; i<num-1; i++) {
        	for(int x=i-1; x>=0; x--) {
        		if(locations[x]==1) {
        			seat[i][0] = x;
        		}
        	}
        	for(int y=i+1; y<num; y++) {
        		if(locations[y]==1) {
        			seat[i][1] = y;
        		}
        	}
        }
        
        int[] seatD = new int[num];
        int index = 0;
        int difference;
        for(int i=1; i<num; i++) {
        	seatD[i] = seat[i][0] - seat[i][1];
        	if(seatD[i] <0) seatD[i] = seatD[i] * -1 ;
        	//if (difference == )
        		
        }
	}

}
