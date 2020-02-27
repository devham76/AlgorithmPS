package org.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class test1343_greedy_Polyomino {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		input += ".";
		List<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int xNum = 0;
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) == 'X' ) {
				xNum++;
			}
			else if(input.charAt(i) == '.' ){
				
				if(xNum > 0 ) { 
				
					// X가 홀수개일때 실패
					if( xNum%2 !=0) {
						System.out.println("-1");
						break;
					}
					else {
						while (xNum > 0) {
							if(xNum >= 4) {
								sb.append("AAAA");
								xNum -= 4;
							}
							else if (xNum >=2) {
								sb.append("BB");
								xNum -= 2;
							}
						}
						if(i != input.length()-1)
							sb.append(".");
					}
				
				}
				else if(i != input.length()-1 && xNum == 0 ) { 
					sb.append(".");
					continue;
				}
				if(i == input.length()-1)
					System.out.println(sb);
				
			}
		}
		
		
		
			
	}

}
