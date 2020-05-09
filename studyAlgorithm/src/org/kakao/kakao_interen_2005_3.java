package org.kakao;

import java.util.HashSet;

public class kakao_interen_2005_3 {

	public static void main(String[] args) {
		String[] g = { "XYZ", "XYZ", "XYZ" };
		solution(g);
	}

	public static int[] solution(String[] gems) {
		int[] answer = new int[2];
		HashSet<String> hs = new HashSet<>();
		int allcnt = 0;
		
		for(int i=0; i<gems.length; i++) {
			if(!hs.contains(gems[i])) {
				hs.add(gems[i]);
				allcnt++;
			}
		}
		int min = gems.length;
		for(int i=0; i<gems.length; i++) {
			int cnt = 0;
			hs = new HashSet<>();
			int j=i; 
			for(; j<gems.length; j++) {
				if(!hs.contains(gems[j])) {
					hs.add(gems[j]);
					cnt++;
				}
				if(allcnt == cnt) {
					System.out.println("j="+j+" i="+i+" min="+min);
					break;
				}
			}
			
			if (j-i < min && allcnt == cnt) {
				min = j-i;
				System.out.println(min);
				answer[0] = i+1;
				answer[1]= j+1;
				
			}
		}
		System.out.println("all="+allcnt + " start="+answer[0]+" end="+answer[1]);
		return answer;
	}
}
