package org.programmers;

public class Level3_beginTarget_43163 {

	public static void main(String[] args) {
		String b = "hit";
		String t = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

		solution(b,t,words);
	}
	static int answer = 0;
	public static int solution(String begin, String target, String[] words) {
		
		boolean[] visited = new boolean[words.length];
		int nowCnt = 0;
		answer = words.length;
		// 한글자씩 변경하므로, 글자수만큼 돈다.
		fun(begin, 0, visited, words, target);
		System.out.println(answer);
		return answer;
	}
	public static void fun(String begin, int cnt, boolean[] visited, String[] words, String target) {

		for (int i=0; i<begin.length(); i++) {
			String s1 = begin.substring(0, i) + begin.substring(i+1, begin.length());
			
			for(int j=0; j<words.length;  j++) {
				String s2 = words[j].substring(0, i) + words[j].substring(i+1, words[j].length());
				String s3 = target.substring(0, i) + target.substring(i+1, target.length());
				System.out.println("s1: "+s1+", s2: "+s2);
				if(visited[j] == true)
					continue;
				if(s3.equals(s1)) {
					cnt+= 1;
					break;
				}
				if(s2.equals(s1)) {
					System.out.println(words[j]);
					visited[j] = true;
					cnt += 1;
					fun(words[j], cnt, visited, words, target);
					visited[j] = false;
				}
			}
		}
		if (cnt < answer)
			answer = cnt;
		
	}

}
