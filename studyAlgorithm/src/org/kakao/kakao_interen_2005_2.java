package org.kakao;

import java.util.ArrayList;
import java.util.List;

public class kakao_interen_2005_2 {

	public static void main(String[] args) {
		String e = "100-200*300-500+20";
		solution(e);
	}

	static char[][] express;
	static int chcount = 0;
	static List<Character> exp = new ArrayList<>();
	public static long solution(String expression) {
		long answer = 0;
		List<Integer> num = new ArrayList<>();
		List<Character> ch = new ArrayList<>();

		String str = "";
		for (int i = 0; i < expression.length(); i++) {

			char c = expression.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				if(!exp.contains(c)) {
					exp.add(c);
				}
				
				ch.add(c);
				if (str.length() > 0)
					num.add(Integer.parseInt(str));
				str = "";
			} else {
				str += c;
			}
		}

		chcount = exp.size();
		// 경우의 수 조합
		get_express();

		for (Integer n : num) {
			System.out.print(n + " ");
		}
		for (Character c : ch) {
			System.out.print(c + " ");
		}
		return answer;
	}

	static boolean[] visited;
	static int num = 0;
	private static void get_express() {
		
		int cnt = chcount == 3 ? 6 : chcount;
		express = new char[cnt][chcount];
		visited = new boolean[chcount];
		for(int i=0; i<chcount; i++) {
			char[] arr = new char[chcount];
			System.out.println("num="+num);
			 express(i, 0, arr);
		}
		for(int i=0; i<cnt; i++) {
			for(int j=0; j<chcount; j++) {
				System.out.print(express[i][j]+ " ");
			}
			System.out.println();
		}
	}

	private static char[] express(int start, int count, char[] arr) {
		if(count == chcount) {
			System.out.println("---");
			for(Character a:arr) {
				System.out.print(a+" ");
			}
			System.out.println();
			express[num] = arr;
			num++;
			return arr;
		}
		for(int i = start; i<chcount; i++) {
			if(visited[i] == false) {
				System.out.println("count="+count+", "+exp.get(i));
				arr[count] = exp.get(i);
				visited[i] = true;
				express(start+1, count+1, arr);
				visited[i] = false;
			}
		}
		return arr;
		
	}
}
