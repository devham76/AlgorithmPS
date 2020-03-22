https://www.acmicpc.net/problem/6064s
package org.tryAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test6064 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		
		while(test_case > 0) {
			test_case --;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			int x=0, y=0, year=0;
			while( !(endX == x && endY == y) ) {
				year++;
				x++;
				y++;
				if(x > M) x = 1;
				if(y > N) y = 1;
				
				//System.out.println("("+x+", "+y+") year="+year );
				if(x==1 && y==1 && year > 1) {
					year = -1;
					break;
				}
			}
			
			System.out.println(year);
		}

	}

}
