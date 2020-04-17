package org.baekjoon;

public class Level2_49993 {

	public static void main(String[] args) {
		String[] t = { "BACDE", "CBADF", "AECB", "BDA" };
		solution("CBD", t);

	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;

		int search_case = 0;
		while (search_case < skill_trees.length) {
			String now_skill = skill_trees[search_case++];
			boolean is_possible = true;
			int skill_idx = 0;

			for (int i = 0; i < now_skill.length(); i++) {
				char s = now_skill.charAt(i);

				// 조사해야 하는 스킬이라면
				if (skill.contains(s + "")) {
					if (s == skill.charAt(skill_idx)) {
						skill_idx++;
					}
					else {
						is_possible = false;
						break;
					}
				}
			}
			
			if(is_possible == true) {
				System.out.println("now_skill="+now_skill);
				answer++;
			}

		}
		
		System.out.println(answer);
		return answer;
	}

}
