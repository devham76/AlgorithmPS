package org.kakao;
// ¿Ï·á
import java.util.ArrayList;

public class kakao_intern_2020_2 {

	public static void main(String[] args) {
		String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		solution(s2);

	}
	public static int[] solution(String s) {
		String[] s1 = s.split("}\\,\\{"); 
		int[][] arr = new int[s1.length][s1.length];
		int[] answer = new int[s1.length];
		for (int i = 0; i < s1.length; i++) {
			s1[i] = s1[i].replace("{{", "");
			s1[i] = s1[i].replace("}}", "");
			String[] splitS = s1[i].split(",");

			for (int j=0; j < splitS.length; j++) {
				arr[ splitS.length-1 ][j] = Integer.parseInt( splitS[j] );
			}

		}

		answer[0] = arr[0][0];
		for (int k=1; k<arr.length; k++) {
			for (int i=k; i<arr.length; i++) {
				for (int j=0; j<arr.length; j++) {
					if (arr[i][j] == answer[k-1])
						arr[i][j] = 0;
				}
			}
			
			for (int i=k; i<arr.length; i++) {
				for (int j=0; j<arr.length; j++) {
					if (arr[i][j] != 0) {
						answer[k] = arr[i][j];
						break;
					}
				}
				if(answer[k] !=0)
					break;
			}
		}
		return answer;
	}
}
