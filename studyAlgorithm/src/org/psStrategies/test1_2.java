package org.psStrategies;

import java.util.Arrays;
import java.util.Scanner;

public class test1_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 그룸개수 5
		int k = sc.nextInt(); // 매표소 개수 2
		int[] arr = new int[n];
		int people = 0;		// 전체사람수
		int groupIdx = k-1;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			people += arr[i];
		}
		Arrays.sort(arr);
		int[] ticketbox = new int[k];
		for (int i = 0; i < k; i++) {
			ticketbox[i] = arr[i];
		}
		int time = 0;
		while(people > 0) {
			time++;
			//System.out.println();
			for(int i = 0; i<k; i++) {
				//System.out.println("before time="+time+" i="+i+" ticketbox[i]="+ticketbox[i]+" groupIdx="+groupIdx+" people="+people);
				if(ticketbox[i] == 0 && groupIdx < n-1) {
					groupIdx++;
					ticketbox[i] = arr[groupIdx]-1;
					people--;
				}
				else if(ticketbox[i] > 0 ) {
					ticketbox[i]--;
					people--;
				}
				//System.out.println("after time="+time+" i="+i+" ticketbox[i]="+ticketbox[i]+" groupIdx="+groupIdx+" people="+people);
				
			}
			
			
		}
		System.out.println(time);
	}

}
