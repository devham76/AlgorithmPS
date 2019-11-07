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
		
		fun(begin, 0, visited, words, target);
		System.out.println(answer);
		return answer;
	}
	public static void fun(String begin, int cnt, boolean[] visited, String[] words, String target) {
		// �� �ܾ��� �ѱ��ھ� �����ϹǷ�, ���ڼ���ŭ ����.
		for (int i=0; i<begin.length(); i++) {
			
			String s1 = begin.substring(0, i) + begin.substring(i+1, begin.length());

			for(int j=0; j<words.length;  j++) {
				String s2 = words[j].substring(0, i) + words[j].substring(i+1, words[j].length());
				if(visited[j] == true)
					continue;
				// �ѱ��ڸ� ������ �δܾ ���ٸ�
				if(s2.equals(s1)) {
					// ���ϴ� ���ڰ� Ÿ���̶��  �� ��
					if(words[j].equals(target)) {
						answer = (answer == 0 ) ? cnt+1 : (answer > cnt+1) ? cnt+1 :answer;
						System.out.println("---->"+answer);
					}
					else {
						
						visited[j] = true;
						fun(words[j], cnt+1, visited, words, target);
						visited[j] = false;
					}
				}
			}
		}

	}

}
