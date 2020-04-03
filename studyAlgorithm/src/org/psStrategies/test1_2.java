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
		int groupIdx = k-1;	// 매표소에 들어가고있는 그룹의 수
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			people += arr[i];
		}
		// base, k매표소에 그룹의 사람수입력
		int[] ticketbox = new int[k];
		for (int i = 0; i < k; i++) {
			ticketbox[i] = arr[i];
		}
		
		int time = 0;
		while(people > 0) {
			time++;
			for(int i = 0; i<k; i++) {
				//System.out.println("before time="+time+" i="+i+" ticketbox[i]="+ticketbox[i]+" groupIdx="+groupIdx+" people="+people);
				
				// 매표소에 사람이 없고, 매표소에 들어갈 그룹이 남아있다면.
				if(ticketbox[i] == 0 && groupIdx < n-1) {
					ticketbox[i] = arr[++groupIdx]-1;	// 매표소에 다음 그룹이 들어가기시작하고, 한명 삭제된다.
					people--;	
				}// 매표소에 아직 사람이 있다면
				else if(ticketbox[i] > 0 ) {
					ticketbox[i]--;
					people--;
				}
			}
			
			
		}
		System.out.println(time);
	}

}
