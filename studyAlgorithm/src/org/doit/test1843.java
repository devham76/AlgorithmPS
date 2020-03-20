package org.doit;

import java.util.ArrayList;
import java.util.List;

public class test1843 {

	public static void main(String[] args) {
		String[] arr = {"5", "-", "3", "+", "1", "+", "2", "-", "4" };
		String[] arr2 = {"5", "-", "6","-","4","-","5"};
		solution(arr2);

	}
	public static int solution(String arr[]) {
		int answer = 0;
		List<Integer> minus = new ArrayList<>();
		List<Integer> pluse = new ArrayList<>();
		String str = "";
		for(int i=0; i<arr.length; i++) {
			str += arr[i];
		}
		String[] part = str.split("\\-");
		for(int i=part.length-1; i>0; i--) {
			System.out.println("**"+part[i]+" i="+i);
			int part1 = make_int(part[i]);
			int part2 = make_int(part[i-1]);
			
			
			
			if(i == 2) {
				System.out.println("part2="+part2+" part1="+part1);
				if (part2 > part1 )
					part[i-1] = (part2-part1) + "";
				
			}
			else if(i==1) {
				part[i-1] = (part2-part1) + "";
			}
			else 
				part[i-1] = (part1+part2) + "";
			System.out.println(part1+" "+part2+"  / part[i-1]="+part[i-1]);
			//part[i-1] = part1-part2+"";
		}
		System.out.println(part[0]);
		answer = Integer.parseInt(part[0]);
		return answer;
	}
	private static int make_int(String str) {
		String[] part = str.split("\\+");
		int sum = 0;
		for(int i=0; i<part.length; i++) {
			System.out.println("->"+part[i]);
			sum += Integer.parseInt(part[i]);
		}
		return sum;
	}
	
}
