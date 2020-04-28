package org.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class kakao_64064_2 {

	public static void main(String[] args) {
		String[] u = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] b = { "fr*d*", "*rodo", "******", "******" };
		solution(u, b);

	}

	static boolean[] visit;
	static ArrayList<String> list = new ArrayList<>();
	static HashSet<String> set;
	static ArrayList<HashSet> result = new ArrayList<>();

	public static int solution(String[] user_id, String[] banned_id) {
		Arrays.sort(banned_id);
		for (int i = 0; i < banned_id.length; i++) {
			banned_id[i] = banned_id[i].replace("*", ".");
		}
		visit = new boolean[user_id.length];
		dfs(banned_id, user_id, 0);

		int answer = result.size();
		
		for(HashSet str : result)
			System.out.println(str);
		System.out.println("answer ==="+answer);
		return answer;
	}

	static void dfs(String[] banned_id, String[] user_id, int idx) {
		
		if (idx == banned_id.length) {
			set = new HashSet<>();
			set.addAll(list);

			boolean flag = true;
			// 같은 아이디로 이루어진 조합있는지 체크
			for (HashSet str : result) {
				if (str.containsAll(list))
					flag = false;
			}
			if (flag)
				result.add(set); // 없는 경우

			return;
		}
		Pattern idPattern = Pattern.compile(banned_id[idx]);
		for (int i = 0; i < user_id.length; i++) {
			Matcher matcher = idPattern.matcher(user_id[i]);

			// 정규식 표현에 맞는 문자
			if (matcher.matches() && !visit[i]) {
				list.add(user_id[i]);
				visit[i] = true;
				dfs(banned_id, user_id, idx + 1);
				visit[i] = false;
				list.remove(idx);
			}
		}
	}
}
